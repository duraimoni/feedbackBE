package com.atos.feedback.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.feedback.model.Domain;
import com.atos.feedback.model.ProdRating;
import com.atos.feedback.model.Product;
import com.atos.feedback.model.Rating;
import com.atos.feedback.model.User;
import com.atos.feedback.repository.DomainRepository;
import com.atos.feedback.repository.ProductRatingRepository;
import com.atos.feedback.repository.ProductRepository;
import com.atos.feedback.repository.RatingRepository;
import com.atos.feedback.repository.UserRepository;
import com.atos.feedback.vo.DomainVO;
import com.atos.feedback.vo.ProductRateVO;
import com.atos.feedback.vo.ProductVO;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	DomainRepository domainRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRatingRepository productRatingRepository;
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	ExcelExportUtil excelExportUtil;

	@Autowired
	UserService userService;
 

	@Override
	public String addProduct(ProductVO productVo) {
		if (productVo.getProductId() < 0) {
			productVo.setProductId(null);
		}
		Product product = new Product();
		BeanUtils.copyProperties(productVo, product);
		Domain domain = domainRepository.findById(productVo.getDomainId()).orElse(new Domain());
		User user3 = userRepository.findById(new Long(productVo.getProductLeaderId())).orElse(new User());
		User user4 = userRepository.findById(new Long(productVo.getProductManagerId())).orElse(new User());
		product.setDomain(domain);
		product.setUser3(user3);
		product.setUser4(user4);
		product.setUpdby(1);
		product = productRepository.save(product);
		
		//add prodRating as well
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();

		ProdRating prodRating = new ProdRating();
		prodRating.setMonth(cal.MONTH);
		prodRating.setYear(cal.YEAR);
		prodRating.setComment("");
		prodRating.setStatus(1);
		prodRating.setProduct(product);
		prodRating.setRating(null);
		prodRating.setUpdby(1);
		productRatingRepository.save(prodRating);
		
		return null;
	}

	@Override
	public List<ProductVO> getProductsBuDomain(Long domainId, Long userId) {
		Domain domain = new Domain();
		domain.setDomainId(domainId);
		List<Product> productLst = productRepository.findByDomain(domain);
		if (userId > 0) {
			productLst = filterLst(productLst, userId);
		}
		return buildProduct(productLst);
	}

	private List<Product> filterLst(List<Product> productLst, Long userId) {
		List<String> roleLst = userService.getCurrentUserRoles(userId);
		List<Product> productLstN = new ArrayList<>();
		if (!this.userService.isAdmin(roleLst)) {
			productLstN = productLst.stream().filter(
					product -> (product.getUser3().getUserId() == userId || product.getUser4().getUserId() == userId))
					.collect(Collectors.toList());
			return productLstN;
		}

		return productLst;

	}

	private List<ProductVO> buildProduct(List<Product> productLst) {
		List<ProductVO> productVOLst = new ArrayList<>();
		productLst.forEach(product -> {
			ProductVO productVo = new ProductVO();
			DomainVO domainVo = new DomainVO();
			ProductRateVO productRateVO = new ProductRateVO();
			BeanUtils.copyProperties(product, productVo);
			BeanUtils.copyProperties(product.getDomain(), domainVo);
			productVo.setDomainVo(domainVo);
			productVo.setProductLeader(product.getUser3().getFirstName());
			productVo.setProductLeaderEmail(product.getUser3().getEmail());
			productVo.setProductManager(product.getUser4().getFirstName());
			if (product.getProdRatings() != null && !product.getProdRatings().isEmpty()) {
				if(product.getProdRatings().get(0).getRating() !=null) {
					productRateVO.setRating(product.getProdRatings().get(0).getRating().getRatingNo() );
				} else {
					productRateVO.setRating(0);
				}
				productRateVO.setMonth(product.getProdRatings().get(0).getMonth());
				productRateVO.setYear(product.getProdRatings().get(0).getYear());
				productRateVO.setComment(product.getProdRatings().get(0).getComment());
			}
			productVo.setProductRateVO(productRateVO);
			productVOLst.add(productVo);
		});
		return productVOLst;
	}

	@Override
	public List<ProductVO> findAll(Long userId) {
		List<Product> productLst = productRepository.findAllrate(1, 2019);
		productLst = filterLst(productLst, userId);
		return buildProduct(productLst);
	}

	@Override
	public ProductVO findById(Long productId) {
		Product product = productRepository.findById(productId).orElse(new Product());
		ProductVO productVo = new ProductVO();
		DomainVO domainVo = new DomainVO();
		BeanUtils.copyProperties(product, productVo);
		BeanUtils.copyProperties(product.getDomain(), domainVo);
		productVo.setProductLeaderId(product.getUser3().getUserId());
		productVo.setProductManagerId(product.getUser4().getUserId());
		productVo.setDomainId(product.getDomain().getDomainId());
		productVo.setDomainVo(domainVo);
		return productVo;
	}

	@Override
	public void delete(Long productId) {
		productRepository.updateStatus(productId);
	}

	@Override
	public void rateProduct(ProductRateVO productRateVO) {
		ProdRating prodRating = new ProdRating();
		BeanUtils.copyProperties(productRateVO, prodRating);
		Product product = productRepository.findById(productRateVO.getProductId()).orElse(new Product());
		prodRating.setProduct(product);
		Rating rating = ratingRepository.findById(new Long(productRateVO.getRating())).orElse(new Rating());
		prodRating.setRating(rating);
		productRatingRepository.save(prodRating);
	}

	private String getExportCriteria(Long userId) {
		User user = userRepository.findById(userId).orElse(new User());
		String retVal = "";
		boolean isAdmin = user.getRoles().stream().anyMatch(role -> (role.getRole().equals("APP_ADMIN")
				|| role.getRole().equals("RENAULT_ADMIN") || role.getRole().equals("ATOS_ADMIN")));
		if (isAdmin) {
			retVal = "ADMIN";
		} else if (user.getRoles().stream()
				.anyMatch(role -> (role.getRole().equals("DOMAIN_LEAD") || role.getRole().equals("DOMAIN_MANAGER")))) {
			retVal = "DOMAIN";
		} else if (user.getRoles().stream()
				.anyMatch(role -> (role.getRole().equals("PROD_LEADER") || role.getRole().equals("PROD_MANAGER")))) {
			retVal = "PRODUCT";
		}
		return retVal;
	}

	@Override
	public ByteArrayInputStream exportProduct(Long userId) throws IOException {
		List<Product> productLst = productRepository.findAll();
		String criteria = this.getExportCriteria(userId);
		List<Product> productLstN = new ArrayList<>();
		if (criteria.equals("DOMAIN")) {
			productLstN = productLst.stream().filter(prod -> (prod.getDomain().getUser().getUserId() == userId))
					.collect(Collectors.toList());
		} else if (criteria.equals("PRODUCT")) {
			productLstN = productLst.stream()
					.filter(prod -> (prod.getUser3().getUserId() == userId || prod.getUser4().getUserId() == userId))
					.collect(Collectors.toList());
		} else {
			productLstN = productLst;
		}

		return excelExportUtil.exportProduct(productLstN);
	}
}
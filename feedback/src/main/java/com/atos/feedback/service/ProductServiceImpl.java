package com.atos.feedback.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String addProduct(ProductVO productVo) {
		if (productVo.getProductId() < 0) {
			productVo.setProductId(null);
		}
		Product product = new Product();
		BeanUtils.copyProperties(productVo, product);
		Domain domain = domainRepository.findById(productVo.getDomainId()).orElse(new Domain());
		User user = userRepository.findById(new Long(productVo.getProductLeaderId())).orElse(new User());
		product.setDomain(domain);
		product.setUser(user);
		product.setUpdby(1);
		productRepository.save(product);
		return null;
	}

	@Override
	public List<ProductVO> getProductsBuDomain(Long domainId) {
		Domain domain = new Domain();
		domain.setDomainId(domainId);
		List<Product> productLst = productRepository.findByDomain(domain);
		return buildProduct(productLst);
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
			productVo.setProductLeader(product.getUser().getFirstName());
			if (product.getProdRatings() != null && !product.getProdRatings().isEmpty()) {
				productRateVO.setRating(product.getProdRatings().get(0).getRating().getRatingNo());
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
	public List<ProductVO> findAll() {
		List<Product> productLst = productRepository.findAllrate(1, 2019);
		return buildProduct(productLst);
	}

	@Override
	public ProductVO findById(Long productId) {
		Product product = productRepository.findById(productId).orElse(new Product());
		ProductVO productVo = new ProductVO();
		DomainVO domainVo = new DomainVO();
		BeanUtils.copyProperties(product, productVo);
		BeanUtils.copyProperties(product.getDomain(), domainVo);
		productVo.setProductLeaderId(product.getUser().getUserId());
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
}
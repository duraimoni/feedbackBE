package com.atos.feedback.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.atos.feedback.model.Product;

@Component
public class ExcelExportUtil {
	public static String[] PRODUCT_COLUMNS = { "Product name", "Product Code", "Domain name", "Direction", "Month",
			"Rating", "Comment" };

	public ByteArrayInputStream exportProduct(List<Product> productLst) throws IOException {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("products");
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			Row headerRow = sheet.createRow(0);
			int prodLength = PRODUCT_COLUMNS.length;
			// Header
			for (int col = 0; col < prodLength; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(PRODUCT_COLUMNS[col]);
				cell.setCellStyle(headerCellStyle);
			}
			AtomicInteger counter = new AtomicInteger(1);
			productLst.stream().forEach(product -> {
				product.getProdRatings().stream().forEach(rating -> {
					Row row = sheet.createRow(counter.getAndIncrement());
					row.createCell(0).setCellValue(product.getProductName());
					row.createCell(1).setCellValue(product.getProductDescrption());
					row.createCell(2).setCellValue(product.getDomain().getDomainName());
					row.createCell(3).setCellValue(product.getDomain().getDomainDesc());
					row.createCell(4).setCellValue(rating.getMonth());
					row.createCell(5).setCellValue(rating.getRating() + "");
					row.createCell(6).setCellValue(rating.getComment());
				});
			});

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}

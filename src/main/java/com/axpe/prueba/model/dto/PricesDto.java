package com.axpe.prueba.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PricesDto {

	private Long productId;
	private Long brandId;
	private Long priceList;
	private Date startDate;
	private Date endDate;
	private BigDecimal price;

	public PricesDto(Long productId, Long brandId, Long priceList, BigDecimal price, Date startDate, Date endDate) {
		this.productId = productId;
		this.brandId = brandId;
		this.priceList = priceList;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}

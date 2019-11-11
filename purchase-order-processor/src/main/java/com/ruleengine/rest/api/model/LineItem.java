package com.ruleengine.rest.api.model;

public class LineItem {

	private ProductCategory productCategory;
	private ProductType productType;
	private String productName;
	private boolean shippingSlipGenerated;

	public LineItem(ProductCategory productCategory, ProductType productType, String productName) {
		super();
		this.productCategory = productCategory;
		this.productType = productType;
		this.productName = productName;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isShippingSlipGenerated() {
		return shippingSlipGenerated;
	}

	public void setShippingSlipGenerated(boolean shippingSlipGenerated) {
		this.shippingSlipGenerated = shippingSlipGenerated;
	}
}

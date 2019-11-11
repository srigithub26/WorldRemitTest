package com.ruleengine.rest.api.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PurchaseOrder {

	private int id;
	private BigDecimal total;
	private Customer customer;
	private List<LineItem> lineItems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}

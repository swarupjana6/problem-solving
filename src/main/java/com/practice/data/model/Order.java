package com.practice.data.model;

public class Order {

	private String custName;
	private String ticker;
	private int quantity;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String custName, String ticker, int quantity) {
		this.custName = custName;
		this.ticker = ticker;
		this.quantity = quantity;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

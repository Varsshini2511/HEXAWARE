package com.hexaware.shopmart.entity;

import java.util.List;

public class Order {

	private String orderId;
	private List<Item> itemList;
	private double totalPrice;
	
	
	public Order(String orderId, List<Item> itemList) {
		super();
		this.orderId = orderId;
		this.itemList = itemList;
		this.totalPrice = calculateTotalPrice();
	}

	public Order(String orderId, List<Item> itemList,double totalPrice) {
		super();
		this.orderId = orderId;
		this.itemList = itemList;
		this.totalPrice = calculateTotalPrice();
	}

	public double calculateTotalPrice() {
        double sum = 0;
        for (Item item : itemList) {
            sum += item.getPrice();
        }
        return sum;
    }
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemList=" + itemList + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}

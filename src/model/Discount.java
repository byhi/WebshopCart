package model;

import java.util.List;

public abstract class Discount {
	private String discountName; 
	private Integer discountCost;
	
	public Discount() {
		super();
	}
	
	public Discount(String discountName) {
		super();
		this.discountName = discountName;
	}
	
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public Integer getDiscountCost() {
		return discountCost;
	}
	public void setDiscountCost(Integer discountCost) {
		this.discountCost = discountCost;
	}
	public abstract Integer countDiscount(List<? extends ProductInMegapack> list);
	
}

package model;

import java.util.List;

public class PayTwoGetThree extends Discount{
	private Integer actual;
	
	public PayTwoGetThree(String discountName, List<? extends ProductInMegapack> list, Integer actual) {
		super();
		this.actual = actual;
		super.setDiscountName(discountName);
		super.setDiscountCost(countDiscount(list));
	}

	@Override
	public Integer countDiscount(List<? extends ProductInMegapack> list) {
		// TODO Auto-generated method stub
		int discountCost = 0;
		for (ProductInMegapack product : list) {
			discountCost += 
					getMultiplier(product.getProductQuantity(), this.actual) * product.getProductCost();					
		}
		return discountCost;
	}
		
		
	/** Az osztó */
	public static Integer getMultiplier(int qty, int numberOfQty) {
		return qty-(qty/numberOfQty);
	}
	
	public Integer getActual() {
		return actual;
	}

	public void setActual(Integer actual) {
		this.actual = actual;
	}
	
}

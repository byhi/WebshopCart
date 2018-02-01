package model;

import java.util.ArrayList;
import java.util.List;

public class ActualDiscount {

List<Discount> discounts; 
	
	public ActualDiscount(List<? extends ProductInMegapack> list) {
		super();
		discounts = new ArrayList<Discount>();
		discounts.add(new Megapack("Megapack",list, 12, 6000));
		discounts.add(new PayTwoGetThree("Kettõt fizet, hármat kap", list, 3));		
		
	}

	public Discount actual() {
		Discount actual =  discounts.get(0);
		
		for (Discount discount : discounts) {
			if (discount.getDiscountCost()<actual.getDiscountCost()) {
				actual = discount;
			}
		}
		return actual;
	}
}

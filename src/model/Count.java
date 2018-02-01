package model;

import java.util.List;

public class Count {
	private Integer count;

	public static Integer getCount(List<? extends Product> list) {
		int value = 0;
		for (Product product : list) {
			value += product.getProductQuantity()*product.getProductCost();
		}
		return value;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}

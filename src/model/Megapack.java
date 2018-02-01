package model;

import java.util.List;

public class Megapack extends Discount{
	private Integer qtyOfPack;
	private Integer actual;
	
	
	
	public Megapack(String discountName, List<? extends ProductInMegapack> list, Integer qtyOfPack, Integer actual) {
		super();
		this.qtyOfPack = qtyOfPack;
		this.actual = actual;
		super.setDiscountName(discountName);
		super.setDiscountCost(countDiscount(list));
	}
	

	@Override
	public Integer countDiscount(List<? extends ProductInMegapack> list) {
		// TODO Auto-generated method stub
		int discountCost = 0;
		for (ProductInMegapack product : list) {
			int x =0;
			
		/*	discountCost += product.isMeagpack() ? 
					getBase(product.getProductQuantity(),product.getProductCost())-getDifference(product.getProductQuantity()) :
					getBase(product.getProductQuantity(),product.getProductCost());	*/
			
			if (product.isMeagpack()) {
				x = (getBase(product.getProductQuantity(),product.getProductCost())-getDifference(product.getProductQuantity()));
				
			} else {
				x = getBase(product.getProductQuantity(),product.getProductCost());
				
			}
			discountCost += x ;
			
		}
		
		return discountCost;
	}
	
	private Integer getDifference(int qty) {
		//System.out.println("( "+ qty+"/"+this.qtyOfPack+")*"+this.actual+"="+(qty/this.qtyOfPack)*this.actual);
		return (qty/this.qtyOfPack)*this.actual;
	}
	
	private static Integer getBase(int qty,int count) {
		return qty*count;
	}
	
	public Integer getQtyOfPack() {
		return qtyOfPack;
	}

	public void setQtyOfPack(Integer qtyOfPack) {
		this.qtyOfPack = qtyOfPack;
	}

	public Integer getActual() {
		return actual;
	}

	public void setActual(Integer actual) {
		this.actual = actual;
	}


	

}

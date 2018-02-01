package model;

public class ProductInMegapack extends Product{
	private boolean meagpack;

	public ProductInMegapack(String progname, int prodcost, int quantity, boolean meagpack) {
		super();
		this.setProductName(progname);
		this.setProductCost(prodcost);
		this.setProductQuantity(quantity);
		this.meagpack = meagpack;
		
	}

	public boolean isMeagpack() {
		return meagpack;
	}

	public void setMeagpack(boolean meagpack) {
		this.meagpack = meagpack;
	}

	@Override
	public String toString() {
		return "ProductInMegapack [meagpack=" + meagpack + "]";
	}
	
	
}

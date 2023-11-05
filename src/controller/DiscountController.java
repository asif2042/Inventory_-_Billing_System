package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class DiscountController {

	private Inventory inventory;
	private double totalPrice;
	private double totalDiscount;
	private double afterDiscountTotalPrice;
	private ArrayList<StockableProduct> selectedProductList;
	
	private String discountName;
	private double totalSpecialDiscount;
	
	public DiscountController(Inventory inventory) {
		this.inventory = inventory;
		selectedProductList = inventory.getItems();
		discountName = "Special Discount";
		totalSpecialDiscount = 0;
		
		
		for(StockableProduct p : selectedProductList) {
			totalPrice = p.getPrice();
			totalDiscount =   p.getPrice() * (p.getDiscount() / 100);			
		}
		
		
		afterDiscountTotalPrice = totalPrice - totalDiscount;
		
		
		if(isFullHouseDiscountAvailable(selectedProductList)  && afterDiscountTotalPrice > totalPrice/2){
			totalSpecialDiscount = totalPrice/2;
			afterDiscountTotalPrice = totalPrice - totalSpecialDiscount ; 
			discountName = "Full House (Discount)";
		}
		
		
	}
	
	
	public double getTotalSpecialDiscount() {
		
		
		
		
		return totalSpecialDiscount;
	}


	public void setTotalSpecialDiscount(double totalSpecialDiscount) {
		this.totalSpecialDiscount = totalSpecialDiscount;
	}


	public boolean isFullHouseDiscountAvailable(List<StockableProduct> selectedProductList) {
	    int movieCount = 0;
	    int musicCount = 0;
	    int gameCount = 0;

	    // Iterate over each product and update counts
	    for (StockableProduct product : selectedProductList) {

	    	String productType = product.getClass().getSimpleName();
	        switch (productType) {
	            case "Movie":
	                movieCount++;
	                break;
	            case "Music":
	                musicCount++;
	                break;
	            case "Game":
	                gameCount++;
	                break;
	        }
	    }

	    // Check if all categories have at least 2 products
	    return (movieCount >= 2 && musicCount >= 2 && gameCount >= 2);
	}


	public Inventory getInventory() {
		return inventory;
	}




	public double getTotalPrice() {
		return totalPrice;
	}


	

	public double getTotalDiscount() {
		return totalDiscount;
	}





	public double getAfterDiscountTotalPrice() {
		
		
		
		
		
		return afterDiscountTotalPrice;
	}



	public ArrayList<StockableProduct> getSelectedProductList() {
		return selectedProductList;
	}


	


	public String getDiscountName() {
		return discountName;
	}


	public double getAfterDiscountPrice(double price, double discount) {
		return price - (discount/100);
		
	}
	
	public double getDiscountAmount(double price, double discount) {
		return (price * (discount/100));
		
	}
	

	
}

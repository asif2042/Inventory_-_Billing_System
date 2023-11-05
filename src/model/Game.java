package model;

public class Game extends StockableProduct {

	private String devoloper;
	
	
	public Game(String name, double price, int productId, String genre, int yearPublished, 
	     double discount,int numberOfItemsStocked,String category, String developer) {
		
		   super(name, price, productId, genre, yearPublished, discount, numberOfItemsStocked, category);
		   this.devoloper = developer;
		

	}


	public String getDevoloper() {
		return devoloper;
	}


	public void setDevoloper(String devoloper) {
		this.devoloper = devoloper;
	}


	@Override
	public String toString() {
		return  getSpace()+ "Product Name :  "+ getName() + 
			"\n"+	getSpace()+ "Product Id :  " + getProductId() +
			"\n"+	getSpace()+ "Discount :  " + getDiscount() + "%" + 
			"\n"+	getSpace()+ "Price :  " + getPrice() + "  Tk" +
			"\n"+	getSpace()+ "Product Category :  " + getCategory()+ 
			"\n"+	getSpace()+ "Developer :  " + getCreator()+
			"\n"+	getSpace()+ "Year of Published :  " + getYearPublished()  ;
	}
	
	@Override
	public String getInfo() {
		return  toString();
	}

	
	
	
}

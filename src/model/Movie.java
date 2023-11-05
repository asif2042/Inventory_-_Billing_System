package model;

public class Movie extends StockableProduct {
    private String director;

	public Movie(String name, double price, int productId, String genre, int yearPublished, double discount,
			int numberOfItemsStocked, String category,String director) {
		super(name, price, productId, genre, yearPublished, discount, numberOfItemsStocked, category);
		this.director = director;
	
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return  getSpace()+ "Product Name :  "+ getName() + 
				"\n"+ getSpace()+ "Product Id :  " + getProductId() +
				"\n"+ getSpace()+ "Discount :  " + getDiscount() + "%" + 
				"\n"+ getSpace()+ "Price :  " + getPrice() + "  Tk" +
				"\n"+ getSpace()+ "Product Category :  " + getCategory()+ 
				"\n"+ getSpace()+ "Director :  " + getCreator()+
				"\n"+ getSpace()+ "Year of Published :  " + getYearPublished()  ;
	}
	
	
	@Override
	public String getInfo() {
		return toString();
	}	
		
		
   
}

package model;

public class Music extends StockableProduct {
   
	private String artistName;

	public Music(String name, double price, int productId, String genre, int yearPublished, double discount,
			int numberOfItemsStocked,String category, String artistName) {
		super(name, price, productId, genre, yearPublished, discount, numberOfItemsStocked, category);
		this.artistName = artistName;

	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return  getSpace()+ "Product Name :  "+ getName() + 
			"\n"+getSpace()+ "Product Id :  " + getProductId() +
			"\n"+getSpace()+ "Discount :  " + getDiscount() + "%" + 
			"\n"+getSpace()+ "Price :  " + getPrice() + "  Tk" +
			"\n"+getSpace()+ "Product Category :  " + getCategory()+ 
			"\n"+getSpace()+ "Artist :  " + getCreator()+
			"\n"+getSpace()+ "Year of Published :  " + getYearPublished()  ;
	}
	
	@Override
	public String getInfo() {
		return toString() ;
	}
	
	
}

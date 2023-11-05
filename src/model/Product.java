package model;

public abstract class Product {

	private String name;
    private double price;
    private int productId;
    private String genre;
    private int yearPublished;
    private double discount;
    
    
    
    
    public Product(String name, double price, int productId, String genre, int yearPublished, double discount) {
		super();
		this.name = name;
		this.price = price;
		this.productId = productId;
		this.genre = genre;
		this.yearPublished = yearPublished;
		this.discount = discount;
	}
    
    
    

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public String getGenre() {
		return genre;
	}




	public void setGenre(String genre) {
		this.genre = genre;
	}




	public int getYearPublished() {
		return yearPublished;
	}




	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public void setPrice(double price) {
		this.price = price;
	}

    public double getPrice() {
	        return price;
	}


	public abstract String getInfo();
    
   
}

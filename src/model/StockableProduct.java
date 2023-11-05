
package model;


public class StockableProduct extends Product implements Stockable {
	
		 private int numberOfItemsStocked;
		 private String category;
		 private String creator;
		 
		 
		 public StockableProduct(String name, double price, int productId, String genre, int yearPublished, double discount, int numberOfItemsStocked , String category) {
		     super(name, price, productId,  genre, yearPublished, discount);
		     this.numberOfItemsStocked =  numberOfItemsStocked;
		     this.category = category;
		 }
		 
		 
		
		public String getCategory() {
			return category;
		}



		public void setCategory(String category) {
			this.category = category;
		}



		public int getNumberOfItemsStocked() {
			return numberOfItemsStocked;
		}



		public void setNumberOfItemsStocked(int numberOfItemsStocked) {
			this.numberOfItemsStocked = numberOfItemsStocked;
		}
		
		
		public String getCreator() {
			
	
			    if (this instanceof Game) {
			        Game product  =  (Game) this;
			        creator = product.getDevoloper();// Cast to Game
			    } else if (this instanceof Music) {
			        Music product = (Music) this;
			        creator = product.getArtistName();// Cast to Music
			    } else if (this instanceof Movie) {
			    	Movie product = (Movie) this;
			    	creator = product.getDirector();
			    }
			
	
			return creator;
		}
		
		public void setCreator(String creator) {
			this.creator = creator;
		}



		@Override
		 public void addStock(int quantity) {
		     numberOfItemsStocked += quantity;
		 }
		
		 @Override
		 public void removeStock(int quantity) {
		     numberOfItemsStocked -= quantity;  // Add checks for negative values
		 }
		
		 @Override
		 public void editStock(int quantity) {
		     numberOfItemsStocked = quantity;
		 }

		@Override
		public String toString() {
			
			
			 return  getSpace()+ "Product Name :  "+ getName() + 
					 getSpace()+ "\nProduct Id :  " + getProductId() +
					 getSpace()+"\nDiscount :  " + getDiscount() + "%" + 
					 getSpace()+"\nPrice :  " + getPrice() + "  Tk" +
					 getSpace()+"\nProduct Category :  " + getCategory()+ 
					 getSpace()+"\nCreator :  " + getCreator()+
					 getSpace()+"\nYear of Published :  " + getYearPublished()  ;
		}



		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return toString();
		}
		
		public String getSpace() {
			String space = "                                                                                                              ";
			return space ;
		}

		
		 
 
 
 
}

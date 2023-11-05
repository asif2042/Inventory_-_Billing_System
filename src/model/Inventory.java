package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;









public class Inventory implements Iterable<StockableProduct> {

	
	
	
	    private ArrayList<StockableProduct> items;
	    private ArrayList<StockableProduct> gameItems;
	    private ArrayList<StockableProduct> movieItems;
	    private ArrayList<StockableProduct> musicItems;
	   
	    public Inventory() {
	        this.items = new ArrayList<>();
	        this.movieItems = new ArrayList<>();
	        this.musicItems = new ArrayList<>();
	        this.gameItems = new ArrayList<>();
	        
	    }
	
	    public void addItem(StockableProduct product) {
	        items.add(product);
	      
	    }
	
	    public void removeItem(int productId) {
	    	
	    	
	        // Removing from items list
	        Iterator<StockableProduct> itemsIterator = items.iterator();
	        while (itemsIterator.hasNext()) {
	            StockableProduct p = itemsIterator.next();
	            if (p.getProductId() == productId) {
	            	p.removeStock(1);
	                itemsIterator.remove();
	                break; // Assuming productId is unique, so break after removing
	            }
	        }
	 
	        // we don't need to manullay remove out categorylist as it will be updated soon
					        
					//   // Removing from movieItems list
					//   Iterator<StockableProduct> movieItemsIterator = movieItems.iterator();
					//   while (movieItemsIterator.hasNext()) {
					//       StockableProduct p = movieItemsIterator.next();
					//       if (p.getProductId() == productId) {
					//       	p.removeStock(1);
					//           movieItemsIterator.remove();
					//           break; // Assuming productId is unique, so break after removing
					//       }
					//   }
					//   
					//   // Removing from musicItems list
					//   Iterator<StockableProduct> musicItemsIterator = musicItems.iterator();
					//   while (musicItemsIterator.hasNext()) {
					//       StockableProduct p = musicItemsIterator.next();
					//       if (p.getProductId() == productId) {
					//           musicItemsIterator.remove();
					//           break; // Assuming productId is unique, so break after removing
					//       }
					//   }
				    //
					//   // Removing from gameItems list
					//   Iterator<StockableProduct> gameItemsIterator = gameItems.iterator();
					//   while (gameItemsIterator.hasNext()) {
					//       StockableProduct p = gameItemsIterator.next();
					//       if (p.getProductId() == productId) {
					//           gameItemsIterator.remove();
					//           break; // Assuming productId is unique, so break after removing
					//       }
					//   }
					        
	        
	        
	        
	        
	    }

	    
	    
	
	    public StockableProduct getItem(int productId) throws Exception {
	        for(StockableProduct p: items) {
	            if(p.getProductId() == productId)
	                return p;
	        }
	        throw new Exception("Product with ID " + productId + " not found.");
	    }

	
	    public void addProductStock(int productId, int quantity) {
	        
	    	for(StockableProduct p: items) {
	    		if(p.getProductId() == productId)
	    			p.addStock(quantity);
		        
	    	}
	    	
	    	
	            
	    }
	
	    
	    
	    
	    public void sortByPrice() {
	        items.sort(Comparator.comparingDouble(Product::getPrice));
	    }
	
	    public void sortByAvailableStock() {
	        items.sort(Comparator.comparingInt(p -> p.getNumberOfItemsStocked())); // Assuming numberOfItemsStocked is accessible; modify accordingly
	    }
	
	    @Override
	    public java.util.Iterator<StockableProduct> iterator() {
	        return items.iterator();
	    }
	    
	    public void categoryListUpdate() {
	    	musicItems.clear();
	    	movieItems.clear();
	    	gameItems.clear();
	    	for(StockableProduct p: items) {

	    		if(p.getCategory().equals("Movie") && p.getNumberOfItemsStocked() > 0) {
	    			movieItems.add(p);
	    		}
	    		else if(p.getCategory().equals("Music") && p.getNumberOfItemsStocked() > 0) {
	    			musicItems.add(p);
	    		}
	    		else if(p.getCategory().equals("Game") && p.getNumberOfItemsStocked() > 0) {
	    			gameItems.add(p);
	    		}
	    		
	    	}
	    	
	    	
	    }
	    
	    public ArrayList<StockableProduct> getCategoryList(String categoryName){
	    	if(categoryName.equals("Movie")) {
	    		
    			return movieItems;
	    	}
    		else if(categoryName.equals("Music")) {
    			return musicItems;
    		}
    		else if(categoryName.equals("Game")) {
    			return gameItems;
	    	
    		}
	    	return new ArrayList<>();
	    }
	    
	    public ArrayList<StockableProduct> getItems(){
	    	
	    	
	    	return items;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    //  Load Inventory from Database
	    
	   
	     public  void LoadInventory() {
	            String url = "jdbc:mysql://localhost:3306/asif";
	            String uname = "root";
	            String pass = "asif@570068";
	            String tableName = "melodymartwarehouse";

	            // Define the query to select all rows from the table
	            String query = "SELECT * FROM " + tableName;

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection con = DriverManager.getConnection(url, uname, pass);
	                Statement st = con.createStatement();
	                ResultSet rs = st.executeQuery(query);

	                while (rs.next()) {
	                    int id = rs.getInt("Id");
	                    String name = rs.getString("Name");
	                    double price = rs.getDouble("Price");
	                    double discount = rs.getDouble("Discount");
	                    int quantity = rs.getInt("Quantity");
	                    String category = rs.getString("Category");
	                    String genre = rs.getString("Genre");
	                    String creator = rs.getString("Creator");
	                    int year = rs.getInt("Year");

	                    // Create an Item object with the retrieved data
	                    if(category.equals("Movie")) {
	        				
	        				Movie movie = new Movie(name,price,id,genre,year,discount,quantity,category,creator);
	        				items.add(movie);
	        			}
	        			else if(category.equals("Music")) {
	        				Music music = new Music(name,price,id,genre,year,discount,quantity,category,creator);
	        				items.add(music);
	        			}
	        			else if(category.equals("Game")) {
	        				Game game = new Game(name,price,id,genre,year,discount,quantity,category,creator);
								items.add(game);
							
	        			}
	                    
	                }

	                st.close();
	                con.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	     
	     
	     
	     
	     // Update database 
	     
	     public  void updateDatabase() {
	    	 
	    	 
	    	 System.out.println("asifasifaisf");
	         String url = "jdbc:mysql://localhost:3306/asif";
	         String uname = "root";
	         String pass = "asif@570068";
	         String tableName = "melodymartwarehouse";
	         
	         
	         String deleteQuery = "DELETE FROM " + tableName;  // Delete all rows from the table

	         try {
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection(url, uname, pass);

	             // Disable auto-commit to group all changes into a single transaction
	             con.setAutoCommit(false);

	             // Delete all rows in the table
	             PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
	             deleteStatement.executeUpdate();

	             // Now insert the updated data
	             String insertQuery = "INSERT INTO " + tableName + " (Id, Name, Price, Discount, Quantity, Category, Genre, Creator, Year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	             PreparedStatement insertStatement = con.prepareStatement(insertQuery);

	             for (StockableProduct item : items) {
	                 insertStatement.setInt(1, item.getProductId());
	                 insertStatement.setString(2, item.getName());
	                 insertStatement.setDouble(3, item.getPrice());
	                 insertStatement.setDouble(4, item.getDiscount());
	                 insertStatement.setInt(5, item.getNumberOfItemsStocked());
	                 insertStatement.setString(6, item.getCategory());
	                 insertStatement.setString(7, item.getGenre());
	                 insertStatement.setString(8, item.getCreator());
	                 insertStatement.setInt(9, item.getYearPublished());
	                 insertStatement.executeUpdate();
	             }

	             // Commit the transaction to save the changes to the database
	             con.commit();

	             insertStatement.close();
	             deleteStatement.close();
	             con.close();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }
	    
  
   
	    
}



import model.*;

import javax.swing.JFrame;

import controller.*;
import view.*;


public class MainApp {

	public static void main(String[] args) {
		
		
        // Initialize the model.
        Inventory inventory = new Inventory(); 
        
 
    	
    	//Loading inventory list from database 
        
    	inventory.LoadInventory();
        
    	
    	
    	  
    	  MainFrame  mainFrame = new MainFrame(inventory);
          mainFrame.setLayout(null);
          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	  mainFrame.setBounds(150,0,1600,1000);
        
        // Initialize the controller, passing in the model.
        ShopController shopController = new ShopController(inventory, mainFrame);

        

        // Display the main frame.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               mainFrame.setVisible(true);
            }
        });
        
        
        
        
        // updating database
        
        inventory.updateDatabase();
        
        
   
  
        
        
       
    
        
    }

}

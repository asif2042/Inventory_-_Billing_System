package controller;


import javax.swing.JOptionPane;

import model.*;
import view.*;
public class ShopController {
	private Inventory inventory;
	private MainFrame  mainFrame;
	private LoginPanel loginPanel;
	private ProductPanel productPanel;
	private boolean validLogin;
	
	
	public ShopController(Inventory inventory, MainFrame mainFrame) {
	    validLogin = false;
	    this.inventory = inventory;

	    
	    
	    
	    
	    // for testing purposes
	      
	    //mainFrame.showProductPage();
	    //mainFrame.showWarehousePage();
	   
	   
	    
	    
	    
	    
    
		 loginPanel = new LoginPanel(new Callback() {
		     @Override
		     public void onLoginAttempt(boolean success) {
		         if (success) {
		             mainFrame.showHomePage();
		         } else {
		             JOptionPane.showMessageDialog(null, "Login Failed!");
		         }
		     }
		 });
		 
		 mainFrame.switchPanel(loginPanel);
	    
	    
	    
	}
	
	

}

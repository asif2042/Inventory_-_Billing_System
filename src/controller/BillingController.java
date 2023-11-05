package controller;


import java.awt.Color;

import javax.swing.JPanel;

import model.*;
import view.*;


public class BillingController {

	private Inventory inventory;
	private Inventory selectedProductInventory;
	private CartPanel cartPanel;
	private DiscountController discountController;
	private InvoicePanel invoicePanel;
	
	private MainFrame mainFrame;
	
	public BillingController(Inventory inventory, MainFrame mainFrame,Inventory selectedProductInventory) {
		this.selectedProductInventory = selectedProductInventory;  // this is actually selectedProductInventory reference
		this.mainFrame = mainFrame;
		this.inventory = inventory;
		
		discountController = new DiscountController(selectedProductInventory);
		
		cartPanel = new CartPanel(inventory, mainFrame,selectedProductInventory, discountController);
		mainFrame.switchPanel(cartPanel);
		
		
		
		
		
		
	}
	
	
	
}

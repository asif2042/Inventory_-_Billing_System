
package view;

import controller.*;
import model.*;




import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class MainFrame extends JFrame {
    
    
    
    private ShopController shopController; // This would be your controller
    private Inventory inventory;
    
    private ProductPanel selectedProductPanel;
    private ProductPanel movie,music,game;
    
    
    private WarehousePanel warehousePanel;
    private HomePanel homePanel;
    
    private CartPanel cartPanel;
    private JPanel currentPanel ;
    private JLabel shopName, shopLocation, quotes;  
    private JTabbedPane tabbedPane;
    
    private Inventory selectedProductInventory;
    
    
    
    
    
    public MainFrame(Inventory inventory) {
    	this.inventory = inventory;
    	selectedProductInventory = new Inventory();
    	
    }
    
    
    
    public void showHomePage() {
    	
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(40, 45, 55) );
        
       
        
        
        homePanel = new HomePanel(this);
        homePanel.setLayout(null);
        homePanel.setBackground(new Color(40,45,50));
        homePanel.setBounds(0,0, this.getWidth(), this.getHeight()); 
        contentPane.add(homePanel);        
        
        
        
        
     // Make the changes visible
        revalidate();
        repaint();
    	
    }
    
    
    
    
   
	public void showWarehousePage() {
		
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(10, 110, 120) );

      
        
        shopName = new JLabel("MelodyMart");
        shopName.setFont(Components.titleFont);
        shopName.setBounds(70,30, 200,50);
        shopName.setForeground(Color.black);
        
        
        shopLocation = new JLabel("Dhaka");
      
        shopLocation.setBounds(70,80, 200,10);
        shopLocation.setForeground(Color.black);
	        
        quotes = new JLabel("Happy Shopping!");
        quotes.setFont(Components.regularFont);
        quotes.setBounds(70,90, 300,100);
        quotes.setForeground(Color.yellow);
        
        
        
        
        contentPane.add(shopName);
        contentPane.add(shopLocation);
        contentPane.add(quotes);
        
        
        
       
        
        
        
       
        
        
        
        warehousePanel = new WarehousePanel(inventory, this);
        warehousePanel.setBackground(new Color(160,00,0));
        warehousePanel.setBounds(70, 170,1450,740);
        
        
        
        
        
        
        
        
        
        contentPane.add(warehousePanel);      
        
        
    
        
        // Make the changes visible
        revalidate();
        repaint();
		
	}
    
    
    
    public void showProductPage() {
        // Get the content pane and set its properties
    	
        JPanel contentPane = (JPanel) this.getContentPane();
        
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        
        
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(10, 110, 120) );

        
        shopName = new JLabel("MelodyMart");
        shopName.setFont(new Font("Broadway", Font.BOLD, 70));
        shopName.setBounds(70,20, 500,60);
        shopName.setForeground(Color.black);
        
        
        shopLocation = new JLabel("Dhaka - Bangladesh");
      
        shopLocation.setBounds(70,90, 400,25);
        shopLocation.setForeground(Color.black);
        shopLocation.setFont(new Font("Arial", Font.BOLD, 25));
	        
        quotes = new JLabel("Happy Shopping!");
        quotes.setFont(new Font("Blackadder ITC", Font.BOLD, 40));
        quotes.setBounds(70,100, 300,100);
        quotes.setForeground(Color.yellow);
        
        
        
      //listSelectedProduct();
        selectedProductPanel = new ProductPanel(inventory,"SelectedProductList", this, selectedProductInventory );
		selectedProductPanel.setBounds(1130,220,380,680);
		selectedProductPanel.setBackground(Color.darkGray);
        contentPane.add(selectedProductPanel);
        
        
        contentPane.add(shopName);
        contentPane.add(shopLocation);
        contentPane.add(quotes);
        
        
       
        
        
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(70, 200,1000,700);

        
        
        contentPane.add(tabbedPane);
        
        movie = new ProductPanel(inventory, "Movie", this, selectedProductInventory);
        movie.setBackground(Color.red);
        
        music = new ProductPanel(inventory, "Music", this , selectedProductInventory);
        music.setBackground(new Color(80,70,115));
        
        game = new ProductPanel(inventory, "Game", this, selectedProductInventory);
        game.setBackground(Color.gray); 
        
        
        
        tabbedPane.add("Movie",movie);
        tabbedPane.add("Music",music);
        tabbedPane.add("Game",game);
      
       
        
        
    
        
        // Make the changes visible
        revalidate();
        repaint();
    }


    
   

    
    public void switchPanel(JPanel newPanel) {
       
    	if(currentPanel != null)
        remove(currentPanel);  // Remove the current panel
        
        currentPanel = newPanel;
        add(currentPanel);
        
        revalidate();  // This tells the layout manager to reset based on the new component
        repaint();     // This ensures any old drawings are cleared and the component is freshly painted
    }
    
    
    public void addProductToSelectedPanel(StockableProduct product) {
        selectedProductPanel.addProduct(product);
    }
    
    
    




	
}


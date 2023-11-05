package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DiscountController;
import model.Inventory;
import model.StockableProduct;




public class CartPanel extends JPanel implements ActionListener{

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane sp;
	private String[] col = {"Product Id", "Name", "Price","Discount", "After Discount Price", "Category"};
	private String[] row = new String[6];
	
	
	
	private Inventory inventory;
	private Inventory selectedProductInventory;
	private DiscountController discountController;
	private InvoicePanel invoicePanel;
	private MainFrame mainFrame ;
	
	
	private JPanel priceListPanel;
	
	
	private JLabel totalPriceAmount , totalDiscountAmount, afterDiscountTotalPriceAmount, specialDiscountLabel,productDiscountLabel;
	private JLabel priceListPanelTitle, totalPriceLabel , totalDiscountLabel, afterDiscountTotalPriceLabel,specialDiscountAmount, productDiscountAmount;
	private JButton confirm,  previousButton, backHomeButton;
	
	public CartPanel(Inventory inventory,  MainFrame mainFrame,Inventory selectedProductInventory, DiscountController discountController) {
		this.selectedProductInventory = selectedProductInventory; // this is actually selectedProductInventory reference
		this.discountController = discountController;
		this.mainFrame = mainFrame;
		this.inventory = inventory;
		
		clearMainFrame();
		
		
		setLayout(null);
		setBounds(40,200,1500,700);
		setBackground(new Color(0,100,120));
		
		operateTable();
		operateCart();
		showPrevious();
		
		
		
	}
	
    public void clearMainFrame() {
		
        JPanel contentPane = (JPanel) mainFrame.getContentPane();   
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
        contentPane.setBackground(new Color(20, 40, 55) );
	}
	
    public void showPrevious() {
    	previousButton = new JButton("Previous");
    	previousButton.setBounds(120, 590, 100, 40);
    	previousButton.setBackground(Color.red);
    	previousButton.setFont(new Font("arial", Font.BOLD, 14));
    	previousButton.setForeground(Color.red);
    	previousButton.setBackground(Color.white);
    	
    	backHomeButton = new JButton("Home");
    	backHomeButton.setBounds(10, 590, 100, 40);
    	backHomeButton.setBackground(Color.red);
    	backHomeButton.setFont(new Font("arial", Font.BOLD, 18));
    	backHomeButton.setForeground(Color.white);
    	backHomeButton.setBackground(Color.red);
    	
    	
       priceListPanel.add(previousButton);
       priceListPanel.add(backHomeButton);
       
       
       previousButton.addActionListener(this);
       backHomeButton.addActionListener(this);
    	
    	
    }
    
    
    
	public void operateCart() {
		
		priceListPanel = new JPanel();
		priceListPanel.setLayout(null);
		priceListPanel.setBounds(980, 20, 500, 660);
		priceListPanel.setBackground(new Color(20,40,55));
		
		add(priceListPanel);
		
		priceListPanelTitle = new JLabel("Price Analysis"); 
		priceListPanelTitle.setOpaque(true);                
		priceListPanelTitle.setBackground(Color.black); 
	    priceListPanelTitle.setHorizontalAlignment(JLabel.CENTER);
		priceListPanelTitle.setForeground(Color.red);       
		priceListPanelTitle.setFont(Components.titleFont);  
		priceListPanelTitle.setBounds(20,20, 460,60);       
		
		
		totalPriceLabel = new JLabel("Total Price");
		totalPriceLabel.setOpaque(true);
		totalPriceLabel.setBackground(Color.black);
		totalPriceLabel.setForeground(Color.white);
		totalPriceLabel.setFont(Components.regularFont);
		totalPriceLabel.setBounds(20,200, 200,40);
		
		
		productDiscountLabel = new JLabel("Product Discount"); 
		productDiscountLabel.setOpaque(true);                
		productDiscountLabel.setBackground(Color.black);     
		productDiscountLabel.setForeground(Color.white);       
		productDiscountLabel.setFont(Components.regularFont);  
		productDiscountLabel.setBounds(20,250, 200,40);      
		
		

		specialDiscountLabel = new JLabel(discountController.getDiscountName()); 
		specialDiscountLabel.setOpaque(true);                
		specialDiscountLabel.setBackground(Color.black);     
		specialDiscountLabel.setForeground(Color.yellow);       
		specialDiscountLabel.setFont(Components.regularFont);  
		specialDiscountLabel.setBounds(20,300, 200,40);  
		
		

		totalDiscountLabel = new JLabel("Total Discount (Max)"); 
		totalDiscountLabel.setOpaque(true);                
		totalDiscountLabel.setBackground(Color.black);     
		totalDiscountLabel.setForeground(Color.white);       
		totalDiscountLabel.setFont(Components.regularFont);  
		totalDiscountLabel.setBounds(20,350, 200,40);   
		
		
		afterDiscountTotalPriceLabel = new JLabel("After Discount Price"); 
		afterDiscountTotalPriceLabel.setOpaque(true);                
		afterDiscountTotalPriceLabel.setBackground(Color.black);     
		afterDiscountTotalPriceLabel.setForeground(Color.red);       
		afterDiscountTotalPriceLabel.setFont(Components.regularFont);  
		afterDiscountTotalPriceLabel.setBounds(20,450, 200,40);       
		
		
		
		
		priceListPanel.add(priceListPanelTitle);
		priceListPanel.add(afterDiscountTotalPriceLabel);
		priceListPanel.add(totalDiscountLabel);
		priceListPanel.add(totalPriceLabel);
		
	
		
		DecimalFormat df = new DecimalFormat("#.##"); // Define the format pattern
      
		 
		
		totalPriceAmount = new JLabel(Double.toString(discountController.getTotalPrice()));
		totalPriceAmount.setOpaque(true);
		totalPriceAmount.setHorizontalAlignment(JLabel.RIGHT);
		totalPriceAmount.setBackground(Color.black);
		totalPriceAmount.setForeground(Color.white);
		totalPriceAmount.setFont(Components.regularFont);
		totalPriceAmount.setBounds(380,200, 100,40);
		
		
		
		productDiscountAmount = new JLabel(df.format(discountController.getTotalDiscount())); 
		productDiscountAmount.setOpaque(true); 
		productDiscountAmount.setHorizontalAlignment(JLabel.RIGHT);
		productDiscountAmount.setBackground(Color.black);     
		productDiscountAmount.setForeground(Color.white);       
		productDiscountAmount.setFont(Components.regularFont);  
		productDiscountAmount.setBounds(380,250, 100,40);       
		
		
		
		
		specialDiscountAmount = new JLabel(df.format(discountController.getTotalSpecialDiscount())); 
		specialDiscountAmount.setOpaque(true); 
		specialDiscountAmount.setHorizontalAlignment(JLabel.RIGHT);
		specialDiscountAmount.setBackground(Color.black);     
		specialDiscountAmount.setForeground(Color.yellow);       
		specialDiscountAmount.setFont(Components.regularFont);  
		specialDiscountAmount.setBounds(380,300, 100,40);    
		
		
		
		// ensuring maximum discount policy
		
		double maxDiscount = discountController.getTotalDiscount();
		if( discountController.getTotalSpecialDiscount() >  maxDiscount)
			maxDiscount = discountController.getTotalSpecialDiscount();
		
		totalDiscountAmount = new JLabel(df.format(maxDiscount)); 
		totalDiscountAmount.setOpaque(true); 
		totalDiscountAmount.setHorizontalAlignment(JLabel.RIGHT);
		totalDiscountAmount.setBackground(Color.black);     
		totalDiscountAmount.setForeground(Color.white);       
		totalDiscountAmount.setFont(Components.regularFont);  
		totalDiscountAmount.setBounds(380,350, 100,40);     
		
		
		
		
		
		afterDiscountTotalPriceAmount = new JLabel(df.format(discountController.getAfterDiscountTotalPrice())); 
		afterDiscountTotalPriceAmount.setOpaque(true);                
		afterDiscountTotalPriceAmount.setBackground(Color.black);     
		afterDiscountTotalPriceAmount.setForeground(Color.red); 
		afterDiscountTotalPriceAmount.setHorizontalAlignment(JLabel.RIGHT);
		afterDiscountTotalPriceAmount.setFont(Components.regularFont);  
		afterDiscountTotalPriceAmount.setBounds(380,450, 100,40);       
		
		
		
		priceListPanel.add(afterDiscountTotalPriceAmount);
		priceListPanel.add(totalDiscountAmount);
		priceListPanel.add(totalPriceAmount);
		priceListPanel.add(specialDiscountLabel);
		priceListPanel.add(specialDiscountAmount);
		
		priceListPanel.add(productDiscountAmount);
		priceListPanel.add(productDiscountLabel);
		
		confirm = new JButton("Confirm");
		confirm.setBounds(380, 590, 100, 40);
		confirm.setFont(Components.smallFont);
		confirm.setBackground(new Color(0,110,120));
		
		
		priceListPanel.add(confirm);		
		
		
		
		
		confirm.addActionListener(this);
	}
	

	private void operateTable() {
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		table.setModel(model);
		table.setBackground(Color.blue);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.magenta);
		table.setSelectionForeground(Color.white);
		table.setFont(Components.regularFont);
		table.setRowHeight(40);
		sp = new JScrollPane(table);
		sp.setBounds(20, 20, 900, 660);
		
		add(sp);
		
		
		for(StockableProduct p: selectedProductInventory.getItems()) {
		
			row[0] = Integer.toString(p.getProductId());
			row[1] = p.getName();
			row[2] = Double.toString(p.getPrice());
			row[3] = Double.toString(discountController.getDiscountAmount(p.getPrice(), p.getDiscount()));
			row[4] = Double.toString(discountController.getAfterDiscountPrice(p.getPrice(), p.getDiscount()));
			row[5] = p.getCategory();
		    model.addRow(row);
		    
		  

		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == confirm) {
			
			
			
			if(selectedProductInventory.getItems().size() != 0) {
			
				 clearMainFrame();
				 invoicePanel = new InvoicePanel(selectedProductInventory, discountController, mainFrame);
				 mainFrame.switchPanel(invoicePanel);
				 
				 
				 
				 for(StockableProduct p : inventory.getItems()) {
					 p.removeStock(1);
				 
				 }
				 
				 inventory.categoryListUpdate();
				 inventory.updateDatabase();
			
			}
			else {
				JOptionPane.showMessageDialog(null,"Your cart is Empty !\nPlease, go back and add to cart.","Error", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		
		
		else if(e.getSource() == previousButton) {
			mainFrame.showProductPage();
		}
        else if(e.getSource() == backHomeButton) {
			mainFrame.showHomePage();
		}
		
		 
		 
		 
		
		
	}
	
	
	

	
	
	
}

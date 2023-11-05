package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.DiscountController;
import model.Inventory;
import model.StockableProduct;

public class InvoicePanel extends JPanel implements ActionListener {

	private Inventory selectedProductInventory;
	private DiscountController discountController;
	
	private JLabel  title;
	
	private JTextArea textArea;
	private JScrollPane sp;
	
	private JButton backHomeButton, exitButton, backButton;
	private MainFrame mainFrame;
	
	public InvoicePanel(Inventory selectedProductInventory, DiscountController discountController, MainFrame mainFrame) {
		
		
		
		
		
		
		this.mainFrame = mainFrame;
		this.selectedProductInventory = selectedProductInventory;
		this.discountController = discountController;
		setLayout(null);
		setBounds(40,200,1500,700);
		setBackground(new Color(0,100,120));
		
		
		showWindowControll();
		
		
		
		title = new JLabel("");
		title.setOpaque(true);
		title.setBackground(null);
		title.setForeground(Color.black);
		
	    textArea = new JTextArea();
	    textArea.setBackground(new Color(40,50,55));
	    textArea.setForeground(Color.white);
	    textArea.setFont(Components.regularFont);
	    sp = new JScrollPane(textArea);
	    sp.setBounds(10,10,1480,620);
	    
	    textArea.setText("     --------     -------     ------     ------     ------    ------    ------   ------    ------    ------   ------   Invoice     -------    --------   -------    ------    ------    ------   ------    ------    ------    -------   ------    ------ \n\n");
	    for(StockableProduct p : selectedProductInventory.getItems()){
	    	
	    	textArea.setText(textArea.getText()+ "\n\n"+ p.toString());
	    	
	    
	    }
	    
	    DecimalFormat df = new DecimalFormat("#.##"); // Define the format pattern
	    
	    
	    String space = "                  ";
	    double maxDiscount = 0;
	    if(discountController.getTotalSpecialDiscount() > discountController.getTotalDiscount())
	    	maxDiscount = discountController.getTotalSpecialDiscount();
	    String paymentInfo = space + "Total Price :  " + df.format(discountController.getTotalPrice())+
	    		      "\n" + space + "Total Product Discout :  " + df.format(discountController.getTotalDiscount())+
	    		      "\n" + space + discountController.getDiscountName() +" :  " + df.format(discountController.getTotalSpecialDiscount())+
	    		      "\n" + space + "Total Discount(Maximum) :  " + df.format(maxDiscount)+
	    		      "\n" + space + "To Pay :  " + df.format(discountController.getAfterDiscountTotalPrice());
	    		
	    		
	    textArea.setText(textArea.getText() + "\n\n\n\n\n\n" + paymentInfo);
	    
	    
	    		
	    ;
	    
	    
	    
	    add(sp);
		
		
	
	//pName = new JLabel();
	//pName.setOpaque(true);
	//pName.setBackground(null);
	//pName.setForeground(Color.black);
	//
	//
	//pPrice = new JLabel();
	//pPrice.setOpaque(true);
	//pPrice.setBackground(null);
	//pPrice.setForeground(Color.black);
	//
	//totalPrice = new JLabel();
	//totalPrice.setOpaque(true);
	//totalPrice.setBackground(null);
	//totalPrice.setForeground(Color.black);
	//
	//totolPriceAfterDiscount = new JLabel();
	//totolPriceAfterDiscount.setOpaque(true);
	//totolPriceAfterDiscount.setBackground(null);
	//totolPriceAfterDiscount.setForeground(Color.black);
	//
	//totalDiscount = new JLabel();
	//totalDiscount.setOpaque(true);
	//totalDiscount.setBackground(null);
	//totalDiscount.setForeground(Color.black);
	
	
		
		
	    selectedProductInventory.getItems().clear();
		
		
	}
	
	
	
	
	public void showWindowControll() {
		
		
		
	backHomeButton = new JButton("Home");
	backHomeButton.setBounds(150, 650, 100, 30);
	backHomeButton.setBackground(Color.red);
	backHomeButton.setFont(new Font("arial", Font.BOLD, 18));
	backHomeButton.setForeground(Color.red);
	backHomeButton.setBackground(Color.white);
	
	
	
	
    add(backHomeButton);
   
   
    exitButton = new JButton("Quit");
   	exitButton.setBounds(1390, 650, 100, 30);
   	exitButton.setBackground(Color.red);
   	exitButton.setFont(new Font("arial", Font.BOLD, 18));
   	exitButton.setForeground(Color.red);
   	exitButton.setBackground(Color.white);
   
   
	add(exitButton);
	
	
	
    backButton = new JButton("Back");
   	backButton.setBounds(10, 650, 100, 30);
   	backButton.setBackground(Color.red);
   	backButton.setFont(new Font("arial", Font.BOLD, 18));
   	backButton.setForeground(Color.red);
   	backButton.setBackground(Color.white);
	
	add(backButton);
	
	exitButton.addActionListener(this);
	backHomeButton.addActionListener(this);
	backButton.addActionListener(this);
	
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		else if(e.getSource() == backHomeButton) {
			selectedProductInventory.getItems().clear();
			mainFrame.showHomePage();
		}
		else if(e.getSource() == backButton) {
			mainFrame.showProductPage();
		}
		
	}
}

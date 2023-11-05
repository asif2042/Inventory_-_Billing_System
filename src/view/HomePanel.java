package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel implements ActionListener{
	
	private JLabel shopName;
	private JButton productButton,warehouseButton;
	
	private MainFrame mainFrame;
	
	
	public HomePanel(MainFrame mainFrame){
		
		this.mainFrame = mainFrame;
		
		shopName = new JLabel("MelodyMart");
		shopName.setOpaque(true);
		shopName.setBackground(null);
		shopName.setForeground(Color.red);
		shopName.setFont(new Font("Broadway", Font.BOLD, 70));
		shopName.setHorizontalAlignment(JLabel.CENTER);
		shopName.setBounds(450,120,600,300 );
		
		
		
		
		
		
		
		
		 
		productButton = new JButton("Marketplace");
		productButton.setOpaque(true);
		productButton.setBackground(Color.white);
		productButton.setForeground(Color.red);
		productButton.setFont(new Font("Broadway", Font.BOLD, 20));
		productButton.setHorizontalAlignment(JLabel.CENTER);
		productButton.setBounds(900,450,200,50 );
		
		
		
		warehouseButton = new JButton("Warehouse");
		warehouseButton.setOpaque(true);
		warehouseButton.setBackground(Color.white);
		warehouseButton.setForeground(Color.red);
		warehouseButton.setFont(new Font("Broadway", Font.BOLD, 20));
		warehouseButton.setHorizontalAlignment(JLabel.CENTER);
		warehouseButton.setBounds(420,450,200,50 );
	
		
		
		
		
		
		
		
		
		add(shopName);
		add(productButton);
		add(warehouseButton);
		
		
		
		
		
		productButton.addActionListener(this);
		warehouseButton.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == productButton) {
	        mainFrame.showProductPage();
	    } else if (e.getSource() == warehouseButton) {
	        mainFrame.showWarehousePage();
	    }
	}

	

}

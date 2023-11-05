package view;





import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.*;
import controller.*;

public class ProductPanel extends JPanel implements ActionListener{

	private Inventory inventory;
	private String itemCategoryName;
	private ArrayList<StockableProduct> categoryList;
	private Inventory selectedProductInventory;
	private StockableProduct selectedProduct;
	private BillingController billingController;
	
	
	
	private JTable table, selectedProductTable;
	private DefaultTableModel model, selectedProductModel;
	private String[] col = {"Product Id", "Name", "price", "Genre", "Published Year", "Discount","Stock Amount"};
	private String[] row = new String[7];
	
	private String[] selectedProductTableCol = {"Product Id", "Name", "quantity"};
	private String[] selectedProductTableRow = new String[3];
	
	
	private JScrollPane sp, selectedProductScrollPane;
	
	private JLabel pLabelName, pLabelId, pLabelPrice, pLabelGenre, pLabelYear,pLabelDiscount, pLabelAmount, pLabelCategory, pLabelTitle;
	private JLabel splTitle , selectedQuantityLabel, totalQuantity ; // selectedProductListTitle
	
	private JPanel pCategoryPanel;
	private JTextField ptfName, ptfId, ptfPrice, ptfGenre, ptfYear,ptfDiscount, ptfAmount;
	private JRadioButton btMovie, btMusic, btGame;
	private ButtonGroup buttonGroup;
	private JButton pAddButton, buyButton, previousButton,  exitButton;
	private MainFrame mainFrame;
	
	
	public ProductPanel(Inventory inventory, String itemCategoryName, MainFrame mainFrame, Inventory selectedProductInventory){
		this.mainFrame = mainFrame;
		this.selectedProductInventory = selectedProductInventory;
	    this.inventory = inventory;
		this.itemCategoryName = itemCategoryName;
        setLayout(null);
        
        selectedProductModel = new DefaultTableModel();
        selectedProductModel.setColumnIdentifiers(selectedProductTableCol);
        
        
        if(itemCategoryName.equals("SelectedProductList")) {
        	 operateSelectedProductList();
        	 
        }
        else{
        	showProduct();
            operateTable();
            
        }
        
      
       
	}
	
	
	
	private void operateSelectedProductList() {
		splTitle = new JLabel("Selected Product List");
	
		splTitle.setOpaque(true);
		splTitle.setBackground(new Color(0,100,115));
		splTitle.setForeground(Color.white);
		splTitle.setBounds(10,20,360,30);
		splTitle.setFont(Components.headingFont);
		splTitle.setHorizontalAlignment(JLabel.CENTER);
		
		add(splTitle);
		
		
		
		selectedProductTable = new JTable();
		selectedProductModel = new DefaultTableModel();
		selectedProductModel.setColumnIdentifiers(selectedProductTableCol);
		
		selectedProductTable.setModel(selectedProductModel);
		selectedProductTable.setBackground(Color.blue);
		selectedProductTable.setForeground(Color.white);
		selectedProductTable.setSelectionBackground(Color.magenta);
		selectedProductTable.setSelectionForeground(Color.yellow);
		selectedProductTable.setFont(Components.regularFont);
		selectedProductTable.setRowHeight(40);
		selectedProductScrollPane = new JScrollPane(selectedProductTable);
		selectedProductScrollPane.setBounds(10, 200, 360, 400);
		
		add(selectedProductScrollPane);
		
		
		
		selectedQuantityLabel = new JLabel("Numer of Selected Items : ");
		selectedQuantityLabel.setBounds(10, 170, 170,25);
		selectedQuantityLabel.setOpaque(true);
		selectedQuantityLabel.setBackground(null);
		selectedQuantityLabel.setForeground(Color.white);
		
		add(selectedQuantityLabel);
		
		totalQuantity = new JLabel("0");
		totalQuantity.setOpaque(true);
		totalQuantity.setBackground(null);
		totalQuantity.setForeground(Color.white);
		totalQuantity.setBounds(180,170,50,25);
		
		add(totalQuantity);
		
		
		
		
		
		
		
		
		previousButton = new JButton("Previous");
    	previousButton.setBounds(270, 630, 100, 30);
    	previousButton.setBackground(Color.red);
    	previousButton.setFont(new Font("arial", Font.BOLD, 14));
    	previousButton.setForeground(Color.red);
    	previousButton.setBackground(Color.white);
    	
    	
    	
    	
        add(previousButton);
       
       
	    exitButton = new JButton("Quit");
	   	exitButton.setBounds(10, 630, 100, 30);
	   	exitButton.setBackground(Color.red);
	   	exitButton.setFont(new Font("arial", Font.BOLD, 18));
	   	exitButton.setForeground(Color.red);
	   	exitButton.setBackground(Color.white);
       
       
		add(exitButton);
		
		
		
		
		buyButton = new JButton("Buy");
		buyButton.setBounds(300,160,70,30);
		buyButton.setBackground(Color.blue);
		buyButton.setFont(Components.regularFont);
		buyButton.setForeground(Color.white);
		add(buyButton);
		
		
		previousButton.addActionListener(this);
		
		exitButton.addActionListener(this);
	    buyButton.addActionListener(this);
		
		
	}
	
	private void showProduct() {
		
		pLabelTitle = new JLabel("Product Information");
		pLabelTitle.setBounds(20,20,950,30);
		pLabelTitle.setFont(Components.headingFont);
		pLabelTitle.setHorizontalAlignment(JLabel.CENTER);
		pLabelTitle.setOpaque(true);
		pLabelTitle.setBackground(Color.blue);
		pLabelTitle.setForeground(Color.white);
		
		pCategoryPanel = new JPanel();
		pCategoryPanel.setBounds(800,70, 170,170);
		pCategoryPanel.setBackground(Color.white);
		
		pAddButton = new JButton("Add to Cart");
		pAddButton.setBounds(660,200,120,40);
		pAddButton.setBackground(Color.black);
		pAddButton.setForeground(Color.white);
		pAddButton.setFont(Components.smallFont);
		
		pLabelId = new JLabel("Product Id");
		pLabelId.setBounds(20, 70,150, 25);
		pLabelId.setForeground(Color.black);
		pLabelId.setFont(Components.regularFont);
		
		pLabelName = new JLabel("Name");
		pLabelName.setBounds(20, 110,150, 25);
		pLabelName.setForeground(Color.black);
		pLabelName.setFont(Components.regularFont);
		
		pLabelPrice = new JLabel("Price");
		pLabelPrice.setBounds(20, 150,150, 25);
		pLabelPrice.setForeground(Color.black);
		pLabelPrice.setFont(Components.regularFont);
		
		pLabelGenre = new JLabel("Genre");
		pLabelGenre.setBounds(20, 190,150, 25);
		pLabelGenre.setForeground(Color.black);
		pLabelGenre.setFont(Components.regularFont);
		
		pLabelDiscount = new JLabel("Discount");
		pLabelDiscount.setBounds(350, 70,150, 25);
		pLabelDiscount.setForeground(Color.black);
		pLabelDiscount.setFont(Components.regularFont);
		
		pLabelYear = new JLabel("Publised Year");
		pLabelYear.setBounds(350, 110,150, 25);
		pLabelYear.setForeground(Color.black);
		pLabelYear.setFont(Components.regularFont);
		
		
		pLabelAmount = new JLabel("Stock Quantity");
		pLabelAmount.setBounds(350, 150,150, 25);
		pLabelAmount.setForeground(Color.black);
		pLabelAmount.setFont(Components.regularFont);
		
		
		pLabelCategory = new JLabel("Category");
		pLabelCategory.setBounds(350, 190,150, 25);
		pLabelCategory.setForeground(Color.black);
		pLabelCategory.setFont(Components.regularFont);
		
		
		ptfId = new JTextField();
		ptfId.setBounds(180, 70,120, 25);
		ptfId.setForeground(Color.black);
		ptfId.setFont(Components.regularFont);
		ptfId.setBackground(Color.white);
		
		ptfName = new JTextField();
		ptfName.setBounds(180, 110,120, 25);
		ptfName.setForeground(Color.black);
		ptfName.setFont(Components.regularFont);
		ptfName.setBackground(Color.white);
		
		ptfPrice = new JTextField();
		ptfPrice.setBounds(180, 150,120, 25);
		ptfPrice.setForeground(Color.black);
		ptfPrice.setFont(Components.regularFont);
		ptfPrice.setBackground(Color.white);
		
		ptfGenre = new JTextField();
		ptfGenre.setBounds(180, 190,120, 25);
		ptfGenre.setForeground(Color.black);
		ptfGenre.setFont(Components.regularFont);
		ptfGenre.setBackground(Color.white);
		
		ptfDiscount = new JTextField();
		ptfDiscount.setBounds(510, 70,120, 25);
		ptfDiscount.setForeground(Color.black);
		ptfDiscount.setFont(Components.regularFont);
		ptfDiscount.setBackground(Color.white);
		
		ptfYear = new JTextField();
		ptfYear.setBounds(510, 110,120, 25);
		ptfYear.setForeground(Color.black);
		ptfYear.setFont(Components.regularFont);
		ptfYear.setBackground(Color.white);
		
		
		ptfAmount = new JTextField();
		ptfAmount.setBounds(510, 150,120, 25);
		ptfAmount.setForeground(Color.black);
		ptfAmount.setFont(Components.regularFont);
		ptfAmount.setBackground(Color.white);
		
		btMovie = new JRadioButton("Movie");
		btMovie.setForeground(Color.white);
		btMovie.setBackground(null);
		btMovie.setFont(Components.smallFont);
		btMovie.setBounds(510, 190,120, 25);
		
		
		btMusic = new JRadioButton("Music");
		btMusic.setForeground(Color.white);
		btMusic.setBackground(null);
		btMusic.setFont(Components.smallFont);
		btMusic.setBounds(510, 210,120, 25);
		
		btGame = new JRadioButton("Game");
		btGame.setForeground(Color.white);
		btGame.setBackground(null);
		btGame.setFont(Components.smallFont);
		btGame.setBounds(510, 230,120, 25);
		
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(btGame);
		buttonGroup.add(btMovie);
		buttonGroup.add(btMusic);
		
		add(pLabelTitle);
		add(pCategoryPanel);
		//if(!itemCategoryName.equals("warehouse") )
		add(pAddButton);
		
		add(pLabelId);
		add(pLabelName);
		add(pLabelPrice);
		add(pLabelGenre);
		add(pLabelDiscount);
		add(pLabelYear);
		add(pLabelAmount);
		add(pLabelCategory);
		
		
		add(ptfId);
		add(ptfName);
		add(ptfPrice);
		add(ptfGenre);
		add(ptfDiscount);
		add(ptfYear);
		add(ptfAmount);
		
		add(btMovie);
		add(btMusic);
		add(btGame);
		
		
		
		
		pAddButton.addActionListener(this);
	}
	
	private void operateTable() {
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		table.setModel(model);
		table.setBackground(Color.blue);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.magenta);
		table.setSelectionForeground(Color.yellow);
		table.setFont(Components.regularFont);
		table.setRowHeight(40);
		sp = new JScrollPane(table);
		sp.setBounds(20, 270, 950, 380);
		
		add(sp);
		
		//Loading all movies, games, music in their individual list
		
		
		
		
		inventory.categoryListUpdate();
		categoryList = inventory.getCategoryList(itemCategoryName);
		
		for(StockableProduct p : categoryList) {
			row[0] = Integer.toString(p.getProductId());
			row[1] = p.getName();
			row[2] = Double.toString(p.getPrice());
			row[3] = p.getGenre();
			row[4] = String.valueOf(p.getYearPublished());
			row[5] = String.valueOf(p.getDiscount());
			row[6] = Integer.toString(p.getNumberOfItemsStocked());
			
			
			model.addRow(row);
			

			table.revalidate();
			table.repaint();

		}
		
		
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int seletedRow = table.getSelectedRow();
				String id =   (String)model.getValueAt(seletedRow, 0);
				String name = (String) model.getValueAt(seletedRow, 1);
				String price =  (String) model.getValueAt(seletedRow, 2);
				String genre = (String)model.getValueAt(seletedRow, 3);
				String year = (String)model.getValueAt(seletedRow, 4);
				String discount = (String)model.getValueAt(seletedRow, 5);
				String amount = (String)model.getValueAt(seletedRow, 6);
				String category = "";
				try {
					category = inventory.getItem(Integer.parseInt(id)).getCategory();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
				ptfId.setText(id);
			    ptfName.setText(name);
				ptfPrice.setText(price);
				ptfGenre.setText(genre);
				ptfYear.setText(year);
				ptfDiscount.setText(discount);
				ptfAmount.setText(amount);
				
				
				
				
				
				
				
				if(btMovie.getText().equals(category)) {
				btMovie.setSelected(true);
				//photoLabel.setIcon(movieIcon);
				}
				else if(btMusic.getText().equals(category)) {
					btMusic.setSelected(true);
					//photoLabel.setIcon(musicIcon);
				}
				else if(btGame.getText().equals(category)) {
				    btGame.setSelected(true);
					//photoLabel.setIcon(gameIcon);
				}
				
            
		    
		
	    		
					
				}
			
				
		});	
		
		
		
		
		
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == pAddButton) {
			
			if(table.getSelectedRow() >= 0) {
			
				selectedProductTableRow[0] = ptfId.getText();
				selectedProductTableRow[1] = ptfName.getText();
				selectedProductTableRow[2] = ptfPrice.getText();
				
				
				if (selectedProductModel == null) {
				    return;  // or display an appropriate message to the user
				}
		
					
				selectedProductModel.addRow(selectedProductTableRow);
				
				
				try {
					selectedProduct = inventory.getItem(Integer.parseInt(ptfId.getText()));
					inventory.categoryListUpdate();
					
					
				} catch(Exception e1) {
					System.out.println(e1 + "Product not founded");
				} 
				
				mainFrame.addProductToSelectedPanel(selectedProduct);
				
				selectedProductInventory.addItem(selectedProduct);
				
				if (selectedProductTable != null) {
				    selectedProductTable.revalidate();
				    selectedProductTable.repaint();
				}

			}
			else {
				JOptionPane.showMessageDialog(null,"Please Select Any of Row","Error", JOptionPane.WARNING_MESSAGE);
			}
		
		
	    }
		
		if(e.getSource() == buyButton) {
			
			if(selectedProductInventory.getItems().size() != 0) {
			
				
				
			     billingController  =  new BillingController(inventory, mainFrame, selectedProductInventory);
			
			}
			else {
				JOptionPane.showMessageDialog(null,"You have not selected any Product !\nPlease, add to cart before pressing Buy","Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		
		else if(e.getSource() == exitButton) {
			System.exit(0);
		}
	
		else if(e.getSource() == previousButton)
			mainFrame.showHomePage();
			
			
		}
	
	     
	
	
	
	
	
	
	

	
	
	
	
	
	public void addProduct(StockableProduct product) {
        // Add the product to your selected products model/table
        // For simplicity, let's use the selectedProductModel directly:

        selectedProductModel.addRow(new Object[]{
            product.getProductId(),
            product.getName(),
            product.getPrice()
        });

        // Update any other UI components if necessary
    }







	
}
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import controller.BillingController;
import model.Game;
import model.Inventory;
import model.Movie;
import model.Music;
import model.Stockable;
import model.StockableProduct;


public class WarehousePanel extends JPanel implements ActionListener{
	
	
	
	
	
	private JTable table;
	private DefaultTableModel model;
	private String[] col = {"Product Id", "Name", "Stock Amount", "price", "Discount", "Category", "Genre", "Creators", "Published Year"};
	private String[] row = new String[9];
	
	
	
	private JScrollPane sp;
	
	
	private JLabel pLabelName, pLabelId, pLabelPrice, pLabelGenre, pLabelYear,pLabelDiscount, pLabelAmount,pCreator, pLabelCategory, pLabelTitle;
	
	private JPanel pCategoryPanel;
	private JTextField ptfName, ptfId, ptfPrice, ptfGenre, ptfYear,ptfDiscount, ptfAmount, ptfCreator;
	private JRadioButton btMovie, btMusic, btGame;
	private ButtonGroup buttonGroup;
	private JButton pAddButton, pUpdateButton,pRemoveButton, pClearButton,  exitButton, backButton;
	
	
	
	
	private MainFrame mainFrame;
	private Inventory inventory;
	
	
	
	
	
	
	
	
	
	public WarehousePanel(Inventory inventory, MainFrame mainFrame){
		this.mainFrame = mainFrame;
	    this.inventory = inventory;
        setLayout(null);
        
        
        
        
        
       
        showProduct();
        operateTable();
        showWindowControll();    
       
        
      
       
	}
	
	public void showWindowControll() {
		
		
		
		    exitButton = new JButton("Quit");
		   	exitButton.setBounds(1330,700, 100, 30);
		   	exitButton.setBackground(Color.red);
		   	exitButton.setFont(new Font("arial", Font.BOLD, 18));
		   	exitButton.setForeground(Color.red);
		   	exitButton.setBackground(Color.white);
		   
		   
			add(exitButton);
			
			
			
		    backButton = new JButton("Back");
		   	backButton.setBounds(20, 700, 100, 30);
		   	backButton.setBackground(Color.red);
		   	backButton.setFont(new Font("arial", Font.BOLD, 18));
		   	backButton.setForeground(Color.red);
		   	backButton.setBackground(Color.white);
			
			add(backButton);
			
			exitButton.addActionListener(this);
			backButton.addActionListener(this);

		
		
	}
	
	
    private void showProduct() {
		
		pLabelTitle = new JLabel("Product Information");
		pLabelTitle.setBounds(20,20,1410,30);
		pLabelTitle.setFont(Components.headingFont);
		pLabelTitle.setHorizontalAlignment(JLabel.CENTER);
		pLabelTitle.setOpaque(true);
		pLabelTitle.setBackground(Color.blue);
		pLabelTitle.setForeground(Color.white);
		
		pCategoryPanel = new JPanel();
		pCategoryPanel.setBounds(1260,70, 170,170);
		pCategoryPanel.setBackground(Color.white);
		
		
		pLabelId = new JLabel("Product Id");
		pLabelId.setBounds(20, 80,150, 35);
		pLabelId.setForeground(Color.black);
		pLabelId.setFont(Components.regularFont);
		
		pLabelName = new JLabel("Name");
		pLabelName.setBounds(20, 120,150, 35);
		pLabelName.setForeground(Color.black);
		pLabelName.setFont(Components.regularFont);
		
		pLabelPrice = new JLabel("Price");
		pLabelPrice.setBounds(20, 160,150, 35);
		pLabelPrice.setForeground(Color.black);
		pLabelPrice.setFont(Components.regularFont);
		
		pLabelGenre = new JLabel("Genre");
		pLabelGenre.setBounds(20, 200,150, 35);
		pLabelGenre.setForeground(Color.black);
		pLabelGenre.setFont(Components.regularFont);
		
		pLabelDiscount = new JLabel("Discount");
		pLabelDiscount.setBounds(20, 240,150, 35);
		pLabelDiscount.setForeground(Color.black);
		pLabelDiscount.setFont(Components.regularFont);
		
		pLabelYear = new JLabel("Publised Year");
		pLabelYear.setBounds(500, 80,150, 35);
		pLabelYear.setForeground(Color.black);
		pLabelYear.setFont(Components.regularFont);
		
		
		pLabelAmount = new JLabel("Stock Quantity");
		pLabelAmount.setBounds(500, 120,150, 35);
		pLabelAmount.setForeground(Color.black);
		pLabelAmount.setFont(Components.regularFont);
		
		pCreator = new JLabel("Creator");
		pCreator.setBounds(500,160,150,25);
		pCreator.setFont(Components.regularFont);
		//pCreator.setOpaque(true);
		pCreator.setForeground(Color.black);
		
		
		pLabelCategory = new JLabel("Category");
		pLabelCategory.setBounds(500, 200,150, 35);
		pLabelCategory.setForeground(Color.black);
		pLabelCategory.setFont(Components.regularFont);
		
		
		
		
		
		
		ptfId = new JTextField();
		ptfId.setBounds(180, 80,200, 30);
		ptfId.setForeground(Color.black);
		ptfId.setFont(Components.regularFont);
		ptfId.setBackground(Color.white);
		
		ptfName = new JTextField();
		ptfName.setBounds(180, 120,200, 30);
		ptfName.setForeground(Color.black);
		ptfName.setFont(Components.regularFont);
		ptfName.setBackground(Color.white);
		
		ptfPrice = new JTextField();
		ptfPrice.setBounds(180, 160,200, 25);
		ptfPrice.setForeground(Color.black);
		ptfPrice.setFont(Components.regularFont);
		ptfPrice.setBackground(Color.white);
		
		ptfGenre = new JTextField();
		ptfGenre.setBounds(180, 200,200, 25);
		ptfGenre.setForeground(Color.black);
		ptfGenre.setFont(Components.regularFont);
		ptfGenre.setBackground(Color.white);
		
		ptfDiscount = new JTextField();
		ptfDiscount.setBounds(180, 240,200, 35);
		ptfDiscount.setForeground(Color.black);
		ptfDiscount.setFont(Components.regularFont);
		ptfDiscount.setBackground(Color.white);
		
		ptfYear = new JTextField();
		ptfYear.setBounds(660, 80,200, 35);
		ptfYear.setForeground(Color.black);
		ptfYear.setFont(Components.regularFont);
		ptfYear.setBackground(Color.white);
		
		
		ptfAmount = new JTextField();
		ptfAmount.setBounds(660, 120,200, 35);
		ptfAmount.setForeground(Color.black);
		ptfAmount.setFont(Components.regularFont);
		ptfAmount.setBackground(Color.white);
		
		ptfCreator = new JTextField();
		ptfCreator.setBounds(660,160,200,35);
		ptfCreator.setFont(Components.regularFont);
		
		
		
		btMovie = new JRadioButton("Movie");
		btMovie.setForeground(Color.white);
		btMovie.setBackground(null);
		btMovie.setFont(Components.smallFont);
		btMovie.setBounds(660, 200,120, 25);
		
		
		btMusic = new JRadioButton("Music");
		btMusic.setForeground(Color.white);
		btMusic.setBackground(null);
		btMusic.setFont(Components.smallFont);
		btMusic.setBounds(660, 230,120, 25);
		
		btGame = new JRadioButton("Game");
		btGame.setForeground(Color.white);
		btGame.setBackground(null);
		btGame.setFont(Components.smallFont);
		btGame.setBounds(660, 260,120, 25);
		
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(btGame);
		buttonGroup.add(btMovie);
		buttonGroup.add(btMusic);
		
		
		
		pAddButton = new JButton("Add");
		pAddButton.setBounds(1000,80,120,40);
		pAddButton.setBackground(Color.black);
		pAddButton.setForeground(Color.white);
		pAddButton.setFont(Components.regularFont);
		
		
		
		

		pUpdateButton = new JButton("Update");
		pUpdateButton.setBackground(Color.magenta);
		pUpdateButton.setForeground(Color.white);
		pUpdateButton.setFont(Components.regularFont);
		pUpdateButton.setBounds(1000,130,120,40);
		
		
		pRemoveButton = new JButton("Remove");
		pRemoveButton.setBackground(Color.red);
		pRemoveButton.setForeground(Color.white);
		pRemoveButton.setFont(Components.regularFont);
		pRemoveButton.setBounds(1000,180,120,40);
		
		
		
		
		
		pClearButton = new JButton("Clean");
		pClearButton.setBackground(Color.yellow);
		pClearButton.setForeground(Color.blue);
		pClearButton.setFont(Components.regularFont);
		pClearButton.setBounds(1000,230,120,40);
		
		
		
		
		
		
		
		
		
		
		
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
		add(pCreator);
		
		add(ptfId);
		add(ptfName);
		add(ptfPrice);
		add(ptfGenre);
		add(ptfDiscount);
		add(ptfYear);
		add(ptfAmount);
		add(ptfCreator);
		
		
		add(btMovie);
		add(btMusic);
		add(btGame);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		add(pUpdateButton);
		add(pRemoveButton);
		add(pClearButton);
		
		
		
		
		
		
		
		
		pAddButton.addActionListener(this);
		pUpdateButton.addActionListener(this);
		pClearButton.addActionListener(this);
		pRemoveButton.addActionListener(this);
		
    
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
		sp.setBounds(20, 300, 1410, 380);
		
		add(sp);
		
		//Loading all movies, games, music in their individual list
		
		
		
		
		
		
		for(StockableProduct p : inventory.getItems()) {
			row[0] = Integer.toString(p.getProductId());
			row[1] = p.getName();
			row[2] = Integer.toString(p.getNumberOfItemsStocked());
			row[3] = Double.toString(p.getPrice());
            row[4] = String.valueOf(p.getDiscount());
			row[5] = p.getCategory();
			row[6] = p.getGenre();
		    row[7] = p.getCreator();
			row[8] = String.valueOf(p.getYearPublished());
			
			
			
			model.addRow(row);
			

			table.revalidate();
			table.repaint();

		}
		
		
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
		

				int selectedRow = table.getSelectedRow();
				String id =   (String)model.getValueAt(selectedRow, 0);
				String name = (String) model.getValueAt(selectedRow, 1);
				String amount =  (String) model.getValueAt(selectedRow, 2);
				String price = (String)model.getValueAt(selectedRow, 3);
				String discount = (String)model.getValueAt(selectedRow, 4);
				String category = (String)model.getValueAt(selectedRow, 5);
				String genre = (String)model.getValueAt(selectedRow, 6);
				String creator = (String)model.getValueAt(selectedRow,7);
				String  year = (String)model.getValueAt(selectedRow, 8);
				 
				
				
				ptfId.setText(id);
			    ptfName.setText(name);
				ptfPrice.setText(price);
				ptfGenre.setText(genre);
				ptfYear.setText(year);
				ptfDiscount.setText(discount);
				ptfAmount.setText(amount);
				ptfCreator.setText(creator);
				
				
				
				
				
				
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
		
		
		
		//inventory.categoryListUpdate();
		
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
		
		
		if(e.getSource() == pAddButton) {
			
			
			// Add new Product to inventory Product items list
			Movie movie;
			Music music;
			Game game;
			
			
		
			
			row[0] = ptfId.getText();
			row[1] = ptfName.getText();
			row[2] = ptfAmount.getText();
			row[3] = ptfPrice.getText();
			row[4] = ptfDiscount.getText();	
			row[5] = "";
			row[6] = ptfGenre.getText();
			row[7] = ptfCreator.getText();
			row[8] = ptfYear.getText();	
			
			
		
			int id = 0; // = Integer.parseInt(ptfId.getText());		
			String name = ptfName.getText();
			double price = 0; // = Double.parseDouble(ptfPrice.getText());
        
			String genre = ptfGenre.getText();
        
			double discount = 0; //  = Double.parseDouble(ptfDiscount.getText());
			int year = 0; // = Integer.parseInt(ptfYear.getText());
			String creator = ptfCreator.getText();
			int amount = 0;  // =  Integer.parseInt( ptfId.getText());


			
		
			  
			   try {
			       if(ptfPrice.getText().isEmpty() || ptfId.getText().isEmpty() || 
			           ptfDiscount.getText().isEmpty() || ptfYear.getText().isEmpty() ||
			           ptfAmount.getText().isEmpty()) {
			           JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
			           return;
			       }
            
			        id = Integer.parseInt(ptfId.getText());
			        price = Double.parseDouble(ptfPrice.getText());
			        discount = Double.parseDouble(ptfDiscount.getText());
			        year = Integer.parseInt(ptfYear.getText());
			        amount = Integer.parseInt(ptfAmount.getText());
			       
			   } catch (NumberFormatException ex) {
			       JOptionPane.showMessageDialog(this, "Please enter valid numeric values!", "Error", JOptionPane.ERROR_MESSAGE);
			   }
			

			
		
					
			if(btMovie.isSelected()) {
				row[5] = btMovie.getText();	
				movie = new Movie(name,price,id,genre,year,discount,amount,btMovie.getText(),creator);
				inventory.addItem(movie);
			}
			else if(btMusic.isSelected()) {
				music = new Music(name,price,id,genre,year,discount,amount,btMovie.getText(),creator);
				inventory.addItem(music);
			}
			else if(btGame.isSelected()) {
				game = new Game(name,price,id,genre,year,discount,amount,btMovie.getText(),creator);
				inventory.addItem(game);
			}
				
			
			
		    model.addRow(row);
		
		    
		
		 
		    //Update all inventory
		    inventory.categoryListUpdate();
		
		
			if (table != null) {
			    table.revalidate();
			    table.repaint();
			}

		
			inventory.updateDatabase();
		
		}
		
		
		
		
		

		 else if(e.getSource()== pClearButton) {
				
				ptfId.setText(null);
				ptfName.setText(null);
				ptfPrice.setText(null);
				ptfDiscount.setText(null);
				ptfGenre.setText(null);
				ptfCreator.setText(null);
				ptfYear.setText(null);
				ptfAmount.setText(null);
				
				//photoLabel.setIcon(studentIcon);

				
			}
			
			else if(e.getSource() == pRemoveButton) {
				int selectedRow = table.getSelectedRow();
				
			
				if(selectedRow >= 0) {
					// get the selected product id
					int productId = Integer.parseInt( (String) model.getValueAt(selectedRow, 0));
				    model.removeRow(selectedRow);
				    inventory.removeItem(productId);
				    inventory.categoryListUpdate();
				    
				    
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select Any of Row","Error", JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
				
				
				
			}
			
			else if(e.getSource() == pUpdateButton) {
				int selectedRow = table.getSelectedRow();
				
				
				// get the selected product object
				StockableProduct product = null;
				int oldId = Integer.parseInt( (String) model.getValueAt(selectedRow, 0));

				try {
					 product = inventory.getItem(oldId);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
				
				if(selectedRow >= 0) {
				
					String id = ptfId.getText();
					String name = ptfName.getText();
					String price = ptfPrice.getText();
					String discount = ptfDiscount.getText();
					String genre = ptfGenre.getText();
					String year = ptfYear.getText();
					String amount = ptfAmount.getText();
					String creator = ptfCreator.getText();
					String category = "";
					
					
					
						
					 
					
					if(btMovie.isSelected()) {
						 category = btMovie.getText();
					}
					else if(btMusic.isSelected()) {
						 category = btMusic.getText();
					}
					else if(btGame.isSelected()) {
						 category = btGame.getText();
					}
					
					model.setValueAt(id, selectedRow, 0);
					model.setValueAt(name, selectedRow, 1);
					model.setValueAt(amount, selectedRow, 2);
					model.setValueAt(price, selectedRow, 3);
					
					model.setValueAt(discount, selectedRow, 4);
					model.setValueAt(category, selectedRow, 5);
					model.setValueAt(genre, selectedRow, 6);
					model.setValueAt(creator, selectedRow, 7);
					model.setValueAt(year,selectedRow, 8);
					
					
					
					//Update into items list in inventory 
					
					product.setProductId(Integer.parseInt(id));
					product.setName(name);
					product.setPrice(Double.parseDouble(price));
					product.setDiscount(Double.parseDouble(discount));
					product.setGenre(genre);
					product.setCategory(category);
					product.setNumberOfItemsStocked(Integer.parseInt(amount));
					product.setCreator(creator);
					product.setYearPublished(Integer.parseInt(year));
					
					
					inventory.categoryListUpdate();
				
				
				}
				else {
					JOptionPane.showMessageDialog(null,"Please Select Any of Row","Error", JOptionPane.WARNING_MESSAGE);

				}
				
				
				inventory.updateDatabase();
				
				
			}

		
			else if(e.getSource() == backButton) {
				inventory.updateDatabase();
				mainFrame.showHomePage();
			}
			else if(e.getSource() == exitButton) {
				inventory.updateDatabase();
				System.exit(0);
			}
		
		
		
		

		
	}
	

}

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//Callback.java
public interface Callback {
void onLoginAttempt(boolean success);
}


public class LoginPanel extends JPanel implements ActionListener{

	private JTextField tf;
	private JPasswordField pf;
	private JLabel loginLabel, passLabel, userNameLabel, shopName;
	private JButton loginButton;
	
	private String userName = "asif";
	private String password = "asif";
	
	private boolean flag;
	
	private Callback callback;
	
	
	public LoginPanel(Callback callback){
		
		this.callback = callback;
		
		flag = false;
		this.setLayout(null);
		this.setBounds(0, 0, 1600,1000);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		

		shopName = new JLabel("MelodyMart");
		shopName.setOpaque(true);
		shopName.setBackground(null);
		shopName.setForeground(Color.red);
		shopName.setFont(new Font("Algerian", Font.BOLD, 90));
		shopName.setHorizontalAlignment(JLabel.CENTER);
		shopName.setBounds(350,120,800,300 );
		
		
		
		
		loginLabel = new JLabel("Sign In Panel");
		loginLabel.setHorizontalAlignment(JLabel.CENTER);
		loginLabel.setFont(new Font("BankGothic Md BT", Font.BOLD, 50));
		loginLabel.setBounds(550, 400, 400, 100);
		loginLabel.setOpaque(true);
		loginLabel.setBackground(null);
		loginLabel.setForeground(Color.blue);
		
				
		userNameLabel = new JLabel("User Name");
		userNameLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));
		userNameLabel.setBounds(500, 520, 200, 40);
		userNameLabel.setOpaque(true);
		userNameLabel.setBackground(null);
		userNameLabel.setForeground(new Color(0,110,120));
		
		
		passLabel = new JLabel("Password"); 
		passLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));
		passLabel.setBounds(500, 600, 200, 40);
		passLabel.setOpaque(true);
		passLabel.setBackground(null);
		passLabel.setForeground(new Color(0,110,120));
		
		
	    loginButton = new JButton("Login");
	    loginButton.setBorder(getBorder());
	    loginButton.setFont(new Font("BankGothic Lt BT", Font.BOLD, 30));
		loginButton.setBackground(Color.DARK_GRAY);
		loginButton.setForeground(Color.white);
		loginButton.setBounds(900, 700, 100,50);
	
		
		tf = new JTextField();
		tf.setFont(new Font("Century Gothic", Font.BOLD, 30));
		tf.setBackground(Color.white);
		tf.setForeground(Color.blue);
		tf.setBounds(800, 520, 200, 40);
		
		
		pf = new JPasswordField();
		pf.setFont(new Font("Century Gothic", Font.BOLD, 30));
		pf.setBackground(Color.white);
		pf.setForeground(Color.blue);
		pf.setBounds(800, 600, 200, 40);
		
		
	   
		
		
		
		
		this.add(loginLabel);
		this.add(passLabel);
		this.add(userNameLabel);
		add(shopName);		
		
		
		this.add(tf);
		this.add(pf);
		
		
		loginButton.addActionListener(this);
	    this.add(loginButton);
		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {
	    if (userName.equals(tf.getText()) && password.equals(pf.getText())) {
	        callback.onLoginAttempt(true);
	    } else {
	        callback.onLoginAttempt(false);
	    }
	}
   
	
	
}

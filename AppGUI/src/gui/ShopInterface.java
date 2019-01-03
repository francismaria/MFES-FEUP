package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
import java.awt.Color;

public class ShopInterface {
	
	private JFrame frame;
	
	CardLayout cardLayout = new CardLayout();
	
	private JPanel cardShowingPanel = new JPanel();
	private JPanel initialPanel;
	private JPanel sellerHomePanel;
	private JPanel costumerHomePanel;
	
	private static int FRAME_DIMENSION = 600;
	private JLabel shopDescrpLabel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JPanel registerPanel;
	private JTextField newUsernameField;
	private JTextField newPasswordField;
	private JTextField RptNewPasswordField;
	private JButton signupBtn;
	private JLabel newUsernameLabel;
	private JLabel newPasswordLabel;
	private JLabel lblRepeatPassword;
	private JLabel welcomeLabel;
	
	private void fillInitialPanel() {
		initialPanel = new JPanel();
		
		initialPanel.setLayout(null);
		{
			shopDescrpLabel = new JLabel("Best Shopper and Reviewer");
			shopDescrpLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			shopDescrpLabel.setBounds(171, 65, 260, 29);
			initialPanel.add(shopDescrpLabel);
		}
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		loginLabel.setBounds(114, 167, 85, 29);
		initialPanel.add(loginLabel);
		
		JLabel registerLabel = new JLabel("Register");
		registerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		registerLabel.setBounds(400, 167, 85, 29);
		initialPanel.add(registerLabel);
		
		JPanel loginCredentialsPanel = new JPanel();
		loginCredentialsPanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));
		loginCredentialsPanel.setBounds(10, 197, 278, 340);
		initialPanel.add(loginCredentialsPanel);
		loginCredentialsPanel.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(78, 71, 130, 26);
		loginCredentialsPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(78, 176, 130, 26);
		loginCredentialsPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JButton signinBtn = new JButton("Sign In");
		signinBtn.setBounds(78, 271, 130, 29);
		loginCredentialsPanel.add(signinBtn);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(69, 43, 76, 16);
		loginCredentialsPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(69, 150, 85, 16);
		loginCredentialsPanel.add(passwordLabel);
		
		registerPanel = new JPanel();
		registerPanel.setBorder(new MatteBorder(4, 0, 4, 4, (Color) new Color(0, 0, 0)));
		registerPanel.setBounds(289, 197, 294, 340);
		initialPanel.add(registerPanel);
		registerPanel.setLayout(null);
		
		newUsernameField = new JTextField();
		newUsernameField.setBounds(84, 73, 130, 26);
		registerPanel.add(newUsernameField);
		newUsernameField.setColumns(10);
		
		newPasswordField = new JTextField();
		newPasswordField.setBounds(84, 151, 130, 26);
		registerPanel.add(newPasswordField);
		newPasswordField.setColumns(10);
		
		RptNewPasswordField = new JTextField();
		RptNewPasswordField.setBounds(84, 211, 130, 26);
		registerPanel.add(RptNewPasswordField);
		RptNewPasswordField.setColumns(10);
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(84, 271, 130, 29);
		registerPanel.add(signupBtn);
		
		newUsernameLabel = new JLabel("New Username:");
		newUsernameLabel.setBounds(84, 40, 104, 16);
		registerPanel.add(newUsernameLabel);
		
		newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setBounds(84, 111, 104, 16);
		registerPanel.add(newPasswordLabel);
		
		lblRepeatPassword = new JLabel("Repeat Password:");
		lblRepeatPassword.setBounds(84, 189, 115, 16);
		registerPanel.add(lblRepeatPassword);
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		signinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Test LOGIN
				//if user is SELLER : sellerHomePanel
				//else : costumerHomePanel
				System.out.println("LOGIN");
			}
		});
		
		signupBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Test register
				System.out.println("REGISTER");
			}
		});
		
		loginCredentialsPanel.setVisible(true);
		registerPanel.setVisible(true);
	}

	private void fillSellerHomePanel() {
		sellerHomePanel = new JPanel();
		
		sellerHomePanel.setLayout(null);
		welcomeLabel = new JLabel("Welcome, ");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		welcomeLabel.setBounds(176, 37, 284, 27);
		sellerHomePanel.add(welcomeLabel);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		sellerHomePanel.add(logoutBtn);
		
		JLabel myProductsLabel = new JLabel("My Products");
		myProductsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		myProductsLabel.setBounds(260, 104, 100, 16);
		sellerHomePanel.add(myProductsLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(579, 6, 15, 566);
		sellerHomePanel.add(scrollBar);
		
		JButton prod1 = new JButton("Product 1");
		prod1.setBounds(15, 175, 129, 70);
		sellerHomePanel.add(prod1);
		
		JButton removeProd1 = new JButton();
		removeProd1.setBounds(410, 175, 70, 70);
		try {
			Image img = ImageIO.read(getClass().getResource("/assets/remove_item_icon.png"));
			Image resizedImg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
			removeProd1.setIcon(new ImageIcon(resizedImg));
		} catch(Exception ex) {
			System.out.println("EXCEPTION AT : " + ex.toString());
		}
		sellerHomePanel.add(removeProd1);
		
		JButton incrementQtyProd1 = new JButton();
		incrementQtyProd1.setBounds(500, 175, 70, 70);
		try {
			Image img = ImageIO.read(getClass().getResource("/assets/add_item_icon.png"));
			Image resizedImg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
			incrementQtyProd1.setIcon(new ImageIcon(resizedImg));
		} catch(Exception ex) {
			System.out.println("EXCEPTION AT : " + ex.toString());
		}
		sellerHomePanel.add(incrementQtyProd1);
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("USER LOGOUT");
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
	}

	private void fillCostumerHomePanel() {
		costumerHomePanel = new JPanel();
	}

	public ShopInterface() {
		frame = new JFrame();
		frame.setSize(FRAME_DIMENSION,FRAME_DIMENSION);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		cardShowingPanel.setLayout(cardLayout);
		
		fillInitialPanel();
		fillSellerHomePanel();
		fillCostumerHomePanel();
		
		cardShowingPanel.add(initialPanel, "CARD_INITIAL_PANEL");
		cardShowingPanel.add(sellerHomePanel, "CARD_SELLER_HOME_PANEL");
		

		
		
		
		cardShowingPanel.add(costumerHomePanel, "CARD_COSTUMER_HOME_PANEL");
		costumerHomePanel.setLayout(null);
		
		cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
		
		
		frame.getContentPane().add(cardShowingPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShopInterface();
			}
		});
	}
}

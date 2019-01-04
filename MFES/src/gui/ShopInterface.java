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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ShopInterface {
	
	private JFrame frame;
	
	CardLayout cardLayout = new CardLayout();
	
	private JPanel cardShowingPanel = new JPanel();
	private JPanel initialPanel;
	
	//	Seller Panels
	private JPanel sellerHomePanel;
	private JPanel sellerAddNewProductPanel;
	private JPanel sellerProductInfoPanel;
	
	// Costumer Panels
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
	private JLabel newProdLabel;
	private JLabel productDescrLabel;
	private JLabel productNameLabel;
	private JLabel productPriceLabel;
	private JTextField prodNameField;
	private JTextField prodDescrpField;
	private JTextField prodPriceField;
	private JLabel prodInfoLabel;
	private JLabel prodNameLabel;
	private JLabel prodDescrpLabel;
	private JLabel prodPriceLabel;
	private JLabel prodQtyLabel;
	private JLabel prodRatingLabel;
	private JLabel prodReviewLabel;
	
	private Box costumerBuyBox;
	
	private ActionListener logoutAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//LOGOUT!! 
			System.out.println("USER LOGOUT");
			cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
		}
	};
	private JLabel buyProdLabel;
	private JScrollPane scrollPane;
	
	/*---------------------------------------------------
	 * 				FILL INITIAL PANEL
	 ---------------------------------------------------*/
	
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

	/*---------------------------------------------------
	 * 			   FILL SELLER HOME PANEL
	 ---------------------------------------------------*/
	
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
		
		JButton addNewProdBtn = new JButton("Add New Product");
		addNewProdBtn.setBounds(420, 65, 150, 40);
		sellerHomePanel.add(addNewProdBtn);
		
		
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
		
		addNewProdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("Add new Product");
				cardLayout.show(cardShowingPanel, "CARD_SELLER_ADD_NEW_PROD_PANEL");
			}
		});
		
	}
	
	private void fillSellerAddNewProdPanel() {
		sellerAddNewProductPanel = new JPanel();
		sellerAddNewProductPanel.setLayout(null);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		sellerAddNewProductPanel.add(logoutBtn);
		
		newProdLabel = new JLabel("Add New Product");
		newProdLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		newProdLabel.setBounds(239, 78, 155, 25);
		sellerAddNewProductPanel.add(newProdLabel);
		
		productDescrLabel = new JLabel("Product Description:");
		productDescrLabel.setBounds(100, 256, 136, 25);
		sellerAddNewProductPanel.add(productDescrLabel);
		
		productNameLabel = new JLabel("Product Name:");
		productNameLabel.setBounds(100, 177, 100, 25);
		sellerAddNewProductPanel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Product Price:");
		productPriceLabel.setBounds(100, 339, 100, 25);
		sellerAddNewProductPanel.add(productPriceLabel);
		
		prodNameField = new JTextField();
		prodNameField.setBounds(287, 176, 266, 26);
		sellerAddNewProductPanel.add(prodNameField);
		prodNameField.setColumns(10);
		
		prodDescrpField = new JTextField();
		prodDescrpField.setColumns(10);
		prodDescrpField.setBounds(287, 256, 266, 26);
		sellerAddNewProductPanel.add(prodDescrpField);
		
		prodPriceField = new JTextField();
		prodPriceField.setColumns(10);
		prodPriceField.setBounds(287, 338, 266, 26);
		sellerAddNewProductPanel.add(prodPriceField);
		
		JButton newProdBtn = new JButton("Add New Product");
		newProdBtn.setBounds(239, 462, 143, 40);
		sellerAddNewProductPanel.add(newProdBtn);
		
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
		
		newProdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//adicionar um novo produto aos do user! 
				System.out.println("ADD NEW PRODUCT");
				cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
			}
		});
	}
	
	private void fillSellerProductInfoPanel(){
		sellerProductInfoPanel = new JPanel();
		sellerProductInfoPanel.setLayout(null);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		sellerProductInfoPanel.add(logoutBtn);
		
		prodInfoLabel = new JLabel("Product Information");
		prodInfoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		prodInfoLabel.setBounds(227, 83, 183, 26);
		sellerProductInfoPanel.add(prodInfoLabel);
		
		prodNameLabel = new JLabel("Name:");
		prodNameLabel.setBounds(99, 186, 61, 16);
		sellerProductInfoPanel.add(prodNameLabel);
		
		prodDescrpLabel = new JLabel("Description:");
		prodDescrpLabel.setBounds(99, 243, 87, 16);
		sellerProductInfoPanel.add(prodDescrpLabel);
		
		prodPriceLabel = new JLabel("Price:");
		prodPriceLabel.setBounds(99, 301, 61, 16);
		sellerProductInfoPanel.add(prodPriceLabel);
		
		prodQtyLabel = new JLabel("Quantity:");
		prodQtyLabel.setBounds(99, 366, 61, 16);
		sellerProductInfoPanel.add(prodQtyLabel);
		
		prodRatingLabel = new JLabel("Rating:");
		prodRatingLabel.setBounds(99, 428, 61, 16);
		sellerProductInfoPanel.add(prodRatingLabel);
		
		prodReviewLabel = new JLabel("Reviews:");
		prodReviewLabel.setBounds(99, 485, 61, 16);
		sellerProductInfoPanel.add(prodReviewLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(582, 6, 15, 566);
		sellerProductInfoPanel.add(scrollBar);
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("SELLER LOGOUT");
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
	}
	
	private void addProductPanel(String panelName, int index) {
		final int height = 76;
		final int initialY = 160;
		
		JPanel prodPanel = new JPanel();
		prodPanel.setBounds(24, initialY+(height*index), 546, height);
		prodPanel.setPreferredSize(new Dimension(520, height));
		costumerBuyBox.add(prodPanel);
		prodPanel.setLayout(null);
		
		JButton prod1Btn = new JButton("Product1");
		prod1Btn.setBounds(0, 22, 100, 29);
		prodPanel.add(prod1Btn);
		
		JButton buyButton = new JButton("Buy");
		buyButton.setBounds(423, 22, 117, 29);
		prodPanel.add(buyButton);
	}
	
	/*---------------------------------------------------
	 * 			     FILL COSTUMER PANEL
	 ---------------------------------------------------*/
	private void fillCostumerHomePanel() {
		costumerHomePanel = new JPanel();
		costumerHomePanel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, ");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		welcomeLabel.setBounds(176, 37, 284, 27);
		costumerHomePanel.add(welcomeLabel);
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		costumerHomePanel.add(logoutBtn);
		
		buyProdLabel = new JLabel("Buy a Product");
		buyProdLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buyProdLabel.setBounds(206, 97, 131, 27);
		costumerHomePanel.add(buyProdLabel);
		
		costumerBuyBox = new Box(BoxLayout.Y_AXIS);
		
		
		scrollPane = new JScrollPane(costumerBuyBox);
		scrollPane.setBounds(18, 149, 564, 401);
		costumerHomePanel.add(scrollPane);
		
		int i;
		
		for(i = 0; i < 10; i++) {
			String panelName = "prod" + Integer.toString(i) + "Panel";
			addProductPanel(panelName, i+1);
			costumerBuyBox.revalidate();
		}
		
		
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		/*logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("COSTUMER LOGOUT");
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});*/
		logoutBtn.addActionListener(logoutAction);
	}

	public ShopInterface() {
		frame = new JFrame();
		frame.setSize(FRAME_DIMENSION,FRAME_DIMENSION);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		cardShowingPanel.setLayout(cardLayout);
		
		fillInitialPanel();
		
		fillSellerHomePanel();
		fillSellerAddNewProdPanel();
		fillSellerProductInfoPanel();
		
		fillCostumerHomePanel();
		
		
		cardShowingPanel.add(initialPanel, "CARD_INITIAL_PANEL");
		
		// Seller Panels
		cardShowingPanel.add(sellerHomePanel, "CARD_SELLER_HOME_PANEL");
		cardShowingPanel.add(sellerAddNewProductPanel, "CARD_SELLER_ADD_NEW_PROD_PANEL");
		cardShowingPanel.add(sellerProductInfoPanel, "CARD_SELLER_PROD_INFO_PANEL");
		
		// Costumer Panels
		cardShowingPanel.add(costumerHomePanel, "CARD_COSTUMER_HOME_PANEL");
		

		

		
		
		
		
		cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
		
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

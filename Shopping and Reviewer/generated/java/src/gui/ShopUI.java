package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.border.MatteBorder;

import org.overture.codegen.runtime.VDMSet;

import model.Costumer;
import model.Product;
import model.Review;
import model.Seller;
import model.Shop;
import model.User;
import quotes.COSTUMERQuote;
import quotes.SELLERQuote;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ShopUI {
	
	private Shop shop = new Shop("LOJA");
	
	private JFrame frame;
	
	CardLayout cardLayout = new CardLayout();
	
	private JPanel cardShowingPanel = new JPanel();
	private JPanel initialPanel = new JPanel();
	
	//	Seller Panels
	private JPanel sellerHomePanel = new JPanel();
	private JPanel sellerAddNewProductPanel = new JPanel();
	private JPanel sellerProductInfoPanel = new JPanel();
	
	// Costumer Panels
	private JPanel costumerHomePanel = new JPanel();
	private JPanel prodInformationCostumerPanel = new JPanel();
	
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
	private Box sellerHomeBox;
	
	private JLabel buyProdLabel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneSellerHome;
	
	private ImageIcon addIcon;
	private ImageIcon removeIcon;
	private ImageIcon backIcon;
	
	private ActionListener logoutAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//LOGOUT!! 
			System.out.println("USER LOGOUT");
			cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
		}
	};
	
	/*---------------------------------------------------
	 * 				FILL INITIAL PANEL
	 ---------------------------------------------------*/
	
	private void fillInitialPanel() {
		initialPanel.setLayout(null);
		initialPanel.removeAll();
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
		signinBtn.setBounds(78, 278, 130, 29);
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
		signupBtn.setBounds(84, 280, 130, 29);
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
		
		JRadioButton sellerRadioBtn = new JRadioButton("SELLER");
		sellerRadioBtn.setBounds(27, 249, 141, 23);
		registerPanel.add(sellerRadioBtn);
		
		JRadioButton costumerRadioBtn = new JRadioButton("COSTUMER");
		costumerRadioBtn.setBounds(164, 249, 141, 23);
		registerPanel.add(costumerRadioBtn);
		
		initialPanel.revalidate();
		initialPanel.repaint();
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		costumerRadioBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				costumerRadioBtn.setSelected(true);
				sellerRadioBtn.setSelected(false);
			}
		});
		
		sellerRadioBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sellerRadioBtn.setSelected(true);
				costumerRadioBtn.setSelected(false);
			}
		});
		
		//----------- LOG IN
		signinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("CLICKED+USERNAME: " + usernameField.getText() + " ---" + passwordField.getText());
				
				if(shop.login(usernameField.getText(), passwordField.getText())) {
					if(shop.getLoggedUser() instanceof Seller) {
						fillSellerHomePanel();
						cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
					} else if (shop.getLoggedUser() instanceof Costumer) {
						fillCostumerHomePanel();
						cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
					}
				} else {
					System.out.println("Wrong credentials");
				}
			}
		});
		
		//----------- REGISTER
		signupBtn.addActionListener(new ActionListener() {
			
			private boolean checkPasswordsMatch(final String pwd1, final String pwd2) {
				return pwd1.equals(pwd2);
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkPasswordsMatch(newPasswordField.getText(), RptNewPasswordField.getText())) {
					if(sellerRadioBtn.isSelected()) {
						shop.register(newUsernameField.getText(), newPasswordField.getText(), SELLERQuote.getInstance());
						fillSellerHomePanel();
						cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
					} else if(costumerRadioBtn.isSelected()) {
						shop.register(newUsernameField.getText(), newPasswordField.getText(), COSTUMERQuote.getInstance());
						fillCostumerHomePanel();
						cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
					} else {
						System.out.println("Error: You have not chosen a type.");
						return;
					}
				} else {
					System.out.println("Error: Passwords don't match.");
					return;
				}
			}
		});
		
		loginCredentialsPanel.setVisible(true);
		registerPanel.setVisible(true);
	}

	/*---------------------------------------------------
	 * 			   FILL SELLER HOME PANEL
	 ---------------------------------------------------*/
	
	private void fillSellerHomeProductsPanel(int index, long prodLong, Product prod) {
		final int height = 80;
		final int initialY = 175;
		
		
		JPanel prodPanel = new JPanel();
		prodPanel.setLayout(null);
		prodPanel.setBounds(15, initialY+(height*index), 546, height);
		prodPanel.setPreferredSize(new Dimension(520, 100));
		
		JButton prod1 = new JButton(prod.getName());
		prod1.setBounds(15, 15, 129, 70);
		prodPanel.add(prod1);
		
		JLabel rating = new JLabel(Double.toString(prod.getRating().doubleValue()));
		rating.setBounds(150, 25, 50, 16);
		prodPanel.add(rating);
		
		JLabel addPlus = new JLabel(prod.getQuantity().toString());
		addPlus.setBounds(220, 25, 50, 16);
		prodPanel.add(addPlus);
		
		JButton removeProd1 = new JButton();
		removeProd1.setBounds(380, 15, 70, 70);
		removeProd1.setIcon(removeIcon);
		
		prodPanel.add(removeProd1);
		
		JButton incrementQtyProd1 = new JButton();
		incrementQtyProd1.setBounds(470, 15, 70, 70);
		incrementQtyProd1.setIcon(addIcon);

		prodPanel.add(incrementQtyProd1);
		
		sellerHomeBox.add(prodPanel);
		
		//*********** ACTION LISTENERS ***************/
		
		removeProd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Seller seller = (Seller)shop.getLoggedUser();
				seller.removeProduct(prodLong);
				shop.updateProducts();
				fillSellerHomePanel();
			}
		});
		
		incrementQtyProd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Seller seller = (Seller)shop.getLoggedUser();
				seller.getProduct(prodLong).incrementQuantity();
				fillSellerHomePanel();
			}
		});
	}
	
	private void fillSellerHomePanel() {
		sellerHomePanel.setLayout(null);
		sellerHomePanel.removeAll();
		welcomeLabel = new JLabel("Welcome, " + shop.getLoggedUser().getUsername());
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
		
		sellerHomeBox = new Box(BoxLayout.Y_AXIS);
		
		
		scrollPaneSellerHome = new JScrollPane(sellerHomeBox);
		scrollPaneSellerHome.setBounds(18, 149, 564, 401);
		sellerHomePanel.add(scrollPaneSellerHome);
		
		Seller seller = (Seller) shop.getLoggedUser();
		VDMSet prods = seller.getAllProducts();
		
		int i, numProds = prods.size();
		long index = 1L;
		
		for(i = 0; i < numProds; i++) {
			try {
				fillSellerHomeProductsPanel(i, index, seller.getProduct(index));
			} catch (IllegalArgumentException e) {
				boolean notFound = true;
				
				while(notFound) {
					index += 1L;
					try {
						fillSellerHomeProductsPanel(i, index, seller.getProduct(index));
					} catch (IllegalArgumentException subEx) {
						continue;
					}
					notFound = false;
				}
				
				sellerHomeBox.revalidate();
				sellerHomeBox.repaint();
				continue;
			}
			index += 1L;
			sellerHomeBox.revalidate();
			sellerHomeBox.repaint();
		}
		scrollPaneSellerHome.revalidate();
		scrollPaneSellerHome.repaint();
		sellerHomePanel.revalidate();
		sellerHomePanel.repaint();
		
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
	
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.logout();
				fillInitialPanel();
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
		
		addNewProdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillSellerAddNewProdPanel();
				cardLayout.show(cardShowingPanel, "CARD_SELLER_ADD_NEW_PROD_PANEL");
			}
		});
		
	}
	
	private void fillSellerAddNewProdPanel() {
		sellerAddNewProductPanel.setLayout(null);
		sellerAddNewProductPanel.removeAll();
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		sellerAddNewProductPanel.add(logoutBtn);
		
		JButton backButton = new JButton();
		backButton.setBounds(20, 15, 70, 70);
		backButton.setIcon(backIcon);

		sellerAddNewProductPanel.add(backButton);
		
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
		
		prodPriceField.setText("");
		prodDescrpField.setText("");
		prodNameField.setText("");
		
		sellerAddNewProductPanel.revalidate();
		sellerAddNewProductPanel.repaint();
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.logout();
				fillInitialPanel();
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
		
		newProdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Seller seller = (Seller)shop.getLoggedUser();
				Product newProd = new Product(prodNameField.getText(),
										prodDescrpField.getText(), Double.parseDouble(prodPriceField.getText()));
				seller.addNewProduct(newProd);
				shop.updateProducts();
				fillSellerHomePanel();
				cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("SELLER LOGOUT");
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
		
		JButton backButton = new JButton();
		backButton.setBounds(20, 15, 70, 70);
		backButton.setIcon(backIcon);
		
		sellerProductInfoPanel.add(backButton);
		
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
				shop.logout();
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGOUT!! 
				System.out.println("SELLER LOGOUT");
				cardLayout.show(cardShowingPanel, "CARD_SELLER_HOME_PANEL");
			}
		});
	}
	
	
	/*
	 * -----------------------------------------------------------------------------------------------
	 * 										COSTUMER
	 * -----------------------------------------------------------------------------------------------
	 */
	
	private void fillProductInformationPanel(Product prod) {
		prodInformationCostumerPanel.setLayout(null);
		prodInformationCostumerPanel.removeAll();
		
		JButton logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(470, 15, 100, 40);
		prodInformationCostumerPanel.add(logoutBtn);
		
		JButton backButton = new JButton();
		backButton.setBounds(20, 15, 70, 70);
		backButton.setIcon(backIcon);
		prodInformationCostumerPanel.add(backButton);
		
		JLabel titleLabel = new JLabel("Product Information");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setBounds(200, 37, 284, 27);
		prodInformationCostumerPanel.add(titleLabel);
		
		JLabel name = new JLabel("Name: " + prod.getName());
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		name.setBounds(30, 80, 284, 27);
		prodInformationCostumerPanel.add(name);
		
		JLabel description = new JLabel("Description: " + prod.getDescription());
		description.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		description.setBounds(30, 130, 284, 27);
		prodInformationCostumerPanel.add(description);
		
		JLabel rating = new JLabel("Rating: " + prod.getRating().toString() + " (" + prod.getReviews().size() + ")");
		rating.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		rating.setBounds(30, 190, 120, 27);
		prodInformationCostumerPanel.add(rating);
		
		JLabel price = new JLabel("Price: " + Double.toString(prod.getPrice().doubleValue()));
		price.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		price.setBounds(200, 190, 120, 27);
		prodInformationCostumerPanel.add(price);
		
		JLabel stock = new JLabel("Stock: " + Integer.toString(prod.getQuantity().intValue()));
		stock.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		stock.setBounds(350, 190, 120, 27);
		prodInformationCostumerPanel.add(stock);
		
		JButton buyBtn = new JButton("Buy Product");
		buyBtn.setBounds(210, 230, 100, 40);
		prodInformationCostumerPanel.add(buyBtn);
		
		JButton reviewBtn = new JButton("Add Review");
		reviewBtn.setBounds(310, 230, 100, 40);
		prodInformationCostumerPanel.add(reviewBtn);
		
		JTextArea write = new JTextArea(20,60);
		write.setBounds(30, 300, 540, 150);
		write.setVisible(false);
		prodInformationCostumerPanel.add(write);
		
		JButton submitReviewBtn = new JButton("Submit Review");
		submitReviewBtn.setBounds(200, 500, 150, 40);
		submitReviewBtn.setVisible(false);
		prodInformationCostumerPanel.add(submitReviewBtn);
		
		JRadioButton oneStar = new JRadioButton("1");
		oneStar.setBounds(70, 460, 150, 40);
		JRadioButton twoStar = new JRadioButton("2");
		twoStar.setBounds(170, 460, 70, 40);
		JRadioButton threeStar = new JRadioButton("3");
		threeStar.setBounds(290, 460, 70, 40);
		JRadioButton fourStar = new JRadioButton("4");
		fourStar.setBounds(400, 460, 70, 40);
		JRadioButton fiveStar = new JRadioButton("5");
		fiveStar.setBounds(500, 460, 70, 40);
		
		oneStar.setVisible(false); twoStar.setVisible(false);
		threeStar.setVisible(false); fourStar.setVisible(false);
		fiveStar.setVisible(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(oneStar);
		prodInformationCostumerPanel.add(oneStar);
		group.add(twoStar);
		prodInformationCostumerPanel.add(twoStar);
		group.add(threeStar);
		prodInformationCostumerPanel.add(threeStar);
		group.add(fourStar);
		prodInformationCostumerPanel.add(fourStar);
		group.add(fiveStar);
		prodInformationCostumerPanel.add(fiveStar);
		
		prodInformationCostumerPanel.revalidate();
		prodInformationCostumerPanel.repaint();
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.logout();
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
		
		reviewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				write.setVisible(true);
				oneStar.setVisible(true); twoStar.setVisible(true);
				threeStar.setVisible(true); fourStar.setVisible(true);
				fiveStar.setVisible(true);
				submitReviewBtn.setVisible(true);
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
			}
		});
		
		submitReviewBtn.addActionListener(new ActionListener() {
			private String getSelectedButtonText() {
			    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			        AbstractButton button = buttons.nextElement();
			        if (button.isSelected()) {
			                return button.getText();
			        }
			    }
			    return null;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = getSelectedButtonText();
				if(value == null) return;
				int rate = Integer.parseInt(value);
				
				Review userReview = new Review(write.getText(), rate, shop.getLoggedUser());
				prod.addReview(userReview);
				fillCostumerHomePanel();
				cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
			}
		});
	}
	
	
	private void addProductPanel(int index, Product prod) {
		final int height = 76;
		final int initialY = 160;
		
		JPanel prodPanel = new JPanel();
		prodPanel.setBounds(24, initialY+(height*index), 546, height);
		prodPanel.setPreferredSize(new Dimension(520, height));
		costumerBuyBox.add(prodPanel);
		prodPanel.setLayout(null);
		
		JButton prodBtn = new JButton(prod.getName());
		prodBtn.setBounds(0, 22, 100, 29);
		prodPanel.add(prodBtn);
		
		JLabel rating = new JLabel(Double.toString(prod.getRating().doubleValue()));
		rating.setBounds(120, 22, 70, 30);
		prodPanel.add(rating);
		
		JLabel price = new JLabel(Double.toString(prod.getPrice().doubleValue()));
		price.setBounds(220, 22, 70, 30);
		prodPanel.add(price);
		
		JButton buyButton = new JButton("Buy");
		buyButton.setBounds(423, 22, 117, 29);
		prodPanel.add(buyButton);
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		prodBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillProductInformationPanel(prod);
				cardLayout.show(cardShowingPanel, "CARD_COSTUMER_PROD_INFO_PANEL");
			}
		});
		
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prod.decrementQuantity(1);
				fillCostumerHomePanel();
				cardLayout.show(cardShowingPanel, "CARD_COSTUMER_HOME_PANEL");
			}
		});
	}
	
	/*---------------------------------------------------
	 * 			     FILL COSTUMER PANEL
	 ---------------------------------------------------*/
	private void fillCostumerHomePanel() {
		costumerHomePanel.setLayout(null);
		costumerHomePanel.removeAll();
		
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
		
		int i = 0, prodsSize = shop.getNumberOfProducts().intValue();
		VDMSet users = (VDMSet) shop.getRegisteredUsers();
		
		
		Iterator<Object> it = users.iterator();
		
		while(it.hasNext()) {
			User user = (User) it.next();
			
			if(user.getType().toString().equals("<SELLER>")) {
				
				VDMSet userProds = (VDMSet) shop.getRegisteredProducts().get(user.getUsername());
				Iterator<Object> prodsIt = userProds.iterator();
				
				while(prodsIt.hasNext()) {
					Product prod = (Product) prodsIt.next();
					addProductPanel(i, prod);
					costumerBuyBox.revalidate();
					costumerBuyBox.repaint();
					i++;
				}
					
			} else {
				System.out.println("COSTUMER");
			}
	
		}

		scrollPane.revalidate();
		scrollPane.repaint();
		
		costumerHomePanel.revalidate();
		costumerHomePanel.repaint();
		
		/*------------------------------------------------
		 * 				ACTION LISTENERS
		 *------------------------------------------------*/
		
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.logout();
				fillInitialPanel();
				cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
			}
		});
	}
	
	private void initAssets() {
		
				//REMOVE ICON
		try {
			Image img = ImageIO.read(getClass().getResource("/assets/remove_item_icon.png"));
			Image resizedImg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
			removeIcon = new ImageIcon(resizedImg);
		} catch(Exception ex) {
			System.out.println("EXCEPTION AT : " + ex.toString());
		}
		
				//ADD ICON
		try {
			Image img = ImageIO.read(getClass().getResource("/assets/add_item_icon.png"));
			Image resizedImg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
			addIcon = new ImageIcon(resizedImg);
		} catch(Exception ex) {
			System.out.println("EXCEPTION AT : " + ex.toString());
		}
		
				//BACK ICON
		try {
			Image img = ImageIO.read(getClass().getResource("/assets/back_arrow_icon.png"));
			Image resizedImg = img.getScaledInstance( 40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
			backIcon = new ImageIcon(resizedImg);
		} catch(Exception ex) {
			System.out.println("EXCEPTION AT : " + ex.toString());
		}
	}

	public ShopUI() {
		frame = new JFrame();
		frame.setSize(FRAME_DIMENSION,FRAME_DIMENSION);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		initAssets();
		
		
		cardShowingPanel.setLayout(cardLayout);
		
		fillInitialPanel();
		
		//fillSellerHomePanel();
		//fillSellerAddNewProdPanel();
		//fillSellerProductInfoPanel();
		
		//fillCostumerHomePanel();
		
		
		cardShowingPanel.add(initialPanel, "CARD_INITIAL_PANEL");
		
		// Seller Panels
		cardShowingPanel.add(sellerHomePanel, "CARD_SELLER_HOME_PANEL");
		cardShowingPanel.add(sellerAddNewProductPanel, "CARD_SELLER_ADD_NEW_PROD_PANEL");
		cardShowingPanel.add(sellerProductInfoPanel, "CARD_SELLER_PROD_INFO_PANEL");
		
		// Costumer Panels
		cardShowingPanel.add(costumerHomePanel, "CARD_COSTUMER_HOME_PANEL");
		cardShowingPanel.add(prodInformationCostumerPanel, "CARD_COSTUMER_PROD_INFO_PANEL");
		
		
		cardLayout.show(cardShowingPanel, "CARD_INITIAL_PANEL");
		
		frame.getContentPane().add(cardShowingPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShopUI();
			}
		});
	}
}


package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UserTest extends MyTest {
  private Number numUsers = 0L;

  private void createNewUser() {

    Seller seller = null;
    Costumer costumer = null;
    seller = new Seller("TestSeller", "password1");
    numUsers = numUsers.longValue() + 1L;
    costumer = new Costumer("TestCostumer", "password1");
    numUsers = numUsers.longValue() + 1L;
    assert_(Utils.equals(seller.getUsername(), "TestSeller"));
    assert_(Utils.equals(costumer.getUsername(), "TestCostumer"));
  }

  private void correctNumberOfUsers() {

    Seller seller = null;
    Costumer costumer = null;
    Costumer costumer2 = null;
    Seller seller2 = null;
    Seller seller3 = null;
    assert_(Utils.equals(User.getNumberOfUsers(), numUsers));
    seller = new Seller("TestSeller", "password1");
    numUsers = numUsers.longValue() + 1L;
    costumer = new Costumer("TestCostumer", "password1");
    numUsers = numUsers.longValue() + 1L;
    seller2 = new Seller("TestSeller2", "password1");
    numUsers = numUsers.longValue() + 1L;
    seller3 = new Seller("TestSeller3", "password1");
    numUsers = numUsers.longValue() + 1L;
    costumer2 = new Costumer("TestCostumer2", "password1");
    numUsers = numUsers.longValue() + 1L;
    assert_(Utils.equals(User.getNumberOfUsers(), numUsers));
    assert_(Utils.equals(costumer2.getUserID(), numUsers));
  }

  private void changeUsername() {

    Seller seller = new Seller("TestSeller", "password1");
    numUsers = numUsers.longValue() + 1L;
    if (seller.checkCredentials("password1")) {
      assert_(Utils.equals(seller.getUsername(), "TestSeller"));
      seller.setNewUsername("NewTestSellerUsername");
      assert_(Utils.equals(seller.getUsername(), "NewTestSellerUsername"));
    }
  }

  private void correctType() {

    Seller seller = null;
    Costumer costumer = null;
    seller = new Seller("TestSeller", "password1");
    numUsers = numUsers.longValue() + 1L;
    costumer = new Costumer("TestCostumer", "password1");
    numUsers = numUsers.longValue() + 1L;
    assert_(Utils.equals(seller.getType(), quotes.SELLERQuote.getInstance()));
    assert_(Utils.equals(costumer.getType(), quotes.COSTUMERQuote.getInstance()));
  }

  private void checkLogging() {

    Seller seller = null;
    seller = new Seller("TestSeller", "password1");
    numUsers = numUsers.longValue() + 1L;
    assert_(Utils.equals(seller.checkCredentials("password1"), true));
    assert_(Utils.equals(seller.isLoggedIn(), true));
    seller.logOut();
    assert_(Utils.equals(seller.isLoggedIn(), false));
  }

  public static void main() {

    UserTest test = new UserTest();
    test.createNewUser();
    test.correctNumberOfUsers();
    test.changeUsername();
    test.correctType();
    test.checkLogging();
  }

  public UserTest() {}

  public String toString() {

    return "UserTest{" + "numUsers := " + Utils.toString(numUsers) + "}";
  }
}

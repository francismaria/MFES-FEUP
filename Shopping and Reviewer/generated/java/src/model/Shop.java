package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Shop {
  private String name;
  private VDMSet registeredUsers = SetUtil.set();
  private VDMMap registeredProducts = MapUtil.map();
  private User loggedUser;

  public void cg_init_Shop_1(final String shopName) {

    name = shopName;
  }

  public Shop(final String shopName) {

    cg_init_Shop_1(shopName);
  }

  public User getLoggedUser() {

    return loggedUser;
  }

  public VDMSet getRegisteredUsers() {

    return Utils.copy(registeredUsers);
  }

  public VDMMap getRegisteredProducts() {

    return Utils.copy(registeredProducts);
  }

  public Number getNumberOfProducts() {

    return Product.getNumberOfProducts();
  }

  public Number getNumberOfSellers() {

    return getNumberOfElements(quotes.SELLERQuote.getInstance());
  }

  public Number getNumberOfCostumers() {

    return getNumberOfElements(quotes.COSTUMERQuote.getInstance());
  }

  private Number getNumberOfElements(final Object elemsType) {

    Number num = 0L;
    for (Iterator iterator_3 = registeredUsers.iterator(); iterator_3.hasNext(); ) {
      User user = (User) iterator_3.next();
      if (Utils.equals(user.getType(), elemsType)) {
        num = num.longValue() + 1L;
      }
    }
    return num;
  }

  public void addNewUser(final User newUser) {

    registeredUsers = SetUtil.union(Utils.copy(registeredUsers), SetUtil.set(newUser));
  }

  public void updateProducts() {

    for (Iterator iterator_4 = registeredUsers.iterator(); iterator_4.hasNext(); ) {
      User user = (User) iterator_4.next();
      if (Utils.equals(user.getType(), quotes.SELLERQuote.getInstance())) {
        Seller seller = (Seller)user;
        VDMMap existsUserProducts = MapUtil.map();
        existsUserProducts =
            MapUtil.domResTo(SetUtil.set(user.getUsername()), Utils.copy(registeredProducts));
        if (Utils.empty(existsUserProducts)) {
          registeredProducts =
              MapUtil.munion(
                  Utils.copy(registeredProducts),
                  MapUtil.map(new Maplet(seller.getUsername(), seller.getAllProducts())));

        } else {
          registeredProducts =
              MapUtil.override(
                  Utils.copy(registeredProducts),
                  MapUtil.map(new Maplet(seller.getUsername(), seller.getAllProducts())));
        }
      }
    }
  }

  public Boolean login(final String inputUsername, final String inputPassword) {

    for (Iterator iterator_5 = registeredUsers.iterator(); iterator_5.hasNext(); ) {
      User user = (User) iterator_5.next();
      if (Utils.equals(user.getUsername(), inputUsername)) {
        if (user.checkCredentials(inputPassword)) {
          user.logIn();
          loggedUser = user;
          return true;

        } else {
          return false;
        }
      }
    }
    return false;
  }

  public void logout() {

    loggedUser.logOut();
  }

  public void register(final String newUsername, final String newPassword, final Object type) {

    if (Utils.equals(type, quotes.SELLERQuote.getInstance())) {
      Seller newSeller = new Seller(newUsername, newPassword);
      this.addNewUser(newSeller);
      loggedUser = newSeller;

    } else {
      Costumer newCostumer = new Costumer(newUsername, newPassword);
      this.addNewUser(newCostumer);
      loggedUser = newCostumer;
    }
  }

  public Shop() {}

  public String toString() {

    return "Shop{"
        + "name := "
        + Utils.toString(name)
        + ", registeredUsers := "
        + Utils.toString(registeredUsers)
        + ", registeredProducts := "
        + Utils.toString(registeredProducts)
        + ", loggedUser := "
        + Utils.toString(loggedUser)
        + "}";
  }
}

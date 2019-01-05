package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Seller extends User {
  private VDMMap products = MapUtil.map();
  private Number productsIDs = 1L;

  public void cg_init_Seller_1(final String usernameExt, final String passwordExt) {

    cg_init_User_1(usernameExt, passwordExt);
  }

  public Seller(final String usernameExt, final String passwordExt) {

    cg_init_Seller_1(usernameExt, passwordExt);
  }

  public Product getProduct(final Number id) {

    return ((Product) Utils.get(products, id));
  }

  public VDMSet getAllProducts() {

    return MapUtil.rng(Utils.copy(products));
  }

  public Object getType() {

    return quotes.SELLERQuote.getInstance();
  }

  public void addNewProduct(final Product newProduct) {

    VDMSet existingProducts = MapUtil.rng(Utils.copy(products));
    Boolean productExists = false;
    for (Iterator iterator_2 = existingProducts.iterator(); iterator_2.hasNext(); ) {
      Product p = (Product) iterator_2.next();
      if (newProduct.isEqual(p)) {
        p.incrementQuantity();
        productExists = true;
      }
    }
    if (Utils.equals(productExists, false)) {
      products =
          MapUtil.munion(Utils.copy(products), MapUtil.map(new Maplet(productsIDs, newProduct)));
      productsIDs = productsIDs.longValue() + 1L;
    }
  }

  public void removeProduct(final Number ID) {

    products = MapUtil.domResBy(SetUtil.set(ID), Utils.copy(products));
  }

  public Boolean sellProduct(final Number productID, final Number desiredQuantity) {

    Product product = ((Product) Utils.get(products, productID));
    Boolean andResult_8 = false;

    if (Utils.equals(product.getQuantity(), 1L)) {
      if (Utils.equals(desiredQuantity, 1L)) {
        andResult_8 = true;
      }
    }

    if (andResult_8) {
      products = MapUtil.rngResBy(Utils.copy(products), SetUtil.set(product));
      return true;

    } else if (product.getQuantity().longValue() >= desiredQuantity.longValue()) {
      product.decrementQuantity(desiredQuantity);
      return true;

    } else {
      return true;
    }
  }

  public Seller() {}

  public String toString() {

    return "Seller{"
        + "products := "
        + Utils.toString(products)
        + ", productsIDs := "
        + Utils.toString(productsIDs)
        + "}";
  }
}

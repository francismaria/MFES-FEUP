package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ProductTest extends MyTest {
  private Number numProds = 0L;

  private void createNewProduct() {

    Product prod = null;
    prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(Utils.equals(prod.getID(), numProds));
  }

  private void checkInformation() {

    Product prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(Utils.equals(prod.getID(), numProds));
    assert_(Utils.equals(prod.getName(), "p1"));
    assert_(Utils.equals(prod.getQuantity(), 1L));
    assert_(Utils.equals(prod.getDescription(), "description1"));
    assert_(Utils.equals(prod.getPrice(), 12.99));
  }

  private void checkRating() {

    Product prod = null;
    Review review = null;
    Review review2 = null;
    Costumer costumer = null;
    Costumer costumer2 = null;
    prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    costumer = new Costumer("TestCostumer", "password1");
    costumer2 = new Costumer("TestCostumer2", "password2");
    review = new Review("Good product", 4L, costumer);
    review2 = new Review("Disappointed with this product", 2L, costumer);
    assert_(Utils.equals(prod.getRating(), 0L));
    prod.addReview(review);
    assert_(Utils.equals(prod.getRating(), 4.0));
    prod.addReview(review2);
    assert_(Utils.equals(prod.getRating(), 3.0));
  }

  private void changePrice() {

    Product prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(Utils.equals(prod.getPrice(), 12.99));
    prod.changePrice(11.99);
    assert_(Utils.equals(prod.getPrice(), 11.99));
  }

  private void changeQuantity() {

    Product prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(Utils.equals(prod.getQuantity(), 1L));
    prod.incrementQuantity();
    assert_(Utils.equals(prod.getQuantity(), 2L));
    prod.decrementQuantity(1L);
    assert_(Utils.equals(prod.getQuantity(), 1L));
  }

  private void numberOfProducts() {

    assert_(Utils.equals(numProds, Product.getNumberOfProducts()));
  }

  private void areEqual() {

    Product prod = null;
    Product prod2 = null;
    prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    prod2 = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(prod.isEqual(prod2));
  }

  private void getReviews() {

    Product prod = null;
    prod = new Product("p1", "description1", 12.99);
    numProds = numProds.longValue() + 1L;
    assert_(Utils.empty(prod.getReviews()));
  }

  public static void main() {

    ProductTest test = new ProductTest();
    test.createNewProduct();
    test.checkInformation();
    test.checkRating();
    test.changePrice();
    test.changeQuantity();
    test.areEqual();
    test.numberOfProducts();
    test.getReviews();
  }

  public ProductTest() {}

  public String toString() {

    return "ProductTest{" + "numProds := " + Utils.toString(numProds) + "}";
  }
}

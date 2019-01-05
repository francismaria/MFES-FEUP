package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Product {
  private Number ID;
  private String name;
  private String description;
  private Number price;
  private Number quantity;
  private Number rating = 0L;
  private VDMSet reviews = SetUtil.set();
  private static Number numberOfProducts = 0L;

  public void cg_init_Product_1(
      final String newName, final String newDescription, final Number newPrice) {

    name = newName;
    description = newDescription;
    price = newPrice;
    quantity = 1L;
    numberOfProducts = Product.numberOfProducts.longValue() + 1L;
    ID = Product.numberOfProducts;
  }

  public Product(final String newName, final String newDescription, final Number newPrice) {

    cg_init_Product_1(newName, newDescription, newPrice);
  }

  public Number getID() {

    return ID;
  }

  public String getName() {

    return name;
  }

  public String getDescription() {

    return description;
  }

  public Number getPrice() {

    return price;
  }

  public Number getQuantity() {

    return quantity;
  }

  public Number getRating() {

    return rating;
  }

  public VDMSet getReviews() {

    return Utils.copy(reviews);
  }

  public static Number getNumberOfProducts() {

    return Product.numberOfProducts;
  }

  public void addReview(final Review userReview) {

    reviews = SetUtil.union(Utils.copy(reviews), SetUtil.set(userReview));
    updateRating();
  }

  public void changePrice(final Number newPrice) {

    price = newPrice;
  }

  public void incrementQuantity() {

    quantity = quantity.longValue() + 1L;
  }

  public void decrementQuantity(final Number subtract) {

    quantity = quantity.longValue() - subtract.longValue();
  }

  private void updateRating() {

    Number allRatingsSum = 0L;
    Number numRatings = 0L;
    for (Iterator iterator_1 = reviews.iterator(); iterator_1.hasNext(); ) {
      Review r = (Review) iterator_1.next();
      allRatingsSum = allRatingsSum.longValue() + r.getClassification().longValue();
      numRatings = numRatings.longValue() + 1L;
    }
    rating = calculateRating(numRatings, allRatingsSum);
  }

  public Boolean isEqual(final Product newProduct) {

    Boolean andResult_4 = false;

    if (Utils.equals(name, newProduct.getName())) {
      Boolean andResult_5 = false;

      if (Utils.equals(description, newProduct.getDescription())) {
        if (Utils.equals(price, newProduct.getPrice())) {
          andResult_5 = true;
        }
      }

      if (andResult_5) {
        andResult_4 = true;
      }
    }

    return andResult_4;
  }

  public Product() {}

  private static Number calculateRating(final Number numReviews, final Number reviewsRatings) {

    if (Utils.equals(numReviews, 0L)) {
      return 0L;

    } else {
      return Utils.divide((1.0 * reviewsRatings.longValue()), numReviews.longValue());
    }
  }

  public String toString() {

    return "Product{"
        + "ID := "
        + Utils.toString(ID)
        + ", name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + ", price := "
        + Utils.toString(price)
        + ", quantity := "
        + Utils.toString(quantity)
        + ", rating := "
        + Utils.toString(rating)
        + ", reviews := "
        + Utils.toString(reviews)
        + ", numberOfProducts := "
        + Utils.toString(numberOfProducts)
        + "}";
  }
}

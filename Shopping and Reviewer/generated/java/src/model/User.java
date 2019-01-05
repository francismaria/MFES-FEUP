package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
abstract public class User {
  private Number ID = 1L;
  private String username;
  private String password;
  private Boolean loggedIn;
  private Number rating = 0L;
  private VDMSet reviews = SetUtil.set();
  private static Number numberOfUsers = 0L;

  public void cg_init_User_1(final String usernameExt, final String passwordExt) {

    username = usernameExt;
    password = passwordExt;
    numberOfUsers = User.numberOfUsers.longValue() + 1L;
    ID = User.numberOfUsers;
    loggedIn = false;
  }

  public User(final String usernameExt, final String passwordExt) {

    cg_init_User_1(usernameExt, passwordExt);
  }

  public Number getUserID() {

    return ID;
  }

  public String getUsername() {

    return username;
  }

  public Number getRating() {

    return rating;
  }

  public VDMSet getReviews() {

    return Utils.copy(reviews);
  }

  public Boolean isLoggedIn() {

    return loggedIn;
  }

  public abstract Object getType();

  public static Number getNumberOfUsers() {

    return User.numberOfUsers;
  }

  public void setNewUsername(final String newUsername) {

    username = newUsername;
  }

  public void setNewPassword(final String newPassword) {

    password = newPassword;
  }

  public void addReview(final Review userReview) {

    reviews = SetUtil.union(Utils.copy(reviews), SetUtil.set(userReview));
    updateRating();
  }

  public Boolean checkCredentials(final String inputPassword) {

    if (Utils.equals(password, inputPassword)) {
      loggedIn = true;
      return true;
    }

    return false;
  }

  public void logIn() {

    loggedIn = true;
  }

  public void logOut() {

    loggedIn = false;
  }

  private void updateRating() {

    Number allRatingsSum = 0L;
    Number numRatings = 0L;
    for (Iterator iterator_6 = reviews.iterator(); iterator_6.hasNext(); ) {
      Review r = (Review) iterator_6.next();
      allRatingsSum = allRatingsSum.longValue() + r.getClassification().longValue();
      numRatings = numRatings.longValue() + 1L;
    }
    rating = calculateRating(numRatings, allRatingsSum);
  }

  public User() {}

  private static Number calculateRating(final Number numReviews, final Number reviewsRatings) {

    if (Utils.equals(numReviews, 0L)) {
      return 0L;

    } else {
      return Utils.divide((1.0 * reviewsRatings.longValue()), numReviews.longValue());
    }
  }

  public String toString() {

    return "User{"
        + "ID := "
        + Utils.toString(ID)
        + ", username := "
        + Utils.toString(username)
        + ", password := "
        + Utils.toString(password)
        + ", loggedIn := "
        + Utils.toString(loggedIn)
        + ", rating := "
        + Utils.toString(rating)
        + ", reviews := "
        + Utils.toString(reviews)
        + ", numberOfUsers := "
        + Utils.toString(numberOfUsers)
        + "}";
  }
}

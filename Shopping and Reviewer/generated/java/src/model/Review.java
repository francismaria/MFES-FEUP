package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Review {
  private String text;
  private Number classification;
  private User author;

  public void cg_init_Review_1(
      final String reviewText, final Number reviewClassification, final User reviewUser) {

    text = reviewText;
    classification = reviewClassification;
    author = reviewUser;
  }

  public Review(final String reviewText, final Number reviewClassification, final User reviewUser) {

    cg_init_Review_1(reviewText, reviewClassification, reviewUser);
  }

  public String getText() {

    return text;
  }

  public Number getClassification() {

    return classification;
  }

  public User getAuthor() {

    return author;
  }

  public Review() {}

  public String toString() {

    return "Review{"
        + "text := "
        + Utils.toString(text)
        + ", classification := "
        + Utils.toString(classification)
        + ", author := "
        + Utils.toString(author)
        + "}";
  }
}

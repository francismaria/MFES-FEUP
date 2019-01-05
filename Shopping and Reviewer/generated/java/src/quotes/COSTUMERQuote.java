package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class COSTUMERQuote {
  private static int hc = 0;
  private static COSTUMERQuote instance = null;

  public COSTUMERQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static COSTUMERQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new COSTUMERQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof COSTUMERQuote;
  }

  public String toString() {

    return "<COSTUMER>";
  }
}

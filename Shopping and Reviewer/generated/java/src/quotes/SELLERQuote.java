package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SELLERQuote {
  private static int hc = 0;
  private static SELLERQuote instance = null;

  public SELLERQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SELLERQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SELLERQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SELLERQuote;
  }

  public String toString() {

    return "<SELLER>";
  }
}

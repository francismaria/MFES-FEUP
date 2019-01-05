package model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Costumer extends User {
  public void cg_init_Costumer_1(final String usernameExt, final String passwordExt) {

    cg_init_User_1(usernameExt, passwordExt);
  }

  public Costumer(final String usernameExt, final String passwordExt) {

    cg_init_Costumer_1(usernameExt, passwordExt);
  }

  public Object getType() {

    return quotes.COSTUMERQuote.getInstance();
  }

  public Costumer() {}

  public String toString() {

    return "Costumer{}";
  }
}

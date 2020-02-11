package modele;

import java.sql.SQLException;

public class TestBaseDeDonnee {

  public static void main(String[] args) {
    try {
      BaseDeDonnee uneBdd = new BaseDeDonnee();
      
      uneBdd.get_Users();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
  }

}

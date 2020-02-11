package modele;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controller.*;

public class BaseDeDonnee {

  Connection laBaseDeDonnee;

  /**
   * . Constructeur du modele pour la base de donn�e
   * 
   * @throws SQLException Erreur en cas de base de donn�e non fonctionnel
   * @throws ClassNotFoundException Erreur en cas de librairie non trouv�e
   */
  public BaseDeDonnee() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver O.K.");

    String url = "jdbc:mysql://obiwan2.univ-brest.fr/zil3-zyonnetma";
    String user = "zyonnetma";
    String passwd = "7imqy975";

    laBaseDeDonnee = DriverManager.getConnection(url, user, passwd);
  }


  /**
   * . Fonction permettant de r�cup�r� tout les utilisateurs de la base de donn�e
   * 
   * @return Renvoie la liste des utilisateurs trouv�s
   * @throws SQLException Erreur si la base de donn�e n'a pas �t� trouv�
   */
  public ArrayList<Particulier> get_Users() throws SQLException {
    ArrayList<Particulier> result = new ArrayList<Particulier>();

    Statement statement = laBaseDeDonnee.createStatement();
    ResultSet resultat = statement.executeQuery("SELECT *  FROM Utilisateur "
        + "INNER JOIN ADMIN ON Admin.UTILISATEUR_pseudoUtilisateur = Utilisateur.pseudoUtilisateur "
        + "INNER JOIN ANALYSTE ON Analyste.UTILISATEUR_pseudoUtilisateur "
        + "= Utilisateur.pseudoUtilisateur ;");
    while (resultat.next()) {
      String pseudoUtilisateur = resultat.getString("pseudoUtilisateur");
      String emailUtilisateur = resultat.getString("mailUtilisateur");
      String nomUtilisateur = resultat.getString("nomUtilisateur");
      String prenomUtilisateur = resultat.getString("prenomUtilisateur");
      String adresseUtilisateur = resultat.getString("adresseUtilisateur");
      String mdpUtilisateur = resultat.getString("mdpUtilisateur");
      result.add(new controller.Particulier(pseudoUtilisateur, mdpUtilisateur, prenomUtilisateur,
          nomUtilisateur, adresseUtilisateur, emailUtilisateur));
    }
    return result;
  }

  public ArrayList<Equipement> get_Equipement() throws SQLException {
    ArrayList<Equipement> result = new ArrayList<Equipement>();

    Statement statement = laBaseDeDonnee.createStatement();
    ResultSet resultat = statement.executeQuery(
        "SELECT *  FROM Equipement INNER JOIN CATEGORIE ON Equipement.Categorie_idCategorie = CATEGORIE.idCategorie INNER JOIN TAUX ON Equipement.taux_idTaux = TAUX.idTaux INNERJOIN EQUIPEMENT.VALEUR_idTaux = idTaux;");

    while (resultat.next()) {
      int idEquipement = resultat.getInt("idEquipement");
      String nomEquipement = resultat.getString("nomEquipement");
      String typeEquipement = resultat.getString("typeEquipement");
      float tauxEquipement = resultat.getFloat("valeurTaux");
      String categorieEquipement = resultat.getString("nomEquipement");
      float valeurDecimal = resultat.getFloat("valeurAutre");

      if (categorieEquipement == "Avion") {
        result.add(new Avion(nomEquipement, valeurDecimal == 1, (int) tauxEquipement));
      } else if (categorieEquipement == "Voiture") {

      } else if (categorieEquipement == "Train") {

      } else if (categorieEquipement == "Chauffage") {

      }
    }

    return result;
  }

  /**
   * Fonction permettant de se connecter
   * 
   * @param unMotDePasse
   * @param unMail
   * @return
   * @throws SQLException
   * @throws NoSuchAlgorithmException
   */
  public boolean se_connecter(String unMotDePasse, String unMail)
      throws SQLException, NoSuchAlgorithmException {
    Statement statement = laBaseDeDonnee.createStatement();
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(unMotDePasse.getBytes(StandardCharsets.UTF_8));
    ResultSet resultat =
        statement.executeQuery("SSELECT * FROM UTILISATEUR WHERE mailUtilisateur=\"" + unMail
            + " \" AND mdpUtilisateur = " + hash.toString());
    while (resultat.next()) {
      return true;
    }

    return false;

  }

}

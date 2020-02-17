package modele;

import controller.Avion;
import controller.Chauffage;
import controller.Equipement;
import controller.Particulier;
import controller.Train;
import controller.Voiture;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDeDonnee {

  Connection laBaseDeDonnee;

  /**
   * . Constructeur du modele pour la base de donnée
   * 
   * @throws SQLException Erreur en cas de base de donnée non fonctionnel
   * @throws ClassNotFoundException Erreur en cas de librairie non trouvée
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
   * Fonction permettant de récupéré tout les utilisateurs de la base de donnée.
   * 
   * 
   * @return Renvoie la liste des utilisateurs trouvés
   * @throws SQLException Erreur si la base de donnée n'a pas été trouvé
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

  /**
   * Fonction permettant de recuperer tout les équipements de la base de donnée.
   * 
   * @return
   */
  public ArrayList<Equipement> get_Equipement() throws SQLException {
    ArrayList<Equipement> result = new ArrayList<Equipement>();

    Statement statement = laBaseDeDonnee.createStatement();
    ResultSet resultat =
        statement.executeQuery("SELECT * FROM PROFIL INNER JOIN EQUIPEMENT ON EQUIPEMENT.equId = "
            + "PROFIL.equ_equId INNER JOIN TAUX ON EQUIPEMENT.tau_tauId = TAUX.tauId");

    while (resultat.next()) {
      String nomEquipement = resultat.getString("PROFIL.equNom");
      String typeEquipement = resultat.getString("EQUIPEMENT.equNom");
      String typeTaux = resultat.getString("tauNom");
      float autreVal = resultat.getFloat("proVal");



      if (typeEquipement == "Avion Eco") {
        result.add(new Avion(nomEquipement, true));
      } else if (typeEquipement == "Avion pas éco") {
        result.add(new Avion(nomEquipement, false));
      } else if (typeEquipement == "Voiture") {
        result.add(new Voiture(nomEquipement, Voiture.TypeCarburant.valueOf(typeTaux), autreVal));
      } else if (typeEquipement == "Train") {
        result.add(new Train(nomEquipement, Train.TypeTrain.valueOf(typeTaux)));
      } else if (typeEquipement == "Chauffage") {
        // result.add(new Chauffage(nomEquipement, Chauffage.TypeChauffage.valueOf(typeTaux),))
      }
    }

    return result;
  }

  /**
   * Fonction permettant de se connecter.
   *
   * 
   * @param unMotDePasse le mot de passe entré par l'utilisateur
   * @param unMail le mail entré par l'utilisateur
   * @return
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

package controller;

import java.text.Normalizer;
import java.util.regex.Pattern;

public abstract class Equipement {
  private String nom;

  /**
   * Constructeur de l'�quipement.
   * 
   * @param n le nom de l'�quipement
   */
  Equipement(String n) {

    if (!estValide(n) || n.length() <= 0) {
      throw new IllegalArgumentException();
    } else {
      nom = n;
    }
  }

  /**
   * Renvoie le taux calcul� en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'�mission CO2 de la voiture
   */
  abstract float calculerTaux();

  /**
   * Renvoie le nom de l'�quipement.
   * 
   * @return le nom de l'�quipement
   */
  public String getNom() {
    return nom;
  }

  /**
   * Modifie le nom de l'�quipement.
   * 
   * @param nom nouveau nom de l'�quipement
   */
  public void setNom(String nom) {
    if (estValide(nom)) {
      this.nom = nom;
    }
  }

  public boolean estValide(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    String s2 = s.replaceAll("[^a-zA-Z0-9]", "");
    return s.equals(s2);
  }

}

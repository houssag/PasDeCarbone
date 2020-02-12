package controller;

import java.text.Normalizer;

public abstract class Equipement {
  private String nom;

  /**
   * Constructeur de l'équipement.
   * 
   * @param n le nom de l'équipement
   */
  @SuppressWarnings("null")
  Equipement(String n) {
    if (n == null || !estValide(n) || n.length() <= 0) {
      throw new IllegalArgumentException("Le nom est trop cours ou vide");
    } else {
      nom = n;
    }
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'émission CO2 de la voiture
   */
  abstract float calculerTaux();

  /**
   * Renvoie le nom de l'équipement.
   * 
   * @return le nom de l'équipement
   */
  public String getNom() {
    return nom;
  }

  /**
   * Modifie le nom de l'équipement.
   * 
   * @param nom nouveau nom de l'équipement
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

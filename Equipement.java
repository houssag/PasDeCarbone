
abstract class Equipement {
  private String nom;
  
  /**
   * Constructeur de l'équipement.
   * @param n le nom de l'équipement
   */
  Equipement(String n) {
    nom = n;
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * @return Le taux d'émission CO2 de la voiture
   */
  abstract float calculerTaux();
  
  /**
   * Renvoie le nom de l'équipement.
   * @return le nom de l'équipement
   */
  public String getNom() {
    return nom;
  }

  /**
   * Modifie le nom de l'équipement.
   * @param nom nouveau nom de l'équipement
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

}

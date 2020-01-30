
abstract class Equipement {
  private String nom;
  
  /**
   * Constructeur de l'�quipement.
   * @param n le nom de l'�quipement
   */
  Equipement(String n) {
    nom = n;
  }

  /**
   * Renvoie le taux calcul� en fonction du carburant et de la consommation en litres pas km.
   * @return Le taux d'�mission CO2 de la voiture
   */
  abstract float calculerTaux();
  
  /**
   * Renvoie le nom de l'�quipement.
   * @return le nom de l'�quipement
   */
  public String getNom() {
    return nom;
  }

  /**
   * Modifie le nom de l'�quipement.
   * @param nom nouveau nom de l'�quipement
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

}

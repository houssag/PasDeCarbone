
abstract class Equipement {
  private String nom;
  
  Equipement(String n) {
    nom = n;
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * @return Le taux d'émission CO2 de la voiture
   */
  abstract float calculerTaux();

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

}

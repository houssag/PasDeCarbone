package controller;


public class Avion extends Equipement {
  static float EMISSIONPARKM = 172;
  private boolean economique;
  private int distance;

  /**
   * Constructeur de l'objet avion.
   * 
   * @param n le nom de l'avion
   * @param eco booléen vrai si le voyage a été effectué en classe économique, faux sinon
   * @param d distance effectué lors du voyage
   */
  public Avion(String n, boolean eco, int d) {
    super(n);
    economique = eco;
    if (d >= 0) {
      distance = d;
    } else {
      distance = 0;
    }
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'émission CO2 de l'avion
   */
  public float calculerTaux() {
    float total;
    total = distance * EMISSIONPARKM;
    if (!economique) {
      total = 2 * total;
    }
    return total;
  }

  /**
   * Renvoie l'émission moyenne de CO2 en g d'un avion en 1 km parcouru.
   * 
   * @return l'émission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public static float getEmissionParKm() {
    return EMISSIONPARKM;
  }

  /**
   * Modifie l'émission moyenne de CO2 en g d'un avion en 1 km parcouru.
   * 
   * @param epk la nouvelle émission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public void setEmissionParKm(float epk) {
    if (epk >= 0) {
      EMISSIONPARKM = epk;
    }
  }

  /**
   * Renvoie vrai si l'avion a été pris en classe économique, sinon faux.
   * 
   * @return true si le voyage a été effectué en classe économique, false sinon
   */
  public boolean isEconomique() {
    return economique;
  }

  /**
   * Modifie la valeur du booléen economique.
   * 
   * @param eco nouvelle valeur du booléen économique
   */
  public void setEconomique(boolean eco) {
    this.economique = eco;
  }

  /**
   * Renvoie la distance parcourue par l'avion en km.
   * 
   * @return la distance parcourue par l'avion en km
   */
  public int getDistance() {
    return distance;
  }

  /**
   * Modifie la distance parcourue par l'avion en km.
   * 
   * @param distance la nouvelle distance parcourue par l'avion en km
   */
  public void setDistance(int distance) {
    this.distance = distance;
  }

}

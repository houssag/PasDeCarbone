package controller;


public class Avion extends Equipement {
  static float EMISSIONPARKM = 172;
  private boolean economique;
  private int distance;

  /**
   * Constructeur de l'objet avion.
   * 
   * @param n le nom de l'avion
   * @param eco bool�en vrai si le voyage a �t� effectu� en classe �conomique, faux sinon
   * @param d distance effectu� lors du voyage
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
   * Renvoie le taux calcul� en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'�mission CO2 de l'avion
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
   * Renvoie l'�mission moyenne de CO2 en g d'un avion en 1 km parcouru.
   * 
   * @return l'�mission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public static float getEmissionParKm() {
    return EMISSIONPARKM;
  }

  /**
   * Modifie l'�mission moyenne de CO2 en g d'un avion en 1 km parcouru.
   * 
   * @param epk la nouvelle �mission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public void setEmissionParKm(float epk) {
    if (epk >= 0) {
      EMISSIONPARKM = epk;
    }
  }

  /**
   * Renvoie vrai si l'avion a �t� pris en classe �conomique, sinon faux.
   * 
   * @return true si le voyage a �t� effectu� en classe �conomique, false sinon
   */
  public boolean isEconomique() {
    return economique;
  }

  /**
   * Modifie la valeur du bool�en economique.
   * 
   * @param eco nouvelle valeur du bool�en �conomique
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

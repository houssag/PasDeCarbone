package controller;


public class Avion extends Equipement {
  static float EMISSIONPARKM = 172;
  private boolean economique;
  
  /**
   * Constructeur de l'objet avion.
   * 
   * @param n le nom de l'avion
   * @param eco booléen vrai si le voyage a été effectué en classe économique, faux sinon
   */
  public Avion(String n, boolean eco) {
    super(n);
    economique = eco;
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'émission CO2 de l'avion
   */
  public float calculerTaux() {
    float total = this.EMISSIONPARKM;
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

}

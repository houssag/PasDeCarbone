
public class Avion extends Equipement {
  static float EMISSIONPARKM = 172;
  private boolean economique;
  private int distance;

  Avion(String n, boolean eco, int d) {
    super(n);
    economique = eco;
    distance = d;
  }

  /**
   * Renvoie le taux calcul� en fonction du carburant et de la consommation en litres pas km.
   * @return Le taux d'�mission CO2 de la voiture
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
   * @return l'�mission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public static float getEmissionParKm() {
    return EMISSIONPARKM;
  }

  /**
   * Modifie l'�mission moyenne de CO2 en g d'un avion en 1 km parcouru.
   * @param epk la nouvelle �mission moyenne de CO2 en g d'un avion en 1 km parcouru
   */
  public static void setEmissionParKm(float epk) {
    EMISSIONPARKM = epk;
  }
  
  /**
   * Renvoie vrai si l'avion a �t� pris en classe �conomique, sinon faux.
   * @return un bool�en repr�sentant
   */
  public boolean isEconomique() {
    return economique;
  }

  public void setEconomique(boolean economique) {
    this.economique = economique;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

}

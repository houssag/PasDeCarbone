
public class Avion extends Equipement {
  static float EMISSIONPARKM = 172;
  private boolean economique;
  private int distance;
  
  /**
   * Constructeur de l'objet avion.
   * @param n le nom de l'avion
   * @param eco bool�en vrai si le voyage a �t� effectu� en classe �conomique, faux sinon
   * @param d distance effectu� lors du voyage
   */
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

  /**
   * Modifie la valeur du bool�en economique.
   * @param eco nouvelle valeur du bool�en �conomique
   */
  public void setEconomique(boolean eco) {
    this.economique = eco;
  }
  
  /**
   * Renvoie la distance parcourue par l'avion en km.
   * @return la distance parcourue par l'avion en km
   */
  public int getDistance() {
    return distance;
  }

  /**
   * Modifie la distance parcourue par l'avion en km.
   * @param distance la nouvelle distance parcourue par l'avion en km
   */
  public void setDistance(int distance) {
    this.distance = distance;
  }

}

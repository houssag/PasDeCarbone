package controller;


public class Voiture extends Equipement {
  static int[] consoVoiture = {2640, 2392, 1665, 1819};

  public enum TypeCarburant {
    Diesel, Essence, LPG, CNG
  }
  // les différents types de carburant arrangés en fonction
  // de leurs émissions en CO2 respectifs dans le tableau ConsoVoiture.

  private TypeCarburant carburant; // le type de carburant de la voiture
  private float litresParKm; // les litres (ou Nm3 dans le cas du CNG) émis en un km parcouru

  /**
   * Constructeur de l'objet voiture.
   * 
   * @param n le nom de la voiture
   * @param c le type de carburant utilisé
   * @param lpk la consommation en litres par kilomètre
   */
  Voiture(String n, TypeCarburant c, float lpk) {
    super(n);
    carburant = c;

    if (lpk >= 0) {
      litresParKm = lpk;
    } else {
      throw new IllegalArgumentException("le litre par kilomètre ne peut pas être négatif");
    }
  }

  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'émission CO2 de la voiture
   */
  public float calculerTaux() {
    float total;
    float coef;
    coef = consoVoiture[carburant.ordinal()];
    total = (coef * litresParKm);
    return total;
  }

  /**
   * Renvoie la valeur en g de CO2 émis par un litre de type de carburant donné.
   * 
   * @return La valeur en g de CO2 émis par un litre du type de carburant donné
   */
  public int getEmissionCarburant() {
    return consoVoiture[this.carburant.ordinal()];
  }

  /**
   * Modifie la valeur en g de CO2 émis par un type de carburant donné.
   * 
   * @param t Le type de carburant dont il faut modifier l'émission de CO2
   * @param i La nouvelle valeur en g de CO2 émis par un litre ou Nm3 du type de carburant
   */
  public static void setEmissionCarburant(TypeCarburant t, int i) {
    consoVoiture[t.ordinal()] = i;
  }

  public TypeCarburant getCarburant() {
    return carburant;
  }

  /**
   * Modifie le type de carburant utilisé.
   * 
   * @param c Type de carburant utilisé désormais.
   */
  public void setCarburant(TypeCarburant c) {
    carburant = c;
  }

  /**
   * Renvoie la consommation en litres (ou Nm3 pour le CNG) de carburant en un km.
   * 
   * @return la consommation en litres (ou Nm3 pour le CNG) de carburant en un km
   */
  public float getLitresParKm() {
    return litresParKm;
  }

  /**
   * Modifie la consommation en litres (ou Nm3 pour le CNG) de carburant en un km.
   * 
   * @param lpk la nouvelle consommation en litres (ou Nm3 pour le CNG) de carburant en un km
   */
  public void setLitresParKm(float lpk) {
    if (lpk >= 0) {
      litresParKm = lpk;
    }
  }

}

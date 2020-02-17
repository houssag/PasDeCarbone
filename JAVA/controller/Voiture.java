package controller;


public class Voiture extends Equipement {
  static int[] consoVoiture = {2640, 2392, 1665, 1819};

  public enum TypeCarburant {
    Diesel, Essence, LPG, CNG
  }
  // les diff�rents types de carburant arrang�s en fonction
  // de leurs �missions en CO2 respectifs dans le tableau ConsoVoiture.

  private TypeCarburant carburant; // le type de carburant de la voiture
  private float litresParKm; // les litres (ou Nm3 dans le cas du CNG) �mis en un km parcouru

  /**
   * Constructeur de l'objet voiture.
   * 
   * @param n le nom de la voiture
   * @param c le type de carburant utilis�
   * @param lpk la consommation en litres par kilom�tre
   */
  Voiture(String n, TypeCarburant c, float lpk) {
    super(n);
    carburant = c;

    if (lpk >= 0) {
      litresParKm = lpk;
    } else {
      throw new IllegalArgumentException("le litre par kilom�tre ne peut pas �tre n�gatif");
    }
  }

  /**
   * Renvoie le taux calcul� en fonction du carburant et de la consommation en litres pas km.
   * 
   * @return Le taux d'�mission CO2 de la voiture
   */
  public float calculerTaux() {
    float total;
    float coef;
    coef = consoVoiture[carburant.ordinal()];
    total = (coef * litresParKm);
    return total;
  }

  /**
   * Renvoie la valeur en g de CO2 �mis par un litre de type de carburant donn�.
   * 
   * @return La valeur en g de CO2 �mis par un litre du type de carburant donn�
   */
  public int getEmissionCarburant() {
    return consoVoiture[this.carburant.ordinal()];
  }

  /**
   * Modifie la valeur en g de CO2 �mis par un type de carburant donn�.
   * 
   * @param t Le type de carburant dont il faut modifier l'�mission de CO2
   * @param i La nouvelle valeur en g de CO2 �mis par un litre ou Nm3 du type de carburant
   */
  public static void setEmissionCarburant(TypeCarburant t, int i) {
    consoVoiture[t.ordinal()] = i;
  }

  public TypeCarburant getCarburant() {
    return carburant;
  }

  /**
   * Modifie le type de carburant utilis�.
   * 
   * @param c Type de carburant utilis� d�sormais.
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

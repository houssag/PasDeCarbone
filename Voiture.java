public class Voiture extends Equipement {
  static int DIESEL = 2640;// Variable d'émission CO2 pour un litre de diesel consommé
  static int ESSENCE = 2392;// Variable d'émission CO2 pour un litre d'essence consommé
  static int LPG = 1665;// Variable d'émission CO2 pour un litre de LPG consommé
  static int CNG = 1819;// Variable d'émission CO2 pour un Nm3 de CNG consommé

  // private String modele;//le modèle de la voiture
  public enum TypeCarburant { // les différents types de carburant
    Diesel, Essence, LPG, CNG
  }

  private TypeCarburant carburant;
  private float litresParKm; // les litres (ou Nm3 dans le cas du CNG) émis en un km parcouru

  Voiture(String n, TypeCarburant c, float lpk, int np) {
    super(n);
    // modele=m;
    carburant = c;
    litresParKm = lpk;
  }
  
  /**
   * Renvoie le taux calculé en fonction du carburant et de la consommation en litres pas km.
   * @return Le taux d'émission CO2 de la voiture
   */
  public float calculerTaux() {
    float total;
    float coef;
    coef = -1;
    if (carburant == TypeCarburant.Diesel) {
      coef = DIESEL;
    } else if (carburant == TypeCarburant.Essence) {
      coef = ESSENCE;
    } else if (carburant == TypeCarburant.LPG) {
      coef = LPG;
    } else if (carburant == TypeCarburant.CNG) {
      coef = CNG;
    }
    total = (coef * litresParKm);
    return total;
  }

  /**
   * Renvoie la valeur en g de CO2 émis par un litre de Diesel.
   * @return La valeur en g de CO2 émis par un litre de Diesel
   */
  public static int getDiesel() {
    return DIESEL;
  }

  /**
   * Modifie la valeur en g de CO2 émis par un litre de diesel.
   * @param diesel La valeur en g de CO2 émis par un litre de diesel
   */
  public static void setDiesel(int diesel) {
    DIESEL = diesel;
  }

  /**
   * Renvoie la valeur en g de CO2 émis par un litre d'essence.
   * @return La valeur en g de CO2 émis par un litre d'essence
   */
  public static int getEssence() {
    return ESSENCE;
  }

  /**
   * Modifie la valeur en g de CO2 émis par un litre d'essence.
   * @param essence La valeur en g de CO2 émis par un litre d'essence
   */
  public static void setEssence(int essence) {
    ESSENCE = essence;
  }

  /**
   * Renvoie la valeur en g de CO2 émis par un litre de LPG.
   * @return La valeur en g de CO2 émis par un litre de LPG
   */
  public static int getLpg() {
    return LPG;
  }

  /**
   * Modifie la valeur en g de CO2 émis par un litre de LPG.
   * @param lpg La valeur en g de CO2 émis par un litre de LPG
   */
  public static void setLpg(int lpg) {
    LPG = lpg;
  }

  /**
   * Renvoie la valeur en g de CO2 émis par un litre de CNG.
   * @return La valeur en g de CO2 émis par un litre de CNG
   */
  public static int getCng() {
    return CNG;
  }

  /**
   * Modifie la valeur en g de CO2 émis par un Nm3 de CNG.
   * @param cng La valeur en g de CO2 émis par un Nm3 de CNG
   */
  public static void setCng(int cng) {
    CNG = cng;
  }

  /**
   * Renvoie le type de carburant utilisé.
   * @return le type de carburant utilisé
   */
  public TypeCarburant getCarburant() {
    return carburant;
  }

  /**
   * Modifie le type de carburant utilisé.
   * @param c Type de carburant utilisé désormais.
   */
  public void setCarburant(TypeCarburant c) {
    carburant = c;
  }
  
  /**
   * Renvoie la consommation en litres (ou Nm3 pour le CNG) de carburant en un km.
   * @return la consommation en litres (ou Nm3 pour le CNG) de carburant en un km
   */
  public float getLitresParKm() {
    return litresParKm;
  }
  
  /**
   * Modifie la consommation en litres (ou Nm3 pour le CNG) de carburant en un km.
   * @param lpk la nouvelle consommation en litres (ou Nm3 pour le CNG) de carburant en un km
   */
  public void setLitresParKm(float lpk) {
    litresParKm = lpk;
  }

}

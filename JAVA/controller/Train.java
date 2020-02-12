package controller;


public class Train extends Equipement {

  static float[] consoTrain = {1.9f, 1.9f, 1.9f, 5.7f, 10.1f, 13.7f, 5.2f, 8.1f, 4.5f, 4.5f, 26.5f};
  // Tableau des consommations des trains


  public enum TypeTrain {
    TGV_Inoui, TGV_Lyria, OUIGO, Intercites, Eurostar, Thalys, Gala, Alleo, Transilien, RER, TER
  }
  // Diff�rents types de trains, ordonn�es de fa�on � correspondre
  // � leurs consommations respectives dans le tableau des consommations.

  private TypeTrain type;
  // Le type du train

  /**
   * Constructeur de l'objet Train.
   * 
   * @param n Nom du train
   * @param tt Type du train
   */

  Train(String n, TypeTrain tt) {
    super(n);
    if (tt != null) {
      type = tt;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Cette fonction sert � obtenir le taux d'�mission CO2 d'un train.
   * 
   * @return La consommation moyenne par kilom�tre d'un train
   */
  public float calculerTaux() {
    return consoTrain[type.ordinal()];
  }


  /**
   * Cette fonction sert � obtenir la consommation moyenne par kilom�tre d'un type de train donn�.
   * 
   * @param t le type de train dont on doit conna�tre la consommation
   * @return La consommation moyenne par kilom�tre d'un train en fonction de son type
   */
  public static float getConsoTrain(TypeTrain t) {
    return consoTrain[t.ordinal()];
  }

  /**
   * Cette fonction sert � modifier les variables de taux d'�mission de CO2 d'un type de train.
   * 
   * @param t le type de train dont on doit modifier la consommation moyenne de CO2 par km
   * @param consoTrain la nouvelle consommation moyenne de CO2 par km d'un train
   */
  public static void setConsoTrain(TypeTrain t, float consoTrain) {
    Train.consoTrain[t.ordinal()] = consoTrain;
  }

  /**
   * Renvoie le type du train.
   * 
   * @return le type du train
   */
  public TypeTrain getType() {
    return type;
  }

  /**
   * Modifie le type du train.
   * 
   * @param type le nouveau type du train
   */
  public void setType(TypeTrain type) {
    this.type = type;
  }
}

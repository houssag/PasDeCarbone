
public class Train extends Equipement {

  static float[] consoTrain = {1.9f,
                               1.9f,
                               1.9f,
                               5.7f,
                               10.1f,
                               13.7f,
                               5.2f,
                               8.1f,
                               4.5f,
                               4.5f,
                               26.5f};
  // Tableau des consommations des trains


  public enum TypeTrain {
    TGV_Inoui, TGV_Lyria, OUIGO, Intercites, Eurostar, Thalys, Gala, Alleo, Transilien, RER, TER
  }

  private TypeTrain type;

  Train(String n, TypeTrain tt) {
    super(n);
    type = tt;
  }

  public float calculerTaux() {
    return consoTrain[type.ordinal()];
  }

  public static float[] getConsoTrain() {
    return consoTrain;
  }

  public static void setConsoTrain(float[] consoTrain) {
    Train.consoTrain = consoTrain;
  }

  public TypeTrain getType() {
    return type;
  }

  public void setType(TypeTrain type) {
    this.type = type;
  }
}

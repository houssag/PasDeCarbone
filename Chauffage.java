
public class Chauffage extends Equipement {
  public enum TypeChauffage {
    FioulDomestique, FioulLourd, GazNaturel, GazPropaneOuButane, Charbon, Bois, Electricité
  }

  TypeChauffage type;
  static int[] consoChauffagekwh = {300, 320, 234, 274, 384, 13, 180};
  private int kwh;
  private boolean appartement;
  private boolean apres1975;
  private int surface;
  static int[][] consoChauffage = { // première colonne avant 1975, deuxième après
                                    // maison
      {6667, 5000, // fioul domestique
          7111, 5333, // fioul lourd
          4250, 3542, // gaz naturel
          5000, 4167, // gaz (propane et butane)
          5325, 3551, // charbon
          238, 198, // bois
          2500, 1667}, // électricité
      // appartement
      {5000, 4167, // fioul domestique
          5333, 4445, // fioul lourd
          3542, 2833, // gaz naturel
          4167, 3333, // gaz (propane et butane)
          3551, 3551, // charbon
          198, 159, // bois
          1667, 1667}}; // électricité
  
  /**
   * Constructeur de l'objet chauffage si on a la consommation en kWh.
   * @param n nom du chauffage
   * @param t type du chauffage
   * @param k consommation en kWh pour le mois
   */
  Chauffage(String n, TypeChauffage t, int k) {
    super(n);
    if (k > 0) {
      type = t;
      kwh = k;
    }
  }

  /**
   * Constructeur de l'objet chauffage si on n'a pas la consommation en kWh.
   * @param n nom du chauffage
   * @param t type du chauffage
   * @param a vrai si on chauffe un appartement, faux si maison
   * @param date vrai si le bâtiment a été construit après 1975, faux sinon
   * @param s la surface de l'habitation
   */
  Chauffage(String n, TypeChauffage t, boolean a, boolean date, int s) {
    super(n);
    type = t;
    appartement = a;
    apres1975 = date;
    kwh = -1;
    surface = s;
  }

  /**
   * Si kwh est différent de -1, cela veut dire que le constructeur avec la consommation en kWh a été utilisé,
   * on procède au calcul avec le kWh, sinon on calcule en fonction de la surface, du type d'habitation et de sa date de construction.
   * Le type de chauffage est toujours pris en compte.
   */
  public float calculerTaux() {
    if (kwh != -1) {
      return kwh * consoChauffagekwh[this.type.ordinal()];
    } else {
      return surface * consoChauffage[ordonnees(this.appartement)][this.type.ordinal() * 2
          + ordonnees(this.apres1975)];
    }
  }
  
  /**
   * Renvoie 1 si le booléen est vrai, cela nous aide à déterminer les coordonnées d'une donnée dans le tableau
   * des consommations si on n'a pas les kWh.
   * @param b Booléen, ce sera surtout les variables appartement et apres1975 de l'objet qui seront utilisées
   * @return
   */
  public int ordonnees(boolean b) {
    if (b) {
      return 1;
    } else {
      return 0;
    }
  }
}



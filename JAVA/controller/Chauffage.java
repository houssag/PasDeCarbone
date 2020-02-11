package controller;


public class Chauffage extends Equipement {
  public enum TypeChauffage {
    FioulDomestique, FioulLourd, GazNaturel, GazPropaneOuButane, Charbon, Bois, Electricit�
  }
  // les types de chauffage possibles

  TypeChauffage type; // Le type du chauffage
  static int[] consoChauffagekwh = {300, 320, 234, 274, 384, 13, 180};
  // les �missions de CO2 des types de chauffages en g/kWh, arrang�s de fa�on � correspondre �
  // l'ordre des types de chauffage.
  private int kwh; // le nombre de kWh consomm� en un mois
  private boolean appartement; // Vrai si le b�timent est un appartement, faux si maison.
  private boolean apres1975; // Vrai si le b�timent a �t� construit apr�s 1975, faux sinon.
  private int surface; // Surface chauff�e en m2
  static int[][] consoChauffage = { // premi�re colonne avant 1975, deuxi�me apr�s
                                    // maison
      {6667, 5000, // fioul domestique
          7111, 5333, // fioul lourd
          4250, 3542, // gaz naturel
          5000, 4167, // gaz (propane et butane)
          5325, 3551, // charbon
          238, 198, // bois
          2500, 1667}, // �lectricit�
      // appartement
      {5000, 4167, // fioul domestique
          5333, 4445, // fioul lourd
          3542, 2833, // gaz naturel
          4167, 3333, // gaz (propane et butane)
          3551, 3551, // charbon
          198, 159, // bois
          1667, 1667}}; // �lectricit�

  /**
   * Constructeur de l'objet chauffage si on a la consommation en kWh.
   * 
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
   * 
   * @param n nom du chauffage
   * @param t type du chauffage
   * @param a vrai si on chauffe un appartement, faux si maison
   * @param date vrai si le b�timent a �t� construit apr�s 1975, faux sinon
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
   * Si kwh est diff�rent de -1, cela veut dire que le constructeur avec la consommation en kWh a
   * �t� utilis�, on proc�de au calcul avec le kWh, sinon on calcule en fonction de la surface, du
   * type d'habitation et de sa date de construction. Le type de chauffage est toujours pris en
   * compte.
   * 
   * @return le taux d'�mission de CO2 du chauffage
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
   * Renvoie 1 si le bool�en est vrai, cela nous aide � d�terminer les coordonn�es d'une donn�e dans
   * le tableau des consommations si on n'a pas les kWh.
   * 
   * @param b Bool�en, ce sera surtout les variables appartement et apres1975 de l'objet qui seront
   *        utilis�es
   * @return 0 ou 1
   */
  public int ordonnees(boolean b) {
    if (b) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * Renvoie le type de chauffage utilis�.
   * 
   * @return le type de chauffage utilis�
   */
  public TypeChauffage getType() {
    return type;
  }

  /**
   * Modifie le type de chauffage utilis�.
   * 
   * @param type le nouveau type de chauffage utilis�
   */
  public void setType(TypeChauffage type) {
    this.type = type;
  }
  
  /**
   * Renvoie une consommation de CO2 en g/kWh.
   * @param t le type de chauffage dont on veut la consommation de CO2 en g/kWh
   * @return la consommation de CO2 en g/kWh
   */
  public static int getConsoChauffagekwh(TypeChauffage t) {
    return consoChauffagekwh[t.ordinal()];
  }
  
  /**
   * Modifie la consommation en g/kWh d'un certain type de chauffage.
   * @param t le type de chauffage dont on veut modifier la consommation de CO2 en g/kWh
   * @param c la nouvelle consommation en g/kWh
   */
  public static void setConsoChauffagekwh(TypeChauffage t,int c) {
    consoChauffagekwh[t.ordinal()] = c;
  }

  /**
   * Renvoie la consommation en kWh.
   * 
   * @return la consommation en kWh
   */
  public int getKwh() {
    return kwh;
  }

  /**
   * Modifie la consommation en kWh.
   * 
   * @param kwh la nouvelle consommation en kWh
   */
  public void setKwh(int kwh) {
    this.kwh = kwh;
  }

  /**
   * Renvoie vrai si le b�timent est un appartement, faux sinon.
   * 
   * @return true si le b�timent est un appartement, false sinon
   */
  public boolean isAppartement() {
    return appartement;
  }
  
  /**
   * Modifie le type du b�timent (appartement ou maison).
   * 
   * @param appart true si le b�timent est un appartement, false sinon
   */
  public void setAppartement(boolean appart) {
    appartement = appart;
  }

  /**
   * Renvoie vrai si le b�timent date d'apr�s 1975, faux sinon.
   * 
   * @return true si le b�timent date d'apr�s 1975, false sinon
   */
  public boolean isApres1975() {
    return apres1975;
  }

  /**
   * Modifie la date de construction du b�timent (avant 1975 ou apr�s).
   * 
   * @param date true si le b�timent date d'apr�s 1975, false sinon
   */
  public void setApres1975(boolean date) {
    apres1975 = date;
  }

  /**
   * Renvoie la surface du b�timent chauff� en m2.
   * 
   * @return la surface du b�timent chauff� en m2
   */
  public int getSurface() {
    return surface;
  }
  /**
   * Modifie la surface du b�timent chauff� en m2.
   * 
   * @param s la nouvelle surface du b�timent chauff� en m2
   */
  public void setSurface(int s) {
    surface = s;
  }

  /**
   * Renvoie la consommation de CO2 en g pour une surface d'1m2 dont les caract�ristiques du b�timent seront renseign�es en param�tres.
   * @param appart true si on veut la consommation pour un appartement, false si maison
   * @param date true si on veut la consommation pour un b�timent datant d'apr�s 1975, false sinon
   * @param t le type du chauffage dont on veut la consommation
   * @return le nombre du tableau correspondant au b�timent et type de chauffage donn�
   */
  public int getConsoChauffage(boolean appart, boolean date, TypeChauffage t) {
    return consoChauffage[ordonnees(appart)][t.ordinal() * 2 + ordonnees(date)];
  }

  /**
   * Modifie la consommation de CO2 en g pour une surface d'1m2 dont les caract�ristiques du b�timent seront renseign�es en param�tres.
   * @param appart true si on veut modifier la consommation pour un appartement, false si maison
   * @param date true si on veut modifier la consommation pour un b�timent datant d'apr�s 1975, false sinon
   * @param t le type du chauffage dont on veut modifier la consommation
   * @param c la nouvelle consommation du b�timent
   */
  public void setConsoChauffage(boolean appart, boolean date, TypeChauffage t, int c) {
    consoChauffage[ordonnees(appart)][t.ordinal() * 2 + ordonnees(date)] = c;
  }
}



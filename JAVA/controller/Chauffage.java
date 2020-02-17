package controller;


public class Chauffage extends Equipement {
  public enum TypeChauffage {
    FioulDomestique, FioulLourd, GazNaturel, GazPropaneOuButane, Charbon, Bois, Electricité
  }
  // les types de chauffage possibles

  TypeChauffage type; // Le type du chauffage
  static int[] consoChauffagekwh = {300, 320, 234, 274, 384, 13, 180};
  // les émissions de CO2 des types de chauffages en g/kWh, arrangés de façon à correspondre à
  // l'ordre des types de chauffage.

  /**
   * Constructeur de l'objet chauffage si on a la consommation en kWh.
   * 
   * @param n nom du chauffage
   * @param t type du chauffage
   * @param k consommation en kWh pour le mois
   */
  Chauffage(String n, TypeChauffage t) {
    super(n);
    if (t != null) {
      type = t;
    } else {
      throw new IllegalArgumentException(
          "Le typeChauffage ne peut pas être null");
    }
  }


  /**
   * Si kwh est différent de -1, cela veut dire que le constructeur avec la consommation en kWh a
   * été utilisé, on procède au calcul avec le kWh, sinon on calcule en fonction de la surface, du
   * type d'habitation et de sa date de construction. Le type de chauffage est toujours pris en
   * compte.
   * 
   * @return le taux d'émission de CO2 du chauffage
   */
  public float calculerTaux() {
      return consoChauffagekwh[this.type.ordinal()];
  }

  /**
   * Renvoie 1 si le booléen est vrai, cela nous aide à déterminer les coordonnées d'une donnée dans
   * le tableau des consommations si on n'a pas les kWh.
   * 
   * @param b Booléen, ce sera surtout les variables appartement et apres1975 de l'objet qui seront
   *        utilisées
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
   * Renvoie le type de chauffage utilisé.
   * 
   * @return le type de chauffage utilisé
   */
  public TypeChauffage getType() {
    return type;
  }

  /**
   * Modifie le type de chauffage utilisé.
   * 
   * @param type le nouveau type de chauffage utilisé
   */
  public void setType(TypeChauffage type) {
    this.type = type;
  }

  /**
   * Renvoie une consommation de CO2 en g/kWh.
   * 
   * @param t le type de chauffage dont on veut la consommation de CO2 en g/kWh
   * @return la consommation de CO2 en g/kWh
   */
  public static int getConsoChauffagekwh(TypeChauffage t) {
    return consoChauffagekwh[t.ordinal()];
  }

  /**
   * Modifie la consommation en g/kWh d'un certain type de chauffage.
   * 
   * @param t le type de chauffage dont on veut modifier la consommation de CO2 en g/kWh
   * @param c la nouvelle consommation en g/kWh
   */
  public static void setConsoChauffagekwh(TypeChauffage t, int c) {
    consoChauffagekwh[t.ordinal()] = c;
  }

}



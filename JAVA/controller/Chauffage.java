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
          "Le typeChauffage ne peut pas �tre null");
    }
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
      return consoChauffagekwh[this.type.ordinal()];
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



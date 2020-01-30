
public class Chauffage extends Equipement {
  public enum TypeChauffage{
    FioulDomestique,
    FioulLourd,
    GazNaturel,
    GazPropaneOuButane,
    Charbon,
    Bois,
    Electricité
  }
  TypeChauffage type;
  static int[] consoChauffage= {300,320,234,274,384,13,180};
  private int kwh;
  Chauffage(String n,TypeChauffage t, int k) {
    super(n);
    type=t;
    kwh=k;
  }

  public float calculerTaux() {
    return kwh*consoChauffage[type.ordinal()];
  }
}

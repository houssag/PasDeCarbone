
public class Utilisation {

  Equipement unEquipement;
  int quantite;
  int nbPersonne;

  /**
   * Creer une utilisation pour une utilisation par une seule personne pendant une quantité et
   * concernant un équipement.
   * 
   * @param quantite désigne la quantité de l'équipement utilisé
   * @param unEquipement désigne l'équipement utilisé
   */
  public Utilisation(int quantite, Equipement unEquipement) {
    this.quantite = quantite;
    this.unEquipement = unEquipement;
    this.nbPersonne = 1;
  }

  /**
   * Creer une utilisation pour une utilisation par un nombre de personnes pendant une quantité et
   * concernant un équipement.
   * 
   * @param quantite désigne la quantité de l'équipement utilisé
   * @param unEquipement désigne l'équipement utilisé
   * @param nbPersonne désigne le nombre de personne utilisant l'équipement
   */
  public Utilisation(int quantite, Equipement unEquipement, int nbPersonne) {
    this.quantite = quantite;
    this.unEquipement = unEquipement;
    this.nbPersonne = nbPersonne;
  }


  public int getQuantite() {
    return quantite;
  }

  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }


}

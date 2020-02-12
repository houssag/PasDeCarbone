package controller;


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
    this(quantite, unEquipement, 1);
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
    if (quantite < 0) {
      throw new IllegalArgumentException();
    } else {
      this.quantite = quantite;
    }
    if (unEquipement == null) {
      throw new IllegalArgumentException();
    } else {
      this.unEquipement = unEquipement;
    }
    if (nbPersonne < 0) {
      throw new IllegalArgumentException();
    } else {
      this.nbPersonne = nbPersonne;
    }
  }

  /**
   * Permet de récupérer l'équipement utilisé.
   * 
   * @return un Equipement
   */
  public Equipement getUnEquipement() {
    return unEquipement;
  }

  /**
   * Permet de définir l'équipement utilisé.
   * 
   * @param unEquipement est un Equipement
   */
  public void setUnEquipement(Equipement unEquipement) {
    this.unEquipement = unEquipement;
  }

  /**
   * Permet de récupérer le nombre de personnes qui utilisent l'équipement.
   * 
   * @return le nombre de personnes utilisant l'équipement
   */
  public int getNbPersonne() {
    return nbPersonne;
  }

  /**
   * Permet de définir le nombre de personnes qui utilisent l'équipement.
   * 
   * @param nbPersonne est le nombre de personnes
   */
  public void setNbPersonne(int nbPersonne) {
    this.nbPersonne = nbPersonne;
  }


  /**
   * Permet de récupérer la quantite qui est une distance/surface d'un équipement.
   * 
   * @return la quantite
   */
  public int getQuantite() {
    return quantite;
  }

  /**
   * Permet de définir la quantité qui est une distance/surface d'un équipement.
   * 
   * @param quantite est une distance/surface d'un équipement
   */
  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }


}

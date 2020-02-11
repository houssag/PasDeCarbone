package controller;


public class Utilisation {

  Equipement unEquipement;
  int quantite;
  int nbPersonne;

  /**
   * Creer une utilisation pour une utilisation par une seule personne pendant une quantit� et
   * concernant un �quipement.
   * 
   * @param quantite d�signe la quantit� de l'�quipement utilis�
   * @param unEquipement d�signe l'�quipement utilis�
   */
  public Utilisation(int quantite, Equipement unEquipement) {
    this.quantite = quantite;
    this.unEquipement = unEquipement;
    this.nbPersonne = 1;
  }

  /**
   * Permet de r�cup�rer l'�quipement utilis�.
   * 
   * @return un Equipement
   */
  public Equipement getUnEquipement() {
    return unEquipement;
  }

  /**
   * Permet de d�finir l'�quipement utilis�.
   * 
   * @param unEquipement est un Equipement
   */
  public void setUnEquipement(Equipement unEquipement) {
    this.unEquipement = unEquipement;
  }

  /**
   * Permet de r�cup�rer le nombre de personnes qui utilisent l'�quipement.
   * 
   * @return le nombre de personnes utilisant l'�quipement
   */
  public int getNbPersonne() {
    return nbPersonne;
  }

  /**
   * Permet de d�finir le nombre de personnes qui utilisent l'�quipement.
   * 
   * @param nbPersonne est le nombre de personnes
   */
  public void setNbPersonne(int nbPersonne) {
    this.nbPersonne = nbPersonne;
  }

  /**
   * Creer une utilisation pour une utilisation par un nombre de personnes pendant une quantit� et
   * concernant un �quipement.
   * 
   * @param quantite d�signe la quantit� de l'�quipement utilis�
   * @param unEquipement d�signe l'�quipement utilis�
   * @param nbPersonne d�signe le nombre de personne utilisant l'�quipement
   */
  public Utilisation(int quantite, Equipement unEquipement, int nbPersonne) {
    this.quantite = quantite;
    this.unEquipement = unEquipement;
    this.nbPersonne = nbPersonne;
  }

  /**
   * Permet de r�cup�rer la quantite qui est une distance/surface d'un �quipement.
   * 
   * @return la quantite
   */
  public int getQuantite() {
    return quantite;
  }

  /**
   * Permet de d�finir la quantit� qui est une distance/surface d'un �quipement.
   * 
   * @param quantite est une distance/surface d'un �quipement
   */
  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }


}
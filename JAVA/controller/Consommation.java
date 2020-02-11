package controller;

import java.util.ArrayList;
import java.util.Date;

public class Consommation {
  // Liste de toute les consommations enregistr�s
  private ArrayList<ConsommationMensuelle> listeConsommation;
  public Profil profil;

  public Consommation(Profil p) {
    this.profil = p;
    listeConsommation = new ArrayList<ConsommationMensuelle>();
  }


  /**
   * Permet d'ajouter un mois de consommation � la liste de tous les mois de consommation.
   * 
   * @param uneConsommation la consommation � ajouter � la liste
   */
  public void ajouterConsommation(ConsommationMensuelle uneConsommation) {

    // Verifie que la consommation n'est pas null
    if (uneConsommation == null) {
      return;
    }
    // Verifie que la consommation n'est pas d�j� pr�sente dans la liste
    if (consommationExiste(uneConsommation)) {
      return;
    }

    listeConsommation.add(uneConsommation);
  }

  /**
   * Permet de de verifier si un mois de consommation existe d�j�.
   * 
   * @param uneConsommation la consommation � verifier
   * @return renvoie true si la consommation existe, false sinon
   */
  public boolean consommationExiste(ConsommationMensuelle uneConsommation) {
    for (ConsommationMensuelle uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.equals(uneConsommation)) {
        return true;
      }
    }
    return false;
  }


  /**
   * Description supprimerUneConsommation.
   * 
   * @param uneConsommation la consommation � supprimer de la liste
   * @return true si la suppression de uneConsommation a �t� effectu�e, false sinon.
   */
  public boolean supprimerUneConsommation(ConsommationMensuelle uneConsommation) {
    return listeConsommation.remove(uneConsommation);
  }

  /**
   * Description recupererTouteConsommation.
   * 
   * @return Renvoie sous forme de liste toute les consommations de la liste
   */
  public ArrayList<ConsommationMensuelle> recupererTouteConsommation() {
    return listeConsommation;
  }

  /**
   * Description recupererConsommationDate.
   * 
   * @param mois Prend en parametre le mois choisis.
   * @return Renvoie la liste de toute les consommations du mois en parametre.
   */
  public ConsommationMensuelle recupererConsommationDate(Date mois) {
    ConsommationMensuelle result = null;
    for (ConsommationMensuelle uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.getMois().equals(mois)) {
        result = uneConsommationDeLaListe;
      }
    }
    return result;
  }

  /**
   * Permet de r�cup�rer le profil de la consommation.
   * 
   * @return renvoie le profil
   */
  public Profil getProfil() {
    return profil;
  }

  /**
   * Permet de d�finir la valeur le profil de la consommation.
   * 
   * @param profil est le un profil d'un utilisateur
   */
  public void setProfil(Profil profil) {
    this.profil = profil;
  }

}

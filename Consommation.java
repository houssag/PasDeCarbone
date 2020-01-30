import java.util.ArrayList;
import java.util.Date;

public class Consommation {
  private Utilisateur unUtilisateur;
  private ArrayList<Equipement> listeEquipement;
  private Date mois;
  private float empreinte;


  /** Constructor de la classe consommation **/
  Consommation(Utilisateur unUtilisateur, Equipement unEquipement, Date mois) {
    this.unUtilisateur = unUtilisateur;
    this.listeEquipement = new ArrayList<Equipement>();
    this.listeEquipement.add(unEquipement);
    this.mois = mois;
    ListeConsommation.AjouterConsommation(this);
  }

  float calculerConsommationVehicule(int distance) {
    float taux = 0;
    for (Equipement unAutreEquipement : this.listeEquipement) {
      taux = unAutreEquipement.calculerTaux();
    }

    return taux;
  }

  /*
   * boolean equals(Consommation uneConsommation) { if(uneConsommation == null) return false;
   * if(uneConsommation.mois == this.mois) {
   * if(uneConsommation.unEquipement.equals(this.unEquipement) &&
   * uneConsommation.unUtilisateur.equals(this.unUtilisateur)) { return true; } } return false; }
   */

  public Utilisateur getUtilisateur() {
    return unUtilisateur;
  }

  public void setUnUtilisateur(Utilisateur unUtilisateur) {
    this.unUtilisateur = unUtilisateur;
  }

  public ArrayList<Equipement> getEquipement() {
    return listeEquipement;
  }

  public void addUnEquipement(Equipement unEquipement) {
    this.listeEquipement.add(unEquipement);
  }

  public Date getMois() {
    return mois;
  }

  public void setMois(Date mois) {
    this.mois = mois;
  }

  public float getConsommation() {
    return empreinte;
  }

}

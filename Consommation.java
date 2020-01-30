import java.util.ArrayList;
import java.util.Date;

public class Consommation {
  private Utilisateur unUtilisateur;
  private ArrayList<Equipement> listeEquipement;
  private ArrayList<Integer> listeDistance;
  private Date mois;
  private float empreinte;


  /** Constructor consommation
   * 
   * @param unUtilisateur correspond à l'utilisateur pour lequel la consommation existe
   * @param unEquipement correspond à au premier équipement que l'utilisateur a utilisé
   * @param distance
   * @param mois
   * 
   */
  Consommation(Utilisateur unUtilisateur, Equipement unEquipement, int distance, Date mois) {
    this.unUtilisateur = unUtilisateur;
    this.listeEquipement = new ArrayList<Equipement>();
    this.listeDistance = new ArrayList<Integer>();
    this.listeEquipement.add(unEquipement);
    this.listeDistance.add(distance);
    this.mois = mois;
    ListeConsommation.ajouterConsommation(this);
  }

  /** Description calculerConsommation.
   * 
   * @return renvoie sous forme d'entier la valeur de la consommation d'un mois pour un utilisateur
   */
  float calculerConsommation() {
    float taux = 0;
    for (int i = 0; i < this.listeEquipement.size(); i++) {
      taux = taux + this.listeEquipement.get(i).calculerTaux() * this.listeDistance.get(i);
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

  /** Description ajotuerUnEquipementEtUneDistance.
   * 
   * @param unEquipement correspond à l'équipement à ajouter à la liste d'équipement
   * @param distance la distance à ajotuer à la liste des distances
   */
  public void ajouterUnEquipementEtUneDistance(Equipement unEquipement, int distance) {
    this.listeEquipement.add(unEquipement);
    this.listeDistance.add(distance);
  }
  
  /** Description enleverUnEquipementEtUneDistance.
   * 
   * @param unEquipement correspond à l'équipement à supprimer
   */
  public void enleverUnEquipementEtUneDistance(Equipement unEquipement) {
    int i = this.listeEquipement.indexOf(unEquipement);
    this.listeEquipement.remove(unEquipement);
    this.listeDistance.remove(i);
  }

  /** Description getDistance.
   * 
   * @param unEquipement correspond à l'équipement pour lequel récuperer la distance.
   * @return Renvoie la distance parcouru avec l'équipement.
   */
  public Integer getDistance(Equipement unEquipement) {
    for (int i = 0; i < this.listeEquipement.size(); i++) {
      if (this.listeEquipement.get(i).equals(unEquipement)) {
        return this.listeDistance.get(i);
      }
    }
    return 0;
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

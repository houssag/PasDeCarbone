import java.util.ArrayList;
import java.util.Date;

public class ConsommationMensuelle {
  private Utilisateur unUtilisateur;
  private ArrayList<Equipement> listeEquipement;
  private ArrayList<Utilisation> listeUtilisation;
  private Date mois;

  private float empreinte;


  /**
   * Constructor consommation.
   * 
   * @param unUtilisateur correspond � l'utilisateur pour lequel la consommation existe
   * @param unEquipement correspond � au premier �quipement que l'utilisateur a utilis�
   * @param distance correspond � la distance effectu� avec un �quipement
   * @param mois correspond au mois de la consommation
   * 
   */
  ConsommationMensuelle(Utilisateur unUtilisateur, Equipement unEquipement,
      Utilisation uneUtilisation, Date mois) {
    this.unUtilisateur = unUtilisateur;
    this.listeEquipement = new ArrayList<Equipement>();
    this.listeUtilisation = new ArrayList<Utilisation>();
    this.listeEquipement.add(unEquipement);
    this.listeUtilisation.add(uneUtilisation);
    this.mois = mois;
  }

  /**
   * Calcules la consommation du mois en prenant en compte tout les �quipements.
   * 
   * 
   * @return renvoie sous forme d'entier la valeur de la consommation d'un mois pour un utilisateur
   */
  float calculerConsommation() {
    float taux = 0;
    for (int i = 0; i < this.listeEquipement.size(); i++) {
      if (this.listeUtilisation.get(i) instanceof UtilisationPartage) {
        taux = taux + (this.listeEquipement.get(i).calculerTaux()
            * this.listeUtilisation.get(i).getQuantite())
            / ((UtilisationPartage) this.listeUtilisation.get(i)).getNbPersonne();
      } else {
        taux = taux + this.listeEquipement.get(i).calculerTaux()
            * this.listeUtilisation.get(i).getQuantite();
      }
    }
    return taux;
  }

  /**
   * Renvoie l'utilisateur concern� par la consommation.
   * 
   * 
   * @return renvoie l'utilisateur concern� par la consommation
   */
  public Utilisateur getUtilisateur() {
    return unUtilisateur;
  }

  /**
   * Permet de modifier l'utilisateur concern� par la consommation.
   * 
   * 
   * @param unUtilisateur est l'utilisateur qui remplacera l'ancien utilisateur concern� par la
   *        consommation
   */
  public void setUnUtilisateur(Utilisateur unUtilisateur) {
    this.unUtilisateur = unUtilisateur;
  }

  /**
   * Permet d'ajouter un �quipement et une distance dans la liste des �quipements utilis�s pour le
   * mois.
   * 
   * @param unEquipement correspond � l'�quipement � ajouter � la liste d'�quipement
   * @param uneUtilisation correspond � l'utilisation de l'�quipement
   */    
  public void ajouterUnEquipementEtUneDistance(Equipement unEquipement,
      Utilisation uneUtilisation) {
    this.listeEquipement.add(unEquipement);
    this.listeUtilisation.add(uneUtilisation);
  }

  /**
   * Permet de retirer un �quipement et sa distance de la liste des �quipements utilis�es pour le
   * mois.
   * 
   * @param unEquipement correspond � l'�quipement � supprimer
   */
  public void enleverUnEquipementEtUneDistance(Equipement unEquipement) {
    int i = this.listeEquipement.indexOf(unEquipement);
    this.listeEquipement.remove(unEquipement);
    this.listeUtilisation.remove(i);
  }

  /**
   * Permet de r�cuperer la distance parcouru par l'�quipement en parametre.
   * 
   * @param unEquipement correspond � l'�quipement pour lequel r�cuperer la distance.
   * @return Renvoie la distance parcouru avec l'�quipement.
   */
  public Utilisation getDistance(Equipement unEquipement) {
    for (int i = 0; i < this.listeEquipement.size(); i++) {
      if (this.listeEquipement.get(i).equals(unEquipement)) {
        return this.listeUtilisation.get(i);
      }
    }
    return null;
  }

  /**
   * Permet de r�cuperer le mois concern� par la consommation.
   * 
   * @return renvoie le mois concern� par la consommation
   */
  public Date getMois() {
    return mois;
  }

  /**
   * Permet de d�finir le mois concern� par la consommation.
   * 
   * @param mois est le nouveau mois que concernera la consommation
   */
  public void setMois(Date mois) {
    this.mois = mois;
  }

  /**
   * Permet de r�cup�rer la valeur total de l'empreinte du mois et de l'utilisateur.
   * 
   * @return renvoie la valeur de l'empreinte de la consommation du mois
   */
  public float getConsommation() {
    return empreinte;
  }

}

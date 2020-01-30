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
   * @param unUtilisateur correspond à l'utilisateur pour lequel la consommation existe
   * @param unEquipement correspond à au premier équipement que l'utilisateur a utilisé
   * @param distance correspond à la distance effectué avec un équipement
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
   * Calcules la consommation du mois en prenant en compte tout les équipements.
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
   * Renvoie l'utilisateur concerné par la consommation.
   * 
   * 
   * @return renvoie l'utilisateur concerné par la consommation
   */
  public Utilisateur getUtilisateur() {
    return unUtilisateur;
  }

  /**
   * Permet de modifier l'utilisateur concerné par la consommation.
   * 
   * 
   * @param unUtilisateur est l'utilisateur qui remplacera l'ancien utilisateur concerné par la
   *        consommation
   */
  public void setUnUtilisateur(Utilisateur unUtilisateur) {
    this.unUtilisateur = unUtilisateur;
  }

  /**
   * Permet d'ajouter un équipement et une distance dans la liste des équipements utilisés pour le
   * mois.
   * 
   * @param unEquipement correspond à l'équipement à ajouter à la liste d'équipement
   * @param uneUtilisation correspond à l'utilisation de l'équipement
   */    
  public void ajouterUnEquipementEtUneDistance(Equipement unEquipement,
      Utilisation uneUtilisation) {
    this.listeEquipement.add(unEquipement);
    this.listeUtilisation.add(uneUtilisation);
  }

  /**
   * Permet de retirer un équipement et sa distance de la liste des équipements utilisées pour le
   * mois.
   * 
   * @param unEquipement correspond à l'équipement à supprimer
   */
  public void enleverUnEquipementEtUneDistance(Equipement unEquipement) {
    int i = this.listeEquipement.indexOf(unEquipement);
    this.listeEquipement.remove(unEquipement);
    this.listeUtilisation.remove(i);
  }

  /**
   * Permet de récuperer la distance parcouru par l'équipement en parametre.
   * 
   * @param unEquipement correspond à l'équipement pour lequel récuperer la distance.
   * @return Renvoie la distance parcouru avec l'équipement.
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
   * Permet de récuperer le mois concerné par la consommation.
   * 
   * @return renvoie le mois concerné par la consommation
   */
  public Date getMois() {
    return mois;
  }

  /**
   * Permet de définir le mois concerné par la consommation.
   * 
   * @param mois est le nouveau mois que concernera la consommation
   */
  public void setMois(Date mois) {
    this.mois = mois;
  }

  /**
   * Permet de récupèrer la valeur total de l'empreinte du mois et de l'utilisateur.
   * 
   * @return renvoie la valeur de l'empreinte de la consommation du mois
   */
  public float getConsommation() {
    return empreinte;
  }

}

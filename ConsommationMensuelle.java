import java.util.ArrayList;
import java.util.Date;

public class ConsommationMensuelle {
  private ArrayList<Utilisation> listeUtilisation;
  private Date mois;

  private float empreinte;


  /**
   * Constructor consommation.
   * 
   * @param distance correspond à la distance effectué avec un équipement
   * @param mois correspond au mois de la consommation
   * 
   */
  ConsommationMensuelle(Utilisation uneUtilisation, Date mois) {
    this.listeUtilisation = new ArrayList<Utilisation>();
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
    for (int i = 0; i < this.listeUtilisation.size(); i++) {
      taux = taux + (this.listeUtilisation.get(i).getUnEquipement().calculerTaux()
          * this.listeUtilisation.get(i).getQuantite())
          / this.listeUtilisation.get(i).getNbPersonne();
    }
    return taux;
  }

  /**
   * Permet d'ajouter une utilisation dans la liste des utilisations pour le mois.
   * 
   * @param uneUtilisation correspond à l'utilisation de l'équipement
   */
  public void ajouterUneUtilisation(Utilisation uneUtilisation) {
    this.listeUtilisation.add(uneUtilisation);
  }

  /**
   * Permet de retirer une utilisation de la liste des utilisations pour le mois.
   * 
   * @param uneUtilisation correspond à l'utilisation à supprimer
   */
  public void enleverUneUtilisation(Utilisation uneUtilisation) {
    this.listeUtilisation.remove(uneUtilisation);
  }

  /**
   * Permet de récuperer la distance parcouru par l'équipement en parametre.
   * 
   * @param unEquipement correspond à l'équipement pour lequel récuperer la distance.
   * @return Renvoie la distance parcouru avec l'équipement.
   */
  public Utilisation getDistance(Equipement unEquipement) {
    for (int i = 0; i < this.listeUtilisation.size(); i++) {
      if (this.listeUtilisation.get(i).getUnEquipement().equals(unEquipement)) {
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

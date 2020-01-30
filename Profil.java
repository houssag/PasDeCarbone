import java.util.ArrayList;
import java.util.Iterator;

public class Profil {
  public Utilisateur user;
  private static ArrayList<Equipement> listeEquipements;

  /**
   * Constructeur de la classe Profil. listeUtilisateurs regroupe une liste d'utilisateur, elle est
   * initialisé dans le constructeur L'utilisateur peut être un admin, un analyste ou un particulier
   * 
   * @param u est un utilisateur
   */
  public Profil(Utilisateur u) {
    this.user = u;
    listeEquipements = new ArrayList<Equipement>();
  }

  /**
   * Fonction permettant d'ajouter un équipement à la liste. Un équipement est un véhicule
   * 
   * @param e est un équipement
   */
  public void ajouterEquipement(Equipement e) {

    // Vérifie qu'un équipement est bien passé en paramètre
    if (e == null) {
      return;
    }

    // Ajoute l'équipement s'il n'est pas déjà présent dans la liste
    if (!equipementExiste(e)) {
      listeEquipements.add(e);
    }
  }

  /**
   * Fonction pour supprimer un équipement de la liste. Un équipement est un véhicule
   * 
   * @param e est un équipement
   * @return un boolean vrai si l'équipement a bien été supprimé de listeEquipements, faux sinon
   */
  public boolean supprimerEquipement(Equipement e) {

    // Vérifie qu'un équipement est bien passé en paramètre
    if (e == null) {
      return false;
    }

    // Supprime l'équipement si présent dans la liste
    if (rechercherEquipement(e.getNom()) != null) {
      return false;
    }
    return listeEquipements.remove(e);
  }

  /**
   * Fonction pour rechercher un équipement avec son nom. Un équipement est un véhicule
   * 
   * @param nom est le nom de l'équipement recherché
   * @return l'objet Equipement si trouvé dans la listeEquipements, null sinon
   */
  public Equipement rechercherEquipement(String nom) {
    Equipement e = null;
    Iterator<Equipement> iterator = listeEquipements.iterator();
    Equipement courant;

    // Parcour la liste des équipements
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques nom avec celui passé en paramètre
      if (courant.getNom().equals(nom)) {
        e = courant;
      }
    }
    return e;
  }

  /**
   * Fonction qui indique si un équipement est déjà présent dans la liste. Un équipement est un
   * véhicule
   * 
   * @param e est un équipement
   * @return un boolean vrai si l'équipement est présent dans listeEquipements, faux sinon
   */
  public boolean equipementExiste(Equipement e) {
    boolean rep = false;

    Iterator<Equipement> iterator = listeEquipements.iterator();
    Equipement courant;

    // Parcour la liste des équipements
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques nom avec celui passé en paramètre
      if (courant.getNom().equals(e.getNom())) {
        rep = true;
      }
    }

    return rep;
  }

  /**
   * Fonction pour afficher la liste des équipements sous forme de String.
   * 
   * @return sous forme de String la liste de tous les équipement d'un profil présents dans
   *         listeEquipements
   */
  public String toStringListP() {
    String list = "";

    Iterator<Equipement> iterator = listeEquipements.iterator();

    // Parcour la liste des équipements et les concatènes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getNom() + "]";
    }

    return list;
  }

}

import java.util.ArrayList;
import java.util.Iterator;

public class Profil {
  public Utilisateur user;
  private static ArrayList<Equipement> listeEquipements;

  /** Constructeur de la classe Profil. **/
  public Profil(Utilisateur u) {
    this.user = u;
    listeEquipements = new ArrayList<Equipement>();
  }

  /** Fonction permettant d'ajouter un équipement à la liste. **/
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

  /** Fonction pour supprimer un équipement de la liste. **/
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

  /** Fonction pour rechercher un équipement avec son nom. **/
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

  /** Fonction qui indique si un équipement est déjà présent dans la liste. **/
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

  /** Fonction pour afficher la liste des équipements sous forme de String. **/
  public String toStringListA() {
    String list = "";

    Iterator<Equipement> iterator = listeEquipements.iterator();

    // Parcour la liste des équipements et les concatènes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getNom() + "]";
    }

    return list;
  }

}

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

  /** Fonction permettant d'ajouter un �quipement � la liste. **/
  public void ajouterEquipement(Equipement e) {

    // V�rifie qu'un �quipement est bien pass� en param�tre
    if (e == null) {
      return;
    }

    // Ajoute l'�quipement s'il n'est pas d�j� pr�sent dans la liste
    if (!equipementExiste(e)) {
      listeEquipements.add(e);
    }
  }

  /** Fonction pour supprimer un �quipement de la liste. **/
  public boolean supprimerEquipement(Equipement e) {

    // V�rifie qu'un �quipement est bien pass� en param�tre
    if (e == null) {
      return false;
    }

    // Supprime l'�quipement si pr�sent dans la liste
    if (rechercherEquipement(e.getNom()) != null) {
      return false;
    }
    return listeEquipements.remove(e);
  }

  /** Fonction pour rechercher un �quipement avec son nom. **/
  public Equipement rechercherEquipement(String nom) {
    Equipement e = null;
    Iterator<Equipement> iterator = listeEquipements.iterator();
    Equipement courant;

    // Parcour la liste des �quipements
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques nom avec celui pass� en param�tre
      if (courant.getNom().equals(nom)) {
        e = courant;
      }
    }
    return e;
  }

  /** Fonction qui indique si un �quipement est d�j� pr�sent dans la liste. **/
  public boolean equipementExiste(Equipement e) {
    boolean rep = false;

    Iterator<Equipement> iterator = listeEquipements.iterator();
    Equipement courant;

    // Parcour la liste des �quipements
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques nom avec celui pass� en param�tre
      if (courant.getNom().equals(e.getNom())) {
        rep = true;
      }
    }

    return rep;
  }

  /** Fonction pour afficher la liste des �quipements sous forme de String. **/
  public String toStringListA() {
    String list = "";

    Iterator<Equipement> iterator = listeEquipements.iterator();

    // Parcour la liste des �quipements et les concat�nes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getNom() + "]";
    }

    return list;
  }

}

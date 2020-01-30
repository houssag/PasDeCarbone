import java.util.ArrayList;
import java.util.Iterator;

public class Profil {
  public Utilisateur user;
  private static ArrayList<Equipement> listeEquipements;

  /**
   * Constructeur de la classe Profil. listeUtilisateurs regroupe une liste d'utilisateur, elle est
   * initialis� dans le constructeur L'utilisateur peut �tre un admin, un analyste ou un particulier
   * 
   * @param u est un utilisateur
   */
  public Profil(Utilisateur u) {
    this.user = u;
    listeEquipements = new ArrayList<Equipement>();
  }

  /**
   * Fonction permettant d'ajouter un �quipement � la liste. Un �quipement est un v�hicule
   * 
   * @param e est un �quipement
   */
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

  /**
   * Fonction pour supprimer un �quipement de la liste. Un �quipement est un v�hicule
   * 
   * @param e est un �quipement
   * @return un boolean vrai si l'�quipement a bien �t� supprim� de listeEquipements, faux sinon
   */
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

  /**
   * Fonction pour rechercher un �quipement avec son nom. Un �quipement est un v�hicule
   * 
   * @param nom est le nom de l'�quipement recherch�
   * @return l'objet Equipement si trouv� dans la listeEquipements, null sinon
   */
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

  /**
   * Fonction qui indique si un �quipement est d�j� pr�sent dans la liste. Un �quipement est un
   * v�hicule
   * 
   * @param e est un �quipement
   * @return un boolean vrai si l'�quipement est pr�sent dans listeEquipements, faux sinon
   */
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

  /**
   * Fonction pour afficher la liste des �quipements sous forme de String.
   * 
   * @return sous forme de String la liste de tous les �quipement d'un profil pr�sents dans
   *         listeEquipements
   */
  public String toStringListP() {
    String list = "";

    Iterator<Equipement> iterator = listeEquipements.iterator();

    // Parcour la liste des �quipements et les concat�nes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getNom() + "]";
    }

    return list;
  }

}

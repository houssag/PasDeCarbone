import java.util.ArrayList;
import java.util.Iterator;

public class ListeUtilisateur {

  /** Liste des fonctions utilisées par la classe ListeUtilisateur. **/

  // Liste de tous les Utilisateurs
  private static ArrayList<Utilisateur> listeUtilisateurs;

  public ListeUtilisateur() {
    listeUtilisateurs = new ArrayList<Utilisateur>();
  }

  /**Fonction permettant d'ajouter un utilisateur à la liste. **/
  public void ajouterUtilisateur(Utilisateur u) { 

    // Vérifie qu'un utilisateur est bien passé en paramètre
    if (u == null) {
      return;
    }

    // Ajoute l'utilisateur s'il n'est pas déjà présent dans la liste
    if (!utilisateurExiste(u)) {
      listeUtilisateurs.add(u);
    }
  }

  /** Fonction pour supprimer un utilisateur de la liste. **/
  public void supprimerUtilisateur(Utilisateur u) {

    // Supprime l'utilisateur si présent dans la liste
    if (rechercherUtilisateur(u.getPseudo()) != null) {
      listeUtilisateurs.remove(u);
    }
  }

  /** Fonction pour rechercher un utilisateur avec son pseudo. **/
  public Utilisateur rechercherUtilisateur(String pseudo) {
    Utilisateur u = null;
    Iterator<Utilisateur> iterator = listeUtilisateurs.iterator();
    Utilisateur courant;

    // Parcour la liste des utilisateurs
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques pseudo avec celui passé en paramètre
      if (courant.getPseudo().equals(pseudo)) {
        u = courant;
      }
    }
    return u;
  }

  /** Fonction qui indique si un utilisateur est déjà présent dans la liste. **/
  public boolean utilisateurExiste(Utilisateur u) {
    boolean rep = false;

    Iterator<Utilisateur> iterator = listeUtilisateurs.iterator();
    Utilisateur courant;

    // Parcour la liste des utilisateurs
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques pseudo et mail avec ceux de l'utilisateur passé en paramètre
      if (courant.getPseudo().equals(u.getPseudo()) || courant.getMail().equals(u.getMail())) {
        rep = true;
      }
    }

    return rep;
  }

  /** Fonction pour afficher la liste des utilisateur sous forme de String. **/
  public String toStringListA() {
    String list = "";

    Iterator<Utilisateur> iterator = listeUtilisateurs.iterator();

    // Parcour la liste des utilisateur et les concatènes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getPseudo() + "]";
    }
    return list;
  }

}
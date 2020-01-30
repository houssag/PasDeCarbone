import java.util.ArrayList;
import java.util.Iterator;

public class ListeUtilisateur {

  /** Liste des fonctions utilisées par la classe ListeUtilisateur. **/

  // Liste de tous les Utilisateurs
  private static ArrayList<Utilisateur> listeUtilisateurs;

  /**
   * Constructeur de la classe ListeUtilisateur.
   * listeUtilisateurs regroupe une liste d'utilisateur, elle est initialisé dans le constructeur
   */
  public ListeUtilisateur() {
    listeUtilisateurs = new ArrayList<Utilisateur>();
  }

  /**
   * Fonction permettant d'ajouter un utilisateur à la liste.
   * L'utilisateur peut être un admin, un analyste ou un particulier
   * @param u est un utilisateur
   */
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

  /**
   * Fonction pour supprimer un utilisateur de la liste.
   * L'utilisateur peut être un admin, un analyste ou un particulier
   * @param u est un utilisateur
   */
  public void supprimerUtilisateur(Utilisateur u) {

    // Supprime l'utilisateur si présent dans la liste
    if (rechercherUtilisateur(u.getPseudo()) != null) {
      listeUtilisateurs.remove(u);
    }
  }

  /**
   * Fonction pour rechercher un utilisateur avec son pseudo.
   * L'utilisateur peut être un admin, un analyste ou un particulier
   * @param pseudo Il est unique à chaques utilisateurs
   * @return un utilisateur ou null si rien trouvé
   */
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

  /**
   * Fonction qui indique si un utilisateur est déjà présent dans la liste.
   * L'utilisateur peut être un admin, un analyste ou un particulier
   * @param u est un utilisateur
   * @return un boolean vrai si l'utilisateur existe dans la listeUtilisateurs, faux sinon
   */
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

  /**
   * Fonction pour afficher la liste des utilisateur.
   * @return sous forme de String la liste de tous les utilisateurs présents dans listeUtilisateurs
   */
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
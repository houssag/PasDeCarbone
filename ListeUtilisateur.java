import java.util.ArrayList;
import java.util.Iterator;

public class ListeUtilisateur {

  /** Liste des fonctions utilis�es par la classe ListeUtilisateur. **/

  // Liste de tous les Utilisateurs
  private static ArrayList<Utilisateur> listeUtilisateurs;

  /**
   * Constructeur de la classe ListeUtilisateur.
   * listeUtilisateurs regroupe une liste d'utilisateur, elle est initialis� dans le constructeur
   */
  public ListeUtilisateur() {
    listeUtilisateurs = new ArrayList<Utilisateur>();
  }

  /**
   * Fonction permettant d'ajouter un utilisateur � la liste.
   * L'utilisateur peut �tre un admin, un analyste ou un particulier
   * @param u est un utilisateur
   */
  public void ajouterUtilisateur(Utilisateur u) { 

    // V�rifie qu'un utilisateur est bien pass� en param�tre
    if (u == null) {
      return;
    }

    // Ajoute l'utilisateur s'il n'est pas d�j� pr�sent dans la liste
    if (!utilisateurExiste(u)) {
      listeUtilisateurs.add(u);
    }
  }

  /**
   * Fonction pour supprimer un utilisateur de la liste.
   * L'utilisateur peut �tre un admin, un analyste ou un particulier
   * @param u est un utilisateur
   */
  public void supprimerUtilisateur(Utilisateur u) {

    // Supprime l'utilisateur si pr�sent dans la liste
    if (rechercherUtilisateur(u.getPseudo()) != null) {
      listeUtilisateurs.remove(u);
    }
  }

  /**
   * Fonction pour rechercher un utilisateur avec son pseudo.
   * L'utilisateur peut �tre un admin, un analyste ou un particulier
   * @param pseudo Il est unique � chaques utilisateurs
   * @return un utilisateur ou null si rien trouv�
   */
  public Utilisateur rechercherUtilisateur(String pseudo) {
    Utilisateur u = null;
    Iterator<Utilisateur> iterator = listeUtilisateurs.iterator();
    Utilisateur courant;

    // Parcour la liste des utilisateurs
    while (iterator.hasNext()) {
      courant = iterator.next();

      // Compare chaques pseudo avec celui pass� en param�tre
      if (courant.getPseudo().equals(pseudo)) {
        u = courant;
      }
    }
    return u;
  }

  /**
   * Fonction qui indique si un utilisateur est d�j� pr�sent dans la liste.
   * L'utilisateur peut �tre un admin, un analyste ou un particulier
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

      // Compare chaques pseudo et mail avec ceux de l'utilisateur pass� en param�tre
      if (courant.getPseudo().equals(u.getPseudo()) || courant.getMail().equals(u.getMail())) {
        rep = true;
      }
    }

    return rep;
  }

  /**
   * Fonction pour afficher la liste des utilisateur.
   * @return sous forme de String la liste de tous les utilisateurs pr�sents dans listeUtilisateurs
   */
  public String toStringListA() {
    String list = "";

    Iterator<Utilisateur> iterator = listeUtilisateurs.iterator();

    // Parcour la liste des utilisateur et les concat�nes en String
    while (iterator.hasNext()) {
      list += "[" + iterator.next().getPseudo() + "]";
    }
    return list;
  }

}
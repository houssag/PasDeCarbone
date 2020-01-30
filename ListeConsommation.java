import java.util.ArrayList;
import java.util.Date;

public class ListeConsommation {
  // Liste de toute les consommations enregistrés
  private static ArrayList<Consommation> listeConsommation = new ArrayList<Consommation>();


  /** Description ajouterConsommation.
   *  
   * @param uneConsommation la consommation à ajouter à la liste
   */
  public static void ajouterConsommation(Consommation uneConsommation) {

    // Verifie que la consommation n'est pas null
    if (uneConsommation == null) {
      return;
    }
    // Verifie que la consommation n'est pas déjà présente dans la liste
    if (!consommationExiste(uneConsommation)) {
      return;
    }

    listeConsommation.add(uneConsommation);
  }

  /** Description consommationExiste.
   * 
   * @param uneConsommation la consommation à verifier
   * @return renvoie si la consommation existe ou non
   */
  public static boolean consommationExiste(Consommation uneConsommation) {
    for (Consommation uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.equals(uneConsommation)) {
        return true;
      }
    }
    return false;
  }


  /** Description supprimerUneConsommation.
   * 
   * @param uneConsommation la consommation à supprimer de la liste
   */
  public static boolean supprimerUneConsommation(Consommation uneConsommation) {
    return listeConsommation.remove(uneConsommation);
  }

  /** Description recupererTouteConsommation.
   * 
   * @return Renvoie sous forme de liste toute les consommations de la liste
   */
  public static ArrayList<Consommation> recupererTouteConsommation() {
    return listeConsommation;
  }

  /** Description recupererConsommationUtilisateur.
   * 
   * @param unUtilisateur L'utilisateur désiré
   * @return Renvoie sous forme de liste tout les consommations de l'utilisateur.
   */
  public static ArrayList<Consommation> recupererConsommationUtilisateur(
      Utilisateur unUtilisateur) {
    ArrayList<Consommation> result = new ArrayList<Consommation>();
    for (Consommation uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.getUtilisateur().equals(unUtilisateur)) {
        result.add(uneConsommationDeLaListe);
      }
    }
    return result;
  }


  /**
   * Description recupererConsommationDate.
   * 
   * @param mois Prend en parametre le mois choisis.
   * @return Renvoie la liste de toute les consommations du mois en parametre.
   */
  public static ArrayList<Consommation> recupererConsommationDate(Date mois) {
    ArrayList<Consommation> result = new ArrayList<Consommation>();
    for (Consommation uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.getMois().equals(mois)) {
        result.add(uneConsommationDeLaListe);
      }
    }
    return result;
  }

  /** Description recupererConsommationdateUtilisateur.
   * 
   * @param mois la date du mois souhaité
   * @param unUtilisateur l'utilisateur souhaité
   * @return Renvoie sous forme de liste toutes les consommations d'un utilisateur pour une date
   */

  public static Consommation recupererConsommationDateUtilisateur(Date mois,
      Utilisateur unUtilisateur) {
    for (Consommation uneConsommationDeLaListe : listeConsommation) {
      if (uneConsommationDeLaListe.getMois().equals(mois)) {
        return uneConsommationDeLaListe;
      }
    }
    return null;
  }

}

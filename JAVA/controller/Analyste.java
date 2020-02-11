public class Analyste extends Utilisateur {

  private String entreprise;

  /**
   * Constructeur de la classe particulier.
   * 
   * @param p prenom de l'analyste
   * @param m mot de passe de l'analyste
   * @param pre prenom de l'analyste
   * @param n nom de l'analyste
   * @param ad adresse de l'analyste
   * @param ma mail de l'analyste
   * @param entr entreprise de l'analyste
   */

  Analyste(String p, String m, String pre, String n, String ad, String ma, String entr) {
    super(p, m, pre, n, ad, ma);
    this.entreprise = entr;
  }

  /**
   * Permet de récupérer l'entreprise d'un analyste.
   * 
   * @return l'entreprise de l'analyste
   */
  public String getEntreprise() {
    return entreprise;
  }


  /**
   * Permet de changer l'entreprise d'un analyste.
   * 
   * @param entreprise la nouvelle entreprise de l'analyste
   */
  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }
}


public class UtilisationPartage extends Utilisation {

  int nbPersonne;

  public UtilisationPartage(int quantite, int nbPersonne) {
    super(quantite);
    this.nbPersonne = nbPersonne;
  }

  public int getNbPersonne() {
    return nbPersonne;
  }

  public void setNbPersonne(int nbPersonne) {
    this.nbPersonne = nbPersonne;
  }


}

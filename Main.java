public class Main {
  /** Classe de test. **/
  public static void main(String[] args) {
    ListeUtilisateur liste = new ListeUtilisateur();
    Particulier p1 = new Particulier("P1", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("P2", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    liste.ajouterUtilisateur(p1);
    liste.ajouterUtilisateur(p2);
    System.out.println(p1.getPseudo());
    System.out.println(liste.toStringListA());
  }
}

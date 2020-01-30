public class Main {
  /** Classe de test. **/
  public static void main(String[] args) {
    ListeUtilisateur liste = new ListeUtilisateur();
    Particulier p1 = new Particulier("DonMartin", "mdp", "Michel", "Leblanc", "", "michel@mail.fr");
    Particulier p2 = new Particulier("Diego", "mdp2", "Roger", "Lenoir", "", "Roger@mail.fr");
    liste.ajouterUtilisateur(p1);
    liste.ajouterUtilisateur(p2);
    System.out.println(liste.toStringListA());
    
    Profil pr1 = new Profil(p1);
    Voiture v1 = new Voiture("Porsche",Voiture.TypeCarburant.Diesel,12);
    Voiture v2 = new Voiture("Twingo",Voiture.TypeCarburant.Diesel,12);
    pr1.ajouterEquipement(v1);
    pr1.ajouterEquipement(v2);
    System.out.println(pr1.toStringListP());
  }
}
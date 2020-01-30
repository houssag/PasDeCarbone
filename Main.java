public class Main {
	public static void main(String[] args) {
		ListeUtilisateur liste = new ListeUtilisateur();
		Particulier P1 = new Particulier("P1","mdp","Michel","Leblanc","","michel@mail.fr");
		Particulier P2 = new Particulier("P2","mdp2","Roger","Lenoir","","Roger@mail.fr");
		liste.ajouterUtilisateur(P1);
		liste.ajouterUtilisateur(P2);
		System.out.println(P1.getPseudo());
		System.out.println(liste.toStringListA());
	}
}

package controller;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choix;
		Scanner sc = new Scanner(System.in);
		ListeUtilisateur l1 = new ListeUtilisateur();

		
		System.out.println("Menu : ");
		System.out.println("1 : Création de particulier");
		System.out.println("2 : Création d'équipement");
		System.out.println("3 : Renseigner une consommation mensuelle");
		System.out.println("0 : Quitter");
		
		choix = sc.nextInt();

		
		while (choix != 0) {
			switch (choix) {
			case 0:
				break;
			
			case 1:
				System.out.println("Veuillez saisir le pseudo du particulier (obligatoire)");
				String pseudo = sc.next().toString();
				System.out.println("Veuillez saisir le mot de passe du particulier  (obligatoire)");
				String mdp = sc.next().toString();
				System.out.println("Veuillez saisir le prénom du particulier (non obligatoire)");
				String prenom = sc.next().toString();
				System.out.println("Veuillez saisir le nom du particulier (non obligatoire)");
				String nom = sc.next().toString();
				System.out.println("Veuillez saisir l'adresse du particulier (non obligatoire)");
				String adresse = sc.next().toString();
				System.out.println("Veuillez saisir le mail du particulier (obligatoire)");
				String mail = sc.next().toString();

				if (pseudo != null && mdp != null && mail != null && pseudo.isEmpty() != true && mdp.isEmpty() != true
						&& mail.isEmpty() != true) {
					Particulier p = new Particulier(pseudo, mdp, prenom, nom, adresse, mail);
					l1.ajouterUtilisateur(p);
				} else {
					System.out.println("Pseudo ou Mot de passe ou mail incorrect");
				}
				break;
			
			case 2:
				System.out.println("-------------------------------------------------------------");
				System.out.println("Type d'équipement a créer : ");
				System.out.println("1 : Avion");
				System.out.println("2 : Train");
				System.out.println("3 : Voiture");
				System.out.println("4 : Chauffage");
				System.out.println("0 : Quitter");
				
				int choixEquipement = sc.nextInt();
				
			/*	switch(choixEquipement) {
				
				} */
				
				break;
			
			default :
				System.out.println("Choix incorrect veuillez réessayer");
			}
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("Menu : ");
			System.out.println("1 : Création de particulier");
			System.out.println("2 : Création d'équipement");
			System.out.println("3 : Renseigner une consommation mensuelle");
			System.out.println("0 : Quitter");

			sc.reset();
			choix = sc.nextInt();
		}

		System.out.println("Liste des utilisateurs : " + l1.toStringListA());

		System.out.println("Fin");
		sc.close();

	}
}

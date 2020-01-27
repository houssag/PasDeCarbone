import java.util.ArrayList;
import java.util.Date;

public class ListeConsommation {
	//Liste de toute les consommations enregistrés
	private static ArrayList<Consommation> listeConsommation = new ArrayList<Consommation>();
	
	
	//Fonction permettant d'ajouter une consommation à la liste
	static void AjouterConsommation(Consommation uneConsommation) {

		//Verifie que la consommation n'est pas null
		if(uneConsommation== null) return;
		//Verifie que la consommation n'est pas déjà présente dans la liste
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.equals(uneConsommation)) return;
		}
		listeConsommation.add(uneConsommation);
	}
	
	//Supprime une consommation de la liste et renvoie si elle a bien été supprimé ou non
	static boolean supprimerUneConsommation(Consommation uneConsommation) {
		return listeConsommation.remove(uneConsommation);
	}
	
	//Récupère la liste de toute les consommations enregistrés
	static ArrayList<Consommation> recupererTouteConsommation(){
		return listeConsommation;
	}
	
	//Récupère sous forme de liste toutes les consommations d'un utilisateur
	static ArrayList<Consommation> recupererConsommationUtilisateur(Utilisateur unUtilisateur) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getUtilisateur().equals(unUtilisateur)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//Récupère sous forme de liste toutes les consommations d'un équipement
	static ArrayList<Consommation> recupererConsommationEquipement(Equipement unEquipement) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getEquipement().equals(unEquipement)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//Récupère sous forme de liste toutes les consommations du mois spécifié
	static ArrayList<Consommation> recupererConsommationDate(Date mois) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//Récupère sous forme de liste toutes les consommations entre la date de début et la date de fin et par un utilisateur précis
	static ArrayList<Consommation> recupererConsommationDateUtilisateur(Date mois, Utilisateur unUtilisateur) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//Récupère sous forme de liste toutes les consommations entre la date de début et de fin et d'un équipement précis
	static ArrayList<Consommation> recupererConsommationDateEquipement(Date mois, Equipement unEquipement) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois) && uneConsommationDeLaListe.getEquipement().equals(unEquipement)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	
	//Calcul l'empreinte carbone d'un mois et d'un utilisateur précis
	static float calculEmpreinteUtilisateur(Date mois, Utilisateur unUtilisateur) {
		ArrayList<Consommation> liste = recupererConsommationDateUtilisateur(mois, unUtilisateur);
		float result = 0;
		for(Consommation uneConsommation : liste) {
			result=+ uneConsommation.getConsommation();
		}
		return result;
	}
	
	

}

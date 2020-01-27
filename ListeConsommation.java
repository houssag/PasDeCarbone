import java.util.ArrayList;
import java.util.Date;

public class ListeConsommation {
	//Liste de toute les consommations enregistr�s
	private static ArrayList<Consommation> listeConsommation = new ArrayList<Consommation>();
	
	
	//Fonction permettant d'ajouter une consommation � la liste
	static void AjouterConsommation(Consommation uneConsommation) {

		//Verifie que la consommation n'est pas null
		if(uneConsommation== null) return;
		//Verifie que la consommation n'est pas d�j� pr�sente dans la liste
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.equals(uneConsommation)) return;
		}
		listeConsommation.add(uneConsommation);
	}
	
	//Supprime une consommation de la liste et renvoie si elle a bien �t� supprim� ou non
	static boolean supprimerUneConsommation(Consommation uneConsommation) {
		return listeConsommation.remove(uneConsommation);
	}
	
	//R�cup�re la liste de toute les consommations enregistr�s
	static ArrayList<Consommation> recupererTouteConsommation(){
		return listeConsommation;
	}
	
	//R�cup�re sous forme de liste toutes les consommations d'un utilisateur
	static ArrayList<Consommation> recupererConsommationUtilisateur(Utilisateur unUtilisateur) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getUtilisateur().equals(unUtilisateur)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//R�cup�re sous forme de liste toutes les consommations d'un �quipement
	static ArrayList<Consommation> recupererConsommationEquipement(Equipement unEquipement) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getEquipement().equals(unEquipement)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//R�cup�re sous forme de liste toutes les consommations du mois sp�cifi�
	static ArrayList<Consommation> recupererConsommationDate(Date mois) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//R�cup�re sous forme de liste toutes les consommations entre la date de d�but et la date de fin et par un utilisateur pr�cis
	static ArrayList<Consommation> recupererConsommationDateUtilisateur(Date mois, Utilisateur unUtilisateur) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	//R�cup�re sous forme de liste toutes les consommations entre la date de d�but et de fin et d'un �quipement pr�cis
	static ArrayList<Consommation> recupererConsommationDateEquipement(Date mois, Equipement unEquipement) {
		ArrayList<Consommation> result= new ArrayList<Consommation>();
		for(Consommation uneConsommationDeLaListe : listeConsommation ){
			if(uneConsommationDeLaListe.getMois().equals(mois) && uneConsommationDeLaListe.getEquipement().equals(unEquipement)) result.add(uneConsommationDeLaListe);
		}
		return result;		
	}
	
	
	//Calcul l'empreinte carbone d'un mois et d'un utilisateur pr�cis
	static float calculEmpreinteUtilisateur(Date mois, Utilisateur unUtilisateur) {
		ArrayList<Consommation> liste = recupererConsommationDateUtilisateur(mois, unUtilisateur);
		float result = 0;
		for(Consommation uneConsommation : liste) {
			result=+ uneConsommation.getConsommation();
		}
		return result;
	}
	
	

}

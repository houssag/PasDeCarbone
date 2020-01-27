import java.lang.reflect.Array;
import java.util.Date;

public class Consommation {
	private Utilisateur unUtilisateur;
	private Equipement unEquipement;
	private Date mois;
	private float consommation;
	
	
	/** constructeur de la classe consommation **/
	Consommation(Utilisateur unUtilisateur, Equipement unEquipement, Date mois){
		this.unUtilisateur = unUtilisateur;
		this.unEquipement = unEquipement;
		this.mois = mois;
		ListeConsommation.AjouterConsommation(this);
	}
	
	boolean equals(Consommation uneConsommation) {
		if(uneConsommation == null) return false;
		if(uneConsommation.mois == this.mois) {
			if(uneConsommation.unEquipement.equals(this.unEquipement) && uneConsommation.unUtilisateur.equals(this.unUtilisateur)) {
				return true;
			}
		}
		return false;
	}
	
	float calculerConsommation(Object... args){
		this.consommation = this.unEquipement.calculerConsommation(args);
		return consommation;
	}

	public Utilisateur getUtilisateur() {
		return unUtilisateur;
	}

	public void setUnUtilisateur(Utilisateur unUtilisateur) {
		this.unUtilisateur = unUtilisateur;
	}

	public Equipement getEquipement() {
		return unEquipement;
	}

	public void setUnEquipement(Equipement unEquipement) {
		this.unEquipement = unEquipement;
	}

	public Date getMois() {
		return mois;
	}

	public void setMois(Date mois) {
		this.mois= mois;
	}

	public float getConsommation() {
		return consommation;
	}

	
	
	
}

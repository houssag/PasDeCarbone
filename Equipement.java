
abstract class Equipement {
	private String nom;
	//private float taux;
	
	/*Equipement(String n){
		nom=n;
		taux=t;
	}*/
	Equipement(String n){
		nom=n;
	}
	
	abstract float calculerTaux();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}*/
}

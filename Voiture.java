public class Voiture extends Equipement{
	final int DIESEL=2640;//Constante d'émission CO2 pour un litre de diesel consommé
	final int ESSENCE=2392;//Constante d'émission CO2 pour un litre d'essence consommé
	final int LPG=1665;//Constante d'émission CO2 pour un litre de LPG consommé
	final int CNG=1819;//Constante d'émission CO2 pour un Nm3 de CNG consommé
	
	//private String modele;//le modèle de la voiture
	public enum typeCarburant{//les différents types de carburant
		Diesel,
		Essence,
		LPG,
		CNG
	};
	private typeCarburant Carburant;
	private float LitresParKm;//les litres (ou Nm3 dans le cas du CNG) émis en un km parcouru
	
	Voiture(String n, typeCarburant c, float lpk, int np){		
		super(n);
		//modele=m;
		Carburant=c;
		LitresParKm=lpk;
	}
	
	public float calculerTaux() {
		float total;
		float coef;
		coef=-1;
		if(Carburant==typeCarburant.Diesel) {
			coef=DIESEL;
		}
		else if(Carburant==typeCarburant.Essence) {
			coef=ESSENCE;
		}
		else if(Carburant==typeCarburant.LPG) {
			coef=LPG;
		}
		else if(Carburant==typeCarburant.CNG) {
			coef=CNG;
		}
		total=(coef*LitresParKm);
		return total;
	}
	
}

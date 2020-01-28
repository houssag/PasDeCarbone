
public class Train extends Equipement{
	final float TGV_INOUI=1.9f;
	final float TGV_LYRIA=1.9f;
	final float OUIGO=1.9f;
	final float INTERCITES=5.7f;
	final float EUROSTAR=10.1f;
	final float THALYS=13.7f;
	final float GALA=5.2f;
	final float ALLEO=8.1f;
	final float TRANSILIEN=4.5f;
	final float RER=4.5f;
	final float TER=26.5f;
	
	
	public enum typeTrain{
		TGV_Inoui,
		TGV_Lyria,
		OUIGO,
		Intercites,
		Eurostar,
		Thalys,
		Gala,
		Alleo,
		Transilien,
		RER,
		TER
	};
	private typeTrain type;
	Train(String n,typeTrain tt){
		super(n);
		type=tt;
	}
	
	public float calculerTaux() {
		float taux;
		taux=-1;
		if(type==typeTrain.TGV_Inoui) {
			taux=TGV_INOUI;
		}
		else if(type==typeTrain.TGV_Lyria) {
			taux=TGV_LYRIA;
		}
		else if(type==typeTrain.OUIGO) {
			taux=OUIGO;
		}
		else if(type==typeTrain.Intercites) {
			taux=INTERCITES;
		}
		else if(type==typeTrain.Eurostar) {
			taux=EUROSTAR;
		}
		else if(type==typeTrain.Thalys) {
			taux=THALYS;
		}
		else if(type==typeTrain.Gala) {
			taux=GALA;
		}
		else if(type==typeTrain.Alleo) {
			taux=ALLEO;
		}
		else if(type==typeTrain.Transilien) {
			taux=TRANSILIEN;
		}
		else if(type==typeTrain.RER) {
			taux=RER;
		}
		else if(type==typeTrain.TER) {
			taux=TER;
		}
		return taux;
	}
}

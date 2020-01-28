
public class Avion extends Equipement {
	final int AFFAIRE=2;
	final int PREMIERE=3;
	final float EMISSIONPARKM=172;
	private boolean economique;
	private int distance;
	Avion(String n,boolean eco, int d){
		super(n);
		economique=eco;
		distance=d;
	}
	public float calculerTaux() {
		float total;
		total=distance*EMISSIONPARKM;
		if(!economique) {
			total=2*total;
		}
		return total;
	}

}

package contrat;

public class Alternance implements Contrat {
	
	private String nom;
	private final int pourcentageDeGain = 10;
	
	public Alternance() {
		this.nom = "Alternance";
	}

	public int pourcentageDeGain() {
		return pourcentageDeGain;
	}

	@Override
	public String toString() {
		return "Alternance [nom=" + nom + ", pourcentageDeGain=" + pourcentageDeGain + "]";
	}

}

package contrat;

public class CDD implements Contrat {
	
	private String nom;
	private final int pourcentageDeGain = 20;
	
	public CDD() {
		this.nom = "CDD";
	}

	public int pourcentageDeGain() {
		return pourcentageDeGain;
	}

	@Override
	public String toString() {
		return "CDD [nom=" + nom + ", pourcentageDeGain=" + pourcentageDeGain + "]";
	}

}

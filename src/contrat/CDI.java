package contrat;

public class CDI implements Contrat {
	
	private String nom;
	private final int pourcentageDeGain = 15;
	
	public CDI() {
		this.nom = "CDI";
	}

	public int pourcentageDeGain() {
		return pourcentageDeGain;
	}

	@Override
	public String toString() {
		return "CDI [nom=" + nom + ", pourcentageDeGain=" + pourcentageDeGain + "]";
	}

}

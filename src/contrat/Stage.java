package contrat;

public class Stage implements Contrat {
	
	private String nom;
	private final int pourcentageDeGain = 5;
	
	public Stage() {
		this.nom = "Stage";
	}

	public int pourcentageDeGain() {
		return pourcentageDeGain;
	}

	@Override
	public String toString() {
		return "Stage [nom=" + nom + ", pourcentageDeGain=" + pourcentageDeGain + "]";
	}

}

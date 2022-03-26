package personne;

import contrat.Contrat;

public class Employe extends Personne {
	
	private Contrat contrat;
	private double gain = 0.0;
	
	public Employe(Contrat contrat, String nom, String prenom, String adr, String dateN, String codeP) {
		super(nom, prenom, adr, dateN, codeP);
		this.contrat = contrat;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + getNom() + ", prenom="+ getPrenom() + ", adresse=" + getAdresse() 
				+ ", dateNaissance=" + getDateNaissance() + ", codePostal=" + getCodePostal() 
				+ ", contrat=" + getContrat() + ", gain=" + gain + "]";
	}
	
	

}

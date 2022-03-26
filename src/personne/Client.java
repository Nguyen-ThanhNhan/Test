package personne;

public class Client extends Personne {
	
	public Client(String nom, String prenom, String adr, String dateN, String codeP) {
		super(nom, prenom, adr, dateN, codeP);
	}

	@Override
	public String toString() {
		return "Client [nom=" + getNom().toUpperCase() + ", prenom=" + getPrenom() + ", adresse=" + getAdresse() + ","
				+ ", dateNaissance=" + getDateNaissance() + ", codePostal=" + getCodePostal() + "]";
	}
	

}

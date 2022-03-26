package rayons;

import java.util.Objects;

public class Produit {
	
	private int id;
	private static int incr = 1;
	private String nom;
	private double prixUnite;
	private String details;
	
	public Produit(String nom, double prixUnite) {
		this.id = incr;
		incr++;
		this.nom = nom;
		this.prixUnite = prixUnite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixUnite() {
		return prixUnite;
	}

	public void setPrixUnite(double prixUnite) {
		this.prixUnite = prixUnite;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prixUnite=" + prixUnite + ", details=" + details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}

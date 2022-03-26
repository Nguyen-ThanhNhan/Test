package commande;

import magasin.Magasin;
import personne.Employe;
import personne.Client;
import rayons.Produit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Commande {
	
	private int id;
	private static int incr = 1;
	private Magasin magasin;
	private Employe employe;
	private Client client;
	private ModePaiement modePaiement;
	private double prixTotal = 0.0;
	private Date date;
	private DateFormat dateFormat;
	private Map<Produit, Integer> produits; //On associe chaque produit à son stock
	
	public Commande(Client cl, Employe emp, Magasin mag, ModePaiement modeP) {
		this.id = incr;
		incr++;
		this.magasin = mag;
		this.employe = emp;
		this.client = cl;
		this.modePaiement = modeP;
		this.date = new Date();
		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.produits = new HashMap<Produit, Integer>();
	}
	
	public void calculerPrixTotal() {
		double prixTotal = 0.0;
		for(Map.Entry<Produit, Integer> p : this.getProduits().entrySet()) {
			prixTotal += ((Produit) p.getKey()).getPrixUnite()* (int) p.getValue();
		}
		this.setPrixTotal(prixTotal);
	}
	
	public void ajouterProduit(Produit prod, int quantite) {
		if(quantite > 0) {
			this.produits.put(prod, quantite);
			this.calculerPrixTotal();
		}
	}
	
	public void supprimerProduit(Produit prod, int quantite) {
		for(Map.Entry<Produit, Integer> p : this.getProduits().entrySet()) {
			if(p.getKey().equals(prod)) {
				if(quantite <= (int) p.getValue()) {
					p.setValue((int) p.getValue() - quantite);
				}
				else {
					System.out.println("La quantité du produit choisi est négatif ou supérieur au stock");
				}
			}
		}
		this.calculerPrixTotal();
	}
	
	public void supprimerProduitTotal(Produit prod) {
		this.produits.remove(prod);
		this.calculerPrixTotal();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Magasin getMagasin() {
		return magasin;
	}
	
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	
	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
				
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public ModePaiement getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
	
	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
			
	public String getDateCommande() {
		return dateFormat.format(this.date);
	}			
	
	public Map<Produit, Integer> getProduits() {
		return this.produits;
	}

	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", magasin=" + magasin + ", employe=" + employe + ", client=" + client
				+ ", modePaiement=" + modePaiement + ", prixTotal=" + prixTotal + ", date=" + date 
			    + ", produits=" + produits + "]";
	}

	
}		


			
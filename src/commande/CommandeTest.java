package commande;

import contrat.CDD;
import contrat.CDI;
import contrat.Contrat;
import contrat.Stage;
import magasin.Magasin;
import personne.Client;
import personne.Employe;
import rayons.NintendoSwitch;
import rayons.PS5;
import rayons.Produit;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {
	
	 private Client client = new Client("nom1", "prenom1", "adresse1", "dateNaissance1", "codePostal1");
	 private Contrat cdd = new CDD();
	 private Contrat cdi = new CDI();
	 private Contrat stage = new Stage();
	 private Employe employe = new Employe(cdd, "nom2", "prenom2", "adresse2", "dateNaissance2", "codePostal2");
	 private Magasin magasin = new Magasin("nomMagasin","adresseMagasin");
	 private Produit ps5 = new PS5();
	 private Produit nintendoSwitch = new NintendoSwitch();
	 Commande commande = new Commande(client, employe, magasin, ModePaiement.CB);

	 @Test
	 void calculerPrixTotal() {
		 Commande commande = new Commande(client, employe, magasin, ModePaiement.CB);
	     commande.ajouterProduit(ps5, 2); //+(455.45*2 = 910.90)
	     assertEquals(910.90, commande.getPrixTotal());
	 }

	 @Test
	 //Ajoute une certaine quantité à un produit ou un nouveau produit dans la commande
	 public void ajouterProduitQuantite() {
		 Commande commande = new Commande(client, employe, magasin, ModePaiement.CB);
	     commande.ajouterProduit(ps5, 2);
	     assertEquals(1, commande.getProduits().size());
	 }

	 @Test
	 //Supprime une quantité d'un produit
	 void supprimerProduitQuantite() {
		 Commande commande = new Commande(client, employe, magasin, ModePaiement.CB);
	     commande.ajouterProduit(ps5, 2); //+(455.45*2 = 910.90)
	     commande.ajouterProduit(nintendoSwitch, 2); //+(339*2 = 678)
	     commande.supprimerProduit(nintendoSwitch, 1); //-339
	     assertEquals(2, commande.getProduits().size()); //PS5 & NintendoSwitch
	     assertEquals(1249.90, commande.getPrixTotal()); //910.90 + 678 - 339 = 1249.90
	 }

	 @Test
	 //Supprime une quantité d'un produit et le produit si sa quantité atteint 0
	 void supprimerProduit() {
		 Commande commande = new Commande(client, employe, magasin, ModePaiement.CB);
	     commande.ajouterProduit(ps5, 2); //+(455.45*2 = 910.90)
	     commande.ajouterProduit(nintendoSwitch, 2); //+(339*2 = 678)
	     commande.supprimerProduit(nintendoSwitch, 2); //-678
	     assertEquals(1, commande.getProduits().size()); //PS5
	     assertEquals(910.90, commande.getPrixTotal()); //910.90 + 678 - 678 = 910.90
	 }

	   
	    
}


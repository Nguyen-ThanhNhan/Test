package magasin;

import contrat.Contrat;
import contrat.CDI;
import contrat.CDD;
import rayons.Livre;
import rayons.NintendoSwitch;
import rayons.PS5;
import rayons.Produit;
import rayons.Sweat;
import personne.Personne;
import personne.Employe;
import personne.Client;
import commande.Commande;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Magasin {
	
	private String nom, adresse;
	private ArrayList<Personne> personnes;
	private Map<Produit, Integer> produits;
	private int id;
	private static int incr;
	
	//Dans ce magasin, il n'y aura que ces 2 types de contrat 
	private static Contrat cdi;
	private static Contrat cdd;
	
	//Dans ce magasin, ce seront les principaux produits
	private Produit ps5, nintendoSwitch, sweat, livreJAVA, livreFX, livreSQL, livreGRAPHES;
	
	public Magasin(String nom, String adr) {
		this.nom = nom;
		this.adresse = adr;
		this.personnes = new ArrayList<Personne>();
		this.produits = new HashMap<Produit, Integer>();
		this.id = incr;
		incr++;
		this.cdi = new CDI();
		this.cdd = new CDD();
		this.ps5 = new PS5();
		this.nintendoSwitch = new NintendoSwitch();
		this.sweat = new Sweat();
		this.livreJAVA = new Livre("Java est un langage de programmation orient� objet cr�� par James Gosling et Patrick Naughton, \n"
					+ "employ�s de Sun Microsystems, avec le soutien de Bill Joy (cofondateur de Sun Microsystems en 1982), \n"
					+ "pr�sent� officiellement le 23 mai 1995 au SunWorld.");
		this.livreFX = new Livre("JavaFX est un framework et une biblioth�que d'interface utilisateur \n"
					+ "issue du projet OpenJFX, qui permet aux d�veloppeurs Java de cr�er une interface graphique \n" 
					+ "pour des applications de bureau, des applications internet riches et des applications smartphones et tablettes tactiles.");
		this.livreSQL = new Livre("SQL (sigle de Structured Query Language, en fran�ais langage de requ�te structur�e) \n" 
					+ "est un langage informatique normalis� servant � exploiter des bases de donn�es relationnelles. \n"
					+ "La partie langage de manipulation des donn�es de SQL permet de rechercher, d'ajouter, \n"
					+ "de modifier ou de supprimer des donn�es dans les bases de donn�es relationnelles.");
		this.livreGRAPHES = new Livre("La th�orie des graphes est la discipline math�matique et informatique qui �tudie les graphes, \n"
					+ "lesquels sont des mod�les abstraits de dessins de r�seaux reliant des objets. \n"
					+ "Ces mod�les sont constitu�s par la donn�e de sommets (aussi appel�s n�uds ou points, en r�f�rence aux poly�dres), \n"
					+ "et d'ar�tes (aussi appel�es liens ou lignes) entre ces sommets ; ces ar�tes sont parfois non-sym�triques \n"
					+ "(les graphes sont alors dits orient�s) et sont appel�es des fl�ches ou des arcs.");
		this.ajouterEmploye();
		this.ajouterArticle();
	}
	
	public void ajouterEmploye() {
		this.personnes.add(new Employe(cdi, "HAF MEFTAH", "Donia", "adr1", "05/07/2001", "codeP"));
		this.personnes.add(new Employe(cdd, "NGUYEN", "Pierre", "adr2", "26/11/2002", "codeP"));
	}
	
	//Ajoute tous les articles cr�es pour le magasin dans la liste des produits 
	public void ajouterArticle() {
		this.ajouterProduit(ps5, 200);
		this.ajouterProduit(sweat, 69);
		this.ajouterProduit(nintendoSwitch, 100);
		this.ajouterProduit(livreJAVA, 5);
	}
	
	public void ajouterProduit(Produit prod, int quantite) {
		if(prod != null){
			if(!this.produits.containsKey(prod)){
				this.produits.put(prod, quantite);
			}
			else {
				for (Map.Entry<Produit, Integer>  p : this.getProduits().entrySet()) {
					if(p.getKey().equals(prod)){
						p.setValue(p.getValue() + quantite);
					}
				}
			}
		}
	}
	
	//Retourne le produit en fonction de son id
	public Produit produitParID(String id){
		//Parcourt tous les produits du magasin afin de trouver le produit choisi
		for(Map.Entry<Produit, Integer> p : this.getProduits().entrySet()) { 
			if(p.getKey().getId() == Integer.parseInt(id) || p.getKey().getNom().equals(id)) {
				return p.getKey();
			}
		}
		return null;
	}
	
	//Retourne un caisier al�atoire entre tous les employ�s
	public Employe choixAleatoirCaissier(){
		Random rand = new Random();
		int choix = rand.nextInt(2);
		
		if(choix == 0){
			Employe Donia = (Employe) this.getPersonnes().get(0);
			return Donia;
		}
		else {
			Employe Pierre = (Employe) this.getPersonnes().get(1);
			return Pierre;
		}
	}
	
	//Retourne un client avec les informations communiqu�es par l'utilisateur
	public Client creationClient(){
		Scanner sc = new Scanner(System.in);
		//Informations personnelles
		System.out.println("Quel est votre pr�nom ?");
		String prenom = sc.next();
		while(prenom == null){
			System.out.println("Erreur ! R��crivez votre pr�nom.");
			prenom = sc.next();
		}

		System.out.println("Quel est votre nom ?");
		String nom = sc.next();
		while(nom == null){
			System.out.println("Erreur ! R��crivez votre nom.");
			nom = sc.next();
		}
			
		System.out.println("Quelle est votre adresse ?");
		String adresse = sc.next();
		while(adresse == null){
			System.out.println("Erreur ! R��crivez votre adresse.");
			adresse = sc.next();
		}
		
		System.out.println("Quel est votre code postal ?");
		int code = 0;
		try {
			code = sc.nextInt();
		} catch (InputMismatchException er){
			System.out.println("Erreur ! R��crivez votre code postal.");
			code = sc.nextInt();
		}
		
		System.out.println("Quelle est votre date de naissance ?");
		String dateNaiss = sc.next();
		while(dateNaiss == null){
			System.out.println("Erreur ! R��crivez votre date de naissance.");
			dateNaiss = sc.next();
		}
			
		//if(prenom!=null && nom!=null && adresse!=null && code > 0){
		Client client = new Client(nom.toUpperCase(), prenom, adresse, dateNaiss, dateNaiss);
		this.getPersonnes().add(client);
			
		return client;
	}
	
	//Ecrit toutes les informations d'un produit dans un fichier pass� en param�tre
	void ecrireDansUnFichier(Produit prod, File file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file.getName());

		if(writer.checkError()){
			throw new FileNotFoundException(file.getName());
		}
		else{
			writer.println(prod.toString());
		}
		writer.close();
	}

	//Cr�e un fichier dans lequel on retrouve les d�tails d'un produit
	public void afficherDetailsProduit(Produit prod) {
		String nom = prod.getNom() + "_Details.txt";
		File file = new File("src/Details/" + nom);
		
		try {
			ecrireDansUnFichier(prod, file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Cr�er un fichier pour le ticket de caisse avec les d�tails d'une commande pass�e en param�tre
	public void ticketDeCaisse(Commande commande, Client client) {
		File file = new File("src/Details/Ticket_de_Caisse.txt" );
		
		try {
			PrintWriter writer = new PrintWriter(file.getName());
			if(writer.checkError()){
				throw new FileNotFoundException(file.getName());
			}
			else{
				writer.println(commande.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}

	public Map<Produit, Integer> getProduits() {
		return produits;
	}

	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Contrat getCdi() {
		return cdi;
	}

	public static void setCdi(Contrat cdi) {
		Magasin.cdi = cdi;
	}

	public static Contrat getCdd() {
		return cdd;
	}

	public static void setCdd(Contrat cdd) {
		Magasin.cdd = cdd;
	}

	public Produit getPs5() {
		return ps5;
	}

	public void setPs5(Produit ps5) {
		this.ps5 = ps5;
	}

	public Produit getNintendoSwitch() {
		return nintendoSwitch;
	}

	public void setNintendoSwitch(Produit nintendoSwitch) {
		this.nintendoSwitch = nintendoSwitch;
	}

	public Produit getSweat() {
		return sweat;
	}

	public void setSweat(Produit sweat) {
		this.sweat = sweat;
	}

	public Produit getLivreJAVA() {
		return livreJAVA;
	}

	public void setLivreJAVA(Produit livreJAVA) {
		this.livreJAVA = livreJAVA;
	}

	public Produit getLivreFX() {
		return livreFX;
	}

	public void setLivreFX(Produit livreFX) {
		this.livreFX = livreFX;
	}

	public Produit getLivreSQL() {
		return livreSQL;
	}

	public void setLivreSQL(Produit livreSQL) {
		this.livreSQL = livreSQL;
	}

	public Produit getLivreGRAPHES() {
		return livreGRAPHES;
	}

	public void setLivreGRAPHES(Produit livreGRAPHES) {
		this.livreGRAPHES = livreGRAPHES;
	}
	
	@Override
	public String toString() {
		return "Magasin [nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
}

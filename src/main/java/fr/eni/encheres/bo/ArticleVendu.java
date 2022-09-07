package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;


public class ArticleVendu {
	
	private int id;
	private String nom;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private Categorie categorie;
	private Utilisateur vendeur;
	private EtatVente etatVente;
	private Retrait lieuRetrait;
	
	
	public ArticleVendu() {
		super();
	}
	
	public ArticleVendu(
			String nom, 
			String description, 
			LocalDate dateDebutEncheres, 
			LocalDate dateFinEncheres,
			int miseAPrix, 
			Utilisateur vendeur, 
			Categorie categorie
			) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		this.vendeur = vendeur;
		this.etatVente = EtatVente.CREE;
		this.lieuRetrait = vendeur.getLieuRetraitParDefaut();
	}
	
	public ArticleVendu(
			String nom, 
			String description, 
			LocalDate dateDebutEncheres, 
			LocalDate dateFinEncheres,
			int miseAPrix, 
			int prixVente, 
			Categorie categorie, 
			Utilisateur vendeur,
			EtatVente etatVente ,
			Retrait lieuRetrait) {
		this(nom,description,dateDebutEncheres,dateFinEncheres,miseAPrix,vendeur,categorie);
		this.etatVente=etatVente;
		this.lieuRetrait=lieuRetrait;
	}

	
	public ArticleVendu(String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, Categorie categorie, Utilisateur vendeur) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.vendeur = vendeur;
	}

	// GETTERS
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public Utilisateur getVendeur() {
		return vendeur;
	}
	public EtatVente getEtatVente() {
		return etatVente;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	
	
		// SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	@Override
	public String toString() {
		 StringBuffer str = new StringBuffer();
		 String nL1 = System.getProperty("line.separator");
		 
		 str.append("Catégorie :");
		// str.append(getCategorie().getLibelle()); 
		 str.append(nL1);
		 str.append("Mon article: ");
		 str.append(getNom());
		 str.append(nL1);
		 str.append("Description: ");
		 str.append(getDescription());
		 str.append(nL1);
		 str.append("Date de début: ");
		 str.append(getDateDebutEncheres());
		 str.append(", Date de Fin: ");
		 str.append(getDateFinEncheres());
		 str.append(nL1);
		 str.append("Départ enchère: ");
		 str.append(getMiseAPrix());
		 str.append(", Enchère en cours: ");
		 str.append(getPrixVente());
		 str.append(nL1);
		 str.append("Vendeur: ");
		// str.append(getVendeur().getPseudo());
		 str.append(nL1);
		 str.append("Lieu de retrait: ");
		// str.append(getVendeur().getLieuRetraitParDefaut());

        return str.toString();
	};
	
	

	
	
	

}

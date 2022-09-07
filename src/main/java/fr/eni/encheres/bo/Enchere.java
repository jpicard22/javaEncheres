package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Enchere {

	private int id;
	private LocalDate dateEnchere;
	private float prixEnchere;
	private Utilisateur encherisseur;
	private ArticleVendu article;
	
	public Enchere() {}

	public Enchere(
			LocalDate dateEnchere,
			float prixEnchere,
			Utilisateur encherisseur,
			ArticleVendu article) {
		this.dateEnchere = dateEnchere;
		this.prixEnchere = prixEnchere;
		this.encherisseur = encherisseur;
		this.article = article;
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public float getPrixEnchere() {
		return prixEnchere;
	}
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}
	public ArticleVendu getArticle() {
		return article;
	}
	
	// SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public void setPrixEnchere(float prixEnchere) {
		this.prixEnchere = prixEnchere;
	}
	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

}

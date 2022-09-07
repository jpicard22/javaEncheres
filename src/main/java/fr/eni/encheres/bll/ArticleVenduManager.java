package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exception.BusinessException;

public class ArticleVenduManager {
	
	private ArticleVenduDAO articleVendu;
	
	//lien avec la DAOFactory
	public ArticleVenduManager() {
		this.articleVendu = DAOFactory.getArticleVenduDAO();
	}
	
	public List<ArticleVendu> afficherTouslesArticles() throws BusinessException{
		return this.articleVendu.selectAll();
	}
	
	public List<ArticleVendu> afficherArticlesUser() throws BusinessException{
		return this.articleVendu.selectByUser(0);
	}
	
	public ArticleVendu ajouterArticle(
			String nom, 
			String description, 
			LocalDate dateDebutEncheres, 
			LocalDate dateFinEncheres, 
			int miseAPrix,
			int prixDeVente,
			String categorie,
			Utilisateur vendeur
			) throws BusinessException
	{
		
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Categorie cat = categorieDAO.selectByLibelle(categorie);		
		ArticleVendu art = new ArticleVendu(
				nom, 
				description, 
				dateDebutEncheres, 
				dateFinEncheres, 
				miseAPrix, 
				prixDeVente, 
				cat, 
				vendeur);
		
		try {
			this.articleVendu.insert(art);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return art;
	}
	
	public ArticleVendu modifierArticle(
			int id, 
			String nom, 
			String description, 
			LocalDate dateDebutEncheres, 
			LocalDate dateFinEncheres, 
			int miseAPrix,
			int prixDeVente,
			Categorie categorie,
			Utilisateur vendeur) throws BusinessException
	{
		
		ArticleVendu articleModifie = new ArticleVendu(
				nom, 
				description, 
				dateDebutEncheres, 
				dateFinEncheres, 
				miseAPrix, 
				prixDeVente, 
				categorie, 
				vendeur);
		articleModifie.setId(id);
		
		try {
			this.articleVendu.update(articleModifie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleModifie;
	}
	
	public void SupprimerArticle(ArticleVendu art) throws BusinessException
	{
		try {
			this.articleVendu.delete(art.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleVenduDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.CategorieDAOJDBCImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJDBCImpl;

public abstract class DAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJDBCImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJDBCImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJDBCImpl();
	}
}

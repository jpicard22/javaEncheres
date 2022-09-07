package fr.eni.encheres.dal.test;

import java.sql.SQLException;
import java.util.List;

import java.time.LocalDate;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.exception.BusinessException;

public class AppliTestDAL {

	public static void main(String[] args) throws SQLException, BusinessException {

		// Pour executer le script, lancer directement la class via java application et non server


		ArticleVenduDAO article = DAOFactory.getArticleVenduDAO();

		// Recuperer tous les articles
		List<ArticleVendu> listeArticle = article.selectAll();
		for( ArticleVendu art : listeArticle) {
			System.out.println(art.toString());
		}

		// Création d'un fake utilisateur et categorie pour test
		Utilisateur vendeur = new Utilisateur("Seens","Julien","Le Morvan","julien35@hotmail.fr","0404040404","9 rue Eric Tabarly","35430","Saint Pere","bonjour",250,false);
		vendeur.setId(3);
		Categorie categorie = new Categorie(6,"Téléphonie");

		ArticleVendu articleVendu = new ArticleVendu("Iphone12","Smartphone super cool !",LocalDate.now(),LocalDate.now().plusWeeks(1),100,vendeur,categorie);

		// Ajouter un article
		//article.insert(articleVendu);

		ArticleVendu articleVenduModif = new ArticleVendu("Iphone12","Smartphone super nul !",LocalDate.now(),LocalDate.now().plusWeeks(1),100,vendeur,categorie);
		// Ici, ajouter l'ID que la BDD aura créé automatiquement sur cette article
		articleVenduModif.setId(8);

		// Modifier un article créé precedemment 
		//article.update(articleVenduModif);

		// Supprimer l'article créé
		//article.delete(articleVenduModif.getId());

		// ---------------------- CATEGORIE ----------------------- //
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		List<Categorie> listCategorie = categorieDAO.selectAll();
		for(Categorie cat : listCategorie) {
			System.out.println(cat.toString());
		}
		//  Création d'une categorie
		//Categorie addCategorie = new Categorie("Marvel");
		//categorieDAO.insert(addCategorie); 
		// Modifier une cartegorie
		//Categorie updateCategorie = categorieDAO.selectByLibelle("Marvel");
		//updateCategorie.setLibelle("Marvel & DC");
		//categorieDAO.update(updateCategorie);
		// Supprimer une categorie
		//categorieDAO.delete(updateCategorie.getId());
		categorieDAO.delete(12);
		
	}

}

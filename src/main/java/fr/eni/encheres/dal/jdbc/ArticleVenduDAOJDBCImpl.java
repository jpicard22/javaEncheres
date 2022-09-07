package fr.eni.encheres.dal.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.exception.BusinessException;
import fr.eni.encheres.exception.CodesResultats;


public class ArticleVenduDAOJDBCImpl implements ArticleVenduDAO {

	// Requetes utilisées dans les différentes méthodes.
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String INSERT_ARTICLE_VENDU_DAO="insert into ARTICLES_VENDUS("
			+ "nom_article, "
			+ "description, "
			+ "date_debut_encheres, "
			+ "date_fin_encheres, "
			+ "prix_initial, "
			+ "prix_vente, "
			+ "no_utilisateur, "
			+ "no_categorie) values(?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_BY_USER_ID = "SELECT * FROM ARTICLES_VENDUS WHERE ARTICLES_VENDUS.no_utilisateur =?";
	private static final String DELETE_BY_ARTICLE_ID = "DELETE FROM ARTICLES_VENDUS WHERE ARTICLES_VENDUS.no_article =?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article=? " ;
	

	@Override
	public void insert(ArticleVendu articleVendu) throws BusinessException {
		
		if(articleVendu==null)
		{
			//exception à intégrer
		}
		
		try(Connection cnx = JdbcTools.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE_VENDU_DAO);

				pstmt.setString(1, articleVendu.getNom());
				pstmt.setString(2, articleVendu.getDescription());
				pstmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
				pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
				pstmt.setInt(5, articleVendu.getMiseAPrix());
				pstmt.setInt(6, articleVendu.getPrixVente());
				pstmt.setInt(7, articleVendu.getVendeur().getId());
				pstmt.setInt(8, articleVendu.getCategorie().getId());
				pstmt.executeUpdate();

				pstmt.close();
				cnx.commit();
			}
			catch(Exception e){
				cnx.rollback();
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultats.FORMAT_INSERTION_ARTICLE_ERREUR);
				throw businessException;
			}
		}
		catch(Exception e){
			e.printStackTrace();	
		}
		
	}
	
	@Override
	public List<ArticleVendu> selectByUser(int id) throws BusinessException {
		Connection cnx = null;
		PreparedStatement req = null;
		ResultSet rs = null;
		List<ArticleVendu> listArticle = new ArrayList<>();
		
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(SELECT_BY_USER_ID);
			req.setInt(1, id);
			rs = req.executeQuery();	
			ArticleVendu article;
			
			while (rs.next()) {
				article = articleBuilder(rs);
				listArticle.add(article);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_USER_ARTICLE_ERREUR);
			throw businessException;
		}
		return listArticle;
	}

	@Override
	public List<ArticleVendu> selectAll() throws BusinessException {
		Connection cnx = null;
		Statement req = null;
		ResultSet rs = null;
		List<ArticleVendu> listArticle = new ArrayList<>();
		
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.createStatement();
			rs = req.executeQuery(SELECT_ALL);	
			ArticleVendu article;
			
			while (rs.next()) {
				article = articleBuilder(rs);
				listArticle.add(article);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_ALL_ARTICLE_ERREUR);
			throw businessException;
		}
				
		return listArticle;
	}
	
	@Override
	public void update(ArticleVendu articleVendu) throws BusinessException {
		// nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article=?
		Connection cnx = null;
		PreparedStatement req = null;
		
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(UPDATE);
			req.setString(1, articleVendu.getNom());
			req.setString(2, articleVendu.getDescription());
			req.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()) );
			req.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()) );
			req.setInt(5, articleVendu.getMiseAPrix());
			req.setInt(6, articleVendu.getPrixVente());
			req.setInt(7, articleVendu.getVendeur().getId());
			req.setInt(8, articleVendu.getCategorie().getId());
			req.setInt(9, articleVendu.getId());
			req.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_MODIFICATION_ARTICLE_ERREUR);
			throw businessException;
		} finally {
			if(req != null) {
				try {
					req.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				JdbcTools.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void delete(int id) throws BusinessException {
		Connection cnx = null;
		PreparedStatement req = null;
		
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(DELETE_BY_ARTICLE_ID);
			req.setInt(1, id);
			req.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_SUPPRESSION_ARTICLE_ERREUR);
			throw businessException;
			
		}finally {
			if(req != null) {
				try {
					req.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				JdbcTools.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private ArticleVendu articleBuilder(ResultSet rs) throws SQLException, BusinessException {
		
		Utilisateur vendeur = getVendeurById(rs.getInt("no_utilisateur"));
		Categorie categorie = getCategorieById(rs.getInt("no_categorie"));
		ArticleVendu article = new ArticleVendu();
		article.setId(rs.getInt("no_article"));
		article.setNom(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
		article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
		article.setMiseAPrix(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		article.setVendeur(vendeur);
		article.setCategorie(categorie);
		
		return article;
	}
	
	private Categorie getCategorieById(int id)  throws SQLException, BusinessException{
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		Categorie categorie = categorieDAO.getByID(id);
		return categorie;

	}

	private Utilisateur getVendeurById(int int1) {
		
		return null;
	}


}

package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.exception.BusinessException;
import fr.eni.encheres.exception.CodesResultats;

public class CategorieDAOJDBCImpl implements CategorieDAO {

	
	private static final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	private static final String SELECT_ALL = "SELECT * FROM CATEGORIES";
	private static final String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
	private static final String SELECT_BY_LIBELLE = "SELECT * FROM CATEGORIES WHERE libelle =?";
	private static final String INSERT_CATEGORIES="insert into CATEGORIES(libelle)values(?)";
	private static final String UPDATE = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie =?";
	
	@Override
	public Categorie getByID(int id) throws BusinessException  {
		Connection cnx = null;
		PreparedStatement req = null;
		ResultSet rs = null;	
	    Categorie cat = new Categorie();
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(SELECT_BY_ID);
			req.setInt(1, id);
			rs = req.executeQuery();	
		if (rs.next()) {
				cat.setId(rs.getInt("no_categorie"));
				cat.setLibelle(rs.getString("libelle"));
			}	
		}catch (SQLException e){
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_ALL_ARTICLE_ERREUR);
			throw businessException;
		}	
		return cat;
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		Connection cnx = null;
		PreparedStatement req = null;
		

		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(DELETE);
			req.setInt(1, id);
			req.executeUpdate();		
		}catch (SQLException e){
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_SUPPRESSION_CATEGORIE_ERREUR);
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

	@Override
	public void insert(Categorie categorie) throws BusinessException {
		Connection cnx = null;
		PreparedStatement req = null;		
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(INSERT_CATEGORIES);
			req.setString(1,categorie.getLibelle());
			req.executeUpdate();
			req.close();
		}catch (SQLException e){
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_INSERTION_CATEGORIE_ERREUR);
			throw businessException;
		}
	}

	@Override
	public List<Categorie> selectAll() throws BusinessException {
		Connection cnx = null;
		Statement req = null;	
		ResultSet rs = null;
		List<Categorie> listcategorie  = new ArrayList<>();
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.createStatement(); 
			rs = req.executeQuery(SELECT_ALL);	
			


			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setId(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));	
				listcategorie.add(categorie);
			}	

		} catch (SQLException e){
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_ALL_CATEGORIE_ERREUR);
			throw businessException;
		}
		return listcategorie;
	}


	@Override
	public Categorie selectByLibelle(String libelle) throws BusinessException {
		Connection cnx = null;
		PreparedStatement req = null;	
		ResultSet rs = null;
		Categorie categorie = new Categorie();	
		try {
			cnx = JdbcTools.getConnection();
			req = cnx.prepareStatement(SELECT_BY_LIBELLE); 
			req.setString(1, libelle);
			rs = req.executeQuery();	
			if (rs.next()) {
				categorie.setId(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}


		}catch(SQLException e){
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultats.FORMAT_LIBELLE_CATEGORIE_ERREUR);
			throw businessException;
		}
		return categorie;
	}
	
	 public void update(Categorie categorie) throws BusinessException {
	        // libelle=? WHERE no_categorie=?
	        Connection cnx = null;
	        PreparedStatement req = null;
	        try {
	            cnx = JdbcTools.getConnection();
	            req = cnx.prepareStatement(UPDATE);
	            req.setString(1, categorie.getLibelle());
	            req.setInt(2, categorie.getId());
	            req.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException businessException = new BusinessException();
	            businessException.ajouterErreur(CodesResultats.FORMAT_UPDATE_CATEGORIE_ERREUR);
	            throw businessException;
	        } finally {
	            if(req != null) {
	                try {
	                    req.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            try {
	                JdbcTools.closeConnection();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}

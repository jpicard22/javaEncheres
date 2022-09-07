package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJDBCImpl implements UtilisateurDAO {
	
	private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email= ?";
	private static final String INSERT_UTILISATEURS = "INSERT INTO UTILISATEURS("
			+ "pseudo,"
			+ "nom,"
			+ "prenom,"
			+ "email,"
			+ "telephone,"
			+ "rue,"
			+ "code_postal,"
			+ "ville,"
			+ "mot_de_passe,"
			+ "credit,"
			+ "administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
	@Override 
	public Utilisateur selectByEmail(String email) {
		Utilisateur utilisateur = new Utilisateur();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			// recuperation de connexion simple
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(SELECT_BY_EMAIL);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getFloat("credit"),
						rs.getBoolean("administrateur"));
				
				utilisateur.setId(rs.getInt("no_utilisateur"));
				return utilisateur;
			}
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return utilisateur;
	}
	
	@Override
	public boolean addUser(Utilisateur user,int credit) {
		Connection con = null;
		PreparedStatement stmt ;
		try {
			// recuperation de connexion simple
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(INSERT_UTILISATEURS, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, user.getRue());
			stmt.setString(7, user.getCodePostal());
			stmt.setString(8, user.getVille());
			stmt.setString(9, user.getPassword());
			stmt.setFloat(10, user.getCredit());
			stmt.setBoolean(11, user.isAdministrateur());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			System.out.println("res inscription : " + rs);
			return rs.next();

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Utilisateur selectByEmail(Utilisateur vendeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Utilisateur utilisateur) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur select(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

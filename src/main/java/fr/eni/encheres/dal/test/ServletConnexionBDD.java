package fr.eni.encheres.dal.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.encheres.dal.jdbc.JdbcTools;

/**
 * Servlet implementation class ConnexionBDD
 */
@WebServlet("/jsp/ConnexionBDD")
public class ServletConnexionBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		//Création d'un objet de type Context permettant la recherche d'une ressource nommée dans l'arbre JNDI
		try {
//			Context context = new InitialContext();
//			
//			//Recherche de la dataSource
//			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx"); // attention -> rajouter un cast dataSource 
//			// car lookup retourne un objet et on veut une variable cible ("java:comp/env/jdbc/pool_cnx")
//			
//			//Demande d'une connexion. La méthode getConnection met la demande en attente tant qu'il n'y a pas de connexion disponible
//			Connection cnx = dataSource.getConnection();
			Connection cnx= JdbcTools.getConnection();
			
//			//Exploitation de la connexion
//			out.print("La connexion est "+ (cnx.isClosed()?"fermée":"ouverte")+".");
//			
//			//Libération de la connexion. Elle n'est pas fermée mais remise dans le pool
//			cnx.close();
			
			ResultSet rs =  cnx.createStatement().executeQuery("SELECT * from repas");
			
			
			while (rs.next()) {
			//s	System.out.println(rs.getString(0));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
						}
				
		} catch (SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
		}
		out.close();
	}
	
	public static Connection getConnection() throws SQLException
	{
		return ServletConnexionBDD.dataSource.getConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

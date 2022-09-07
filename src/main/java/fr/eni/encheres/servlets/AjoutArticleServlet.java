package fr.eni.encheres.servlets;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.EtatVente;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.exception.BusinessException;

/**
 * Servlet implementation class AjoutArticleServlet
 */
@WebServlet("/ajout-article")
public class AjoutArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
//		 ArticleVenduManager articleManager = null  ;
//		 String nom = request.getParameter("nom");
//		 String description = request.getParameter("description");
//		 LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres")) ;
//		 LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres")) ;
//		 int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
//		 int prixVente = Integer.parseInt(request.getParameter("prixVente"));
//		 String categorie  = request.getParameter("categorie");
//		 String vendeur = request.getParameter("vendeur");
//		 String rue = request.getParameter("rue");
//		 String codePostal = request.getParameter("codePostal");
//		 String ville = request.getParameter("ville");
//		 try {
//			articleManager.ajouterArticle(nom, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, categorie, vendeur);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		 
		
		
		
		
		doGet(request, response);
	}

}

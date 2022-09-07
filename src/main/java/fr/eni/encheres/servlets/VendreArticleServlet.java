package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exception.BusinessException;
import fr.eni.encheres.exception.CodesResultats;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet("/VendreArticle")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// En dernier, appel de la JSP que l'on veut afficher, on lui transmet la requete et la réponse à la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nameArticle"); 
		String description = request.getParameter("Description"); 
		LocalDate dateDebutEncheres = null;
		LocalDate dateFinEncheres = null;
		int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
		int prixDeVente = 0;
		String categorie = request.getParameter("categorie"); 
		HttpSession session = request.getSession();
		Utilisateur vendeur = (Utilisateur) session.getAttribute("user");
		ArticleVenduManager articleManager = new ArticleVenduManager();
		List<Integer> listeCodesErreur=new ArrayList<>();
		System.out.println(request.getParameter("dateDebutEncheres"));
		
		try
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"),dtf);
			dateFinEncheres = LocalDate.parse(request.getParameter("dateFinEncheres"),dtf);
		}
		catch(DateTimeParseException e)
		{
			e.printStackTrace();
			listeCodesErreur.add(CodesResultats.FORMAT_DATE_ERREUR);
		}
		
		try{	
			articleManager.ajouterArticle(nom, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixDeVente, categorie, vendeur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
				
			} catch (BusinessException e) {
				//Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp");
				rd.forward(request, response);
			}
		}
		

}

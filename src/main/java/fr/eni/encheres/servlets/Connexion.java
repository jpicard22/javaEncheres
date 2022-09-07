package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exception.BusinessException;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
//		HttpSession session = request.getSession();
//		session.setAttribute("resultat", true);
//		if(session.getAttribute("user") != null) {
//			Utilisateur user = (Utilisateur) session.getAttribute("user");
//		}
//		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Utilisateur user = UtilisateurManager.getUtilisateurManager().verificationEmailPassword(email, password);
			if (user != null) {
				System.out.println("Connexion réussi -- " + user.toString());
			} else {
				// Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				request.setAttribute("erreurs", "Login/Password inconnu");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// Sinon je retourne à la page d'ajout pour indiquer les problèmes:
			e.printStackTrace();
			request.setAttribute("erreurs", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		}

//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		UtilisateurManager form = new UtilisateurManager();
////		form.verifierIdentifiants(request);
//		form.verificationEmailPassword(email, password);
//        
//		if(form.getResultat() == true) {
//	        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
//		}
//		else {
//	        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
//		}
		
//		ArticleVenduManager articleManager = new ArticleVenduManager();
//		List<ArticleVendu> listArticle = null;
//		try {
//			listArticle = articleManager.afficherTouslesArticles();
//			request.setAttribute("listArticle", listArticle);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//System.out.println(listArticle.toString());
//		// En dernier, appel de la JSP que l'on veut afficher, on lui transmet la requete et la réponse à la JSP
//		this.getServletContext().getRequestDispatcher("/WEB-INF/VendreArticle.jsp").forward(request, response);
	}

}

package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.exception.BusinessException;

import java.util.List;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccueilServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleVenduManager articleManager = new ArticleVenduManager();
		List<ArticleVendu> listArticle = null;
		try {
			listArticle = articleManager.afficherTouslesArticles();
			request.setAttribute("listArticle", listArticle);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(listArticle.toString());
		// En dernier, appel de la JSP que l'on veut afficher, on lui transmet la requete et la réponse à la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

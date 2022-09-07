package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class Sinscrire
 */
@WebServlet("/Sinscrire")
public class Sinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sinscrire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.setAttribute("resultat", true);
//		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		UtilisateurManager form = new UtilisateurManager();
//		form.ajouterUnUtilisateur(request);
//		
//		if(form.getResultat()) {
//			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
//		}else {
//			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
//		}
//		
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String Prénom = request.getParameter("Prénom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("password");
		// Je lis les paramètres
		UtilisateurManager form = new UtilisateurManager();
		try {
			form.creerUnUtilisateur(pseudo, nom, Prénom, email, tel, rue, codePostal, ville, password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Utilisateur user = UtilisateurManager.getUtilisateurManager().verificationEmailPassword(email, password);
			if (user != null) {
				System.out.println("Connexion réussi -- " + user.toString());
			} else {
				// Sinon je retourne à la page d'ajout pour indiquer les problèmes:
				request.setAttribute("erreurs", "Login/Password inconnu");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// Sinon je retourne à la page d'ajout pour indiquer les problèmes:
			e.printStackTrace();
			request.setAttribute("erreurs", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			rd.forward(request, response);
		}
	}

}

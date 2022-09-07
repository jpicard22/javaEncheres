package fr.eni.encheres.bll;

import javax.servlet.http.HttpServletRequest;
// objet métiers 
import javax.servlet.http.HttpSession;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

// manager utilisateur 
public class UtilisateurManager {
	
	// ajout attribut dao
	private UtilisateurDAO utilisateurDAO;	
	private static UtilisateurManager uManager;
	
	private boolean resultat;
	private String errorMessage;
	
	// constructeur
	public UtilisateurManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}
	
	public static UtilisateurManager getUtilisateurManager() {
		if (uManager == null) {
			uManager = new UtilisateurManager();
		}
		return uManager;
	}
	
	// prend en param l'ensemble de la requête 
//	public void verifierIdentifiants(HttpServletRequest request) {
//		// on réucpère les champs
//		String email = request.getParameter("email");
//		String mdp = MD5Utils.digest("mdp");
//		
//		HttpSession session = request.getSession();
//		// ajout utilisateurDAO au lieu de finder
//		if(mdp.equals(utilisateurDAO.selectByEmail(email).getPassword())) {
//			session.setAttribute("user", utilisateurDAO.selectByEmail(email));
//			resultat = true;
//			//resultat = "vous êtes connecté";
//		}else {
//			resultat =false;
//		}
//		session.setAttribute("resultat", resultat);
//	}
//	
//	public void ajouterUnUtilisateur(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		// on récupère les champs
//		resultat = true;
//		String pseudo = request.getParameter("pseudo");
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String email = request.getParameter("email");
//		String tel = request.getParameter("tel");
//		String rue = request.getParameter("rue");
//		String codePostal = request.getParameter("codePostal");
//		String ville = request.getParameter("ville");
//		String mdp = MD5Utils.digest("mdp");
//		String mdp = request.getParameter("mdp");
//		String mdpConfirmation = MD5Utils.digest("mdpConfirmation");
//
//		if(!mdp.equals(mdpConfirmation)) {
//			resultat = false;
//			this.errorMessage ="Mots de passe non similaire";
//			session.setAttribute("resultat", false);
//			session.setAttribute("errorMessage", this.errorMessage);
//			return;
//		}
	public void creerUnUtilisateur(
			String pseudo,
			String nom, 
			String prenom, 
			String email, 
			String tel,
			String rue,
			String codePostal,
			String ville,
			String password
				) throws Exception {
		
//		HttpSession session = request.getSession();
		String hashPassword = MD5Utils.digest(password);
		Utilisateur userAdd = new Utilisateur(pseudo,nom,prenom,email,tel,rue,codePostal,ville,hashPassword,250,false);

		boolean rs = false;

		rs = utilisateurDAO.addUser(userAdd,250);
		resultat = rs;
		System.out.println("Resultat : " + resultat);

//		if(resultat == false) {
//			session.setAttribute("resultat", false);
//			this.errorMessage ="Peudo ou adresse mail déjà pris !";
//			session.setAttribute("errorMessage", this.errorMessage);
//		}
	}
	
	public Utilisateur verificationEmailPassword(String email, String password) {
		// TODO Vérification des différents paramètres
		// Chiffrer le mot de passe
		String hashPassword = MD5Utils.digest(password);
		try {
			return utilisateurDAO.select(email, hashPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean getResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
}

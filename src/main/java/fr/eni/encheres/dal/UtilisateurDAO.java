package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur selectByEmail(Utilisateur vendeur);
	
	public boolean addUser(Utilisateur user,int credit);

	Utilisateur selectByEmail(String email);

	public Utilisateur selectById(int id);
	
	void insert(Utilisateur utilisateur) throws Exception;

	Utilisateur select(String email, String password) throws Exception;
}

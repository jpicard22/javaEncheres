package fr.eni.encheres.bo;

public class Utilisateur {
	
	private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String password; 
	private float credit;
    private boolean administrateur;
    
    public Utilisateur() {}
    
    public Utilisateur(
    		String pseudo,
    		String prenom,
    		String nom,
    		String email,
    		String telephone,
    		String rue,
    		String codePostal,
    		String ville,
    		String password,
    		float credit,
    		boolean administrateur) {
    	
    	this.pseudo = pseudo;
    	this.prenom = prenom;
    	this.nom = nom;
    	this.email = email;
    	this.telephone = telephone;
    	this.rue = rue;
    	this.codePostal = codePostal;
    	this.ville = ville;
    	this.password = password;
    	this.credit = credit;
    	this.administrateur = administrateur;
    }
    
    public Utilisateur(int id) {
    	this.id = id;
    }
    
    // Utilisateur lambda avec un credit inital de 250
    public Utilisateur(
    		String pseudo,
    		String prenom,
    		String nom,
    		String email,
    		String telephone,
    		String rue,
    		String codePostal,
    		String ville,
    		String password) {
    	
    	this(pseudo, prenom, nom, email, telephone, rue, codePostal, ville, password, 250, false);
    }
    

    
    
    // GETTERS 
	public int getId() {
		return id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getRue() {
		return rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getVille() {
		return ville;
	}
	public String getPassword() {
		return password;
	}
	public float getCredit() {
		return credit;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	
	
	// SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
    
    
	public Retrait getLieuRetraitParDefaut()
	{
		return new Retrait(this.rue, this.codePostal, this.ville);
	}


}

package fr.eni.encheres.bo;

public class Retrait {
	
	private int id;
	private String rue;
	private String codePostal;
	private String ville;


	public Retrait() {
		super();
	}

	public Retrait(int id, String rue, String codePostal, String ville) {
		this.id = id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	//GETTERS
	public int getId() {
		return id;
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


	// SETTERS
	public void setId(int id) {
		this.id = id;
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


}

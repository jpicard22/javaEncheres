package fr.eni.encheres.bo;

public class Categorie {

	private int id;
	private String libelle;

	public Categorie() {}

	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Categorie(String libelle) { this.libelle = libelle; }

	// GETTERS
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Categorie n°"+this.getId() + " : " + this.getLibelle());
		return str.toString();
		
	}
	
}

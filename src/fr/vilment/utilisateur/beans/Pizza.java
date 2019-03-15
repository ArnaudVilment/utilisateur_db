package fr.vilment.utilisateur.beans;

public class Pizza {

	private int id;
	private int numero;
	private String description;
	private String reference;
	private String libelle;
	private int prix;
	private String urlImage;
	
	public Pizza(int id, int numero, String description, String reference, String libelle, int prix, String urlImage) {
		super();
		this.id = id;
		this.numero = numero;
		this.description = description;
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.urlImage = urlImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}

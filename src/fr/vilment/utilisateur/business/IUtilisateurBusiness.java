package fr.vilment.utilisateur.business;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Utilisateur;

public interface IUtilisateurBusiness {

	public ArrayList<Utilisateur> findAll();
	public void supprimerUtilisateur(int id);
	public boolean ajouterUtilisateur(String nom, String prenom, int numero, String phone, String email, String adresse, String photo);
	public Utilisateur getOne(int id);
	public boolean update(int id, String nom, String prenom, int numero, String phone, String email, String adresse, String photo);
}

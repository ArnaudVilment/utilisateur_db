package fr.vilment.utilisateur.repository;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Utilisateur;

public interface IUtilisateurRepository {
	
	public ArrayList<Utilisateur> findAll();
	
	public Utilisateur findOne(int id);
	
	public void delete(int id);
	
	public boolean add(String nom, String prenom, int numero, String phone, String email, String adresse, String photo);
	
	public boolean update(
			int id ,
			String nom, 
			String prenom, 
			int numero, 
			String phone, 
			String email, 
			String adresse,
			String photo);
}

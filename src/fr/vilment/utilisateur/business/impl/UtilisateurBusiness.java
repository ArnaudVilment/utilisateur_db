package fr.vilment.utilisateur.business.impl;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Utilisateur;
import fr.vilment.utilisateur.business.IUtilisateurBusiness;
import fr.vilment.utilisateur.repository.impl.UtilisateurRepository;

public class UtilisateurBusiness implements IUtilisateurBusiness {

	UtilisateurRepository ur = new UtilisateurRepository();
	
	@Override
	public ArrayList<Utilisateur> findAll() {
		ArrayList<Utilisateur> liste = ur.findAll();
		return liste;
	}

	@Override
	public Utilisateur getOne(int id) {
		Utilisateur user = ur.findOne(id);
		return user;
	}

	@Override
	public void supprimerUtilisateur(int id) {
		ur.delete(id);
	}

	@Override
	public boolean ajouterUtilisateur(String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		
		boolean b = ur.add(nom, prenom, numero, phone, email, adresse, photo);
		return b;
	}
	
	@Override
	public boolean update(int id, String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		boolean b = ur.update(id, nom, prenom, numero, phone, email, adresse, photo);
		return b;
	}
}

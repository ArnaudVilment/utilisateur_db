package fr.vilment.utilisateur.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Utilisateur;
import fr.vilment.utilisateur.repository.IUtilisateurRepository;

public class UtilisateurRepository implements IUtilisateurRepository {


	@Override
	public ArrayList<Utilisateur> findAll() {
		ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = 
					DriverManager.getConnection
					("jdbc:mariadb://localhost:3306/users", "root", "root");

			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery
					("SELECT id, nom, prenom, numero, phone, email, adresse, photo  FROM utilisateurs");

			while (resultat.next()) {
				int id = resultat.getInt("id");	
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				int numero = resultat.getInt("numero");
				String phone = resultat.getString("phone");
				String email = resultat.getString("email");
				String adresse = resultat.getString("adresse");
				String photo = resultat.getString("photo");

				Utilisateur u = new Utilisateur(
						id, 
						nom, 
						prenom, 
						numero, 
						phone, 
						email, 
						adresse, 
						photo);

				listeUtilisateurs.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}

	@Override
	public Utilisateur findOne(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "root");

			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery(

					"SELECT id, nom, prenom, numero, phone, email, adresse, photo FROM utilisateurs WHERE id = " + id);

			while (resultat.next()) {
				int idUtilisateur = resultat.getInt("id");
				String nomUtilisateur = resultat.getString("nom");
				String prenomUtilisateur = resultat.getString("prenom");
				int numeroUtilisateur = resultat.getInt("numero");
				String phoneUtilisateur = resultat.getString("phone");
				String emailUtilisateur = resultat.getString("email");
				String adresseUtilisateur = resultat.getString("adresse");
				String photoUtilisateur = resultat.getString("photo");

				Utilisateur u = new Utilisateur(idUtilisateur, nomUtilisateur, prenomUtilisateur, numeroUtilisateur, phoneUtilisateur, emailUtilisateur, adresseUtilisateur, photoUtilisateur);
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "root");

			Statement st = cnx.createStatement();

			st.executeQuery("DELETE FROM utilisateurs WHERE id = " + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean add(String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "root");

			PreparedStatement ps = 
					cnx.prepareStatement
					("INSERT INTO utilisateurs(nom, prenom, numero, phone, email, adresse, photo) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, numero);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, adresse);
			ps.setString(7, photo);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean update(int id, String nom, String prenom, int numero, String phone, String email, String adresse,
			String photo) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/users", "root", "root");
			
			PreparedStatement ps = cnx.prepareStatement(
					"UPDATE utilisateurs SET nom = ?  ,  prenom = ?, numero = ? , phone = ? , email = ? , adresse =  ?, photo = ? WHERE id = ?");
			
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, numero);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, adresse);
			ps.setString(7, photo);
			ps.setInt(8, id);
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

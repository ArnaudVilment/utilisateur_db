package fr.vilment.utilisateur.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Pizza;
import fr.vilment.utilisateur.repository.IPizzaRepository;

public class PizzaRepository implements IPizzaRepository {
	
	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> listePizzas = new ArrayList<>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = 
					DriverManager.getConnection
					("jdbc:mariadb://localhost:3306/pizzeria", "root", "root");

			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery
					("SELECT * FROM pizza");

			while (resultat.next()) {
				int id = resultat.getInt("id");	
				int numero = resultat.getInt("numero");
				String description = resultat.getString("description");
				String reference = resultat.getString("reference");
				String libelle = resultat.getString("libelle");
				int prix = resultat.getInt("prix");
				String urlImage = resultat.getString("urlImage");

				Pizza p = new Pizza(
						id, 
						numero, 
						description, 
						reference, 
						libelle, 
						prix, 
						urlImage);

				listePizzas.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listePizzas;
	}
	
	@Override
	public Pizza findOne(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "root");

			Statement st = cnx.createStatement();

			ResultSet resultat = st.executeQuery(

					"SELECT * FROM pizza WHERE id = " + id);

			while (resultat.next()) {
				int idPizza = resultat.getInt("id");	
				int numero = resultat.getInt("numero");
				String description = resultat.getString("description");
				String reference = resultat.getString("reference");
				String libelle = resultat.getString("libelle");
				int prix = resultat.getInt("prix");
				String urlImage = resultat.getString("urlImage");

				Pizza p = new Pizza(idPizza, numero, description, reference, libelle, prix, urlImage);
				return p;
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
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "root");

			Statement st = cnx.createStatement();

			st.executeQuery("DELETE FROM pizza WHERE id = " + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

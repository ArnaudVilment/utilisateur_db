package fr.vilment.utilisateur.business;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Pizza;

public interface IPizzaBusiness {

	public ArrayList<Pizza> findAll();
	public Pizza getOne(int id);
	public void supprimerPizza(int id);
}

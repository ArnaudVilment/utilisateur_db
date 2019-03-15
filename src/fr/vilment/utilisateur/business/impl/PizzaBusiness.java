package fr.vilment.utilisateur.business.impl;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Pizza;
import fr.vilment.utilisateur.business.IPizzaBusiness;
import fr.vilment.utilisateur.repository.impl.PizzaRepository;

public class PizzaBusiness implements IPizzaBusiness {
	
	PizzaRepository pR = new PizzaRepository();

	@Override
	public ArrayList<Pizza> findAll() {
		ArrayList<Pizza> liste = pR.findAll();
		return liste;
	}

	@Override
	public Pizza getOne(int id) {
		Pizza pizza = pR.findOne(id);
		return pizza;
	}

	@Override
	public void supprimerPizza(int id) {
		pR.delete(id);
	}
}

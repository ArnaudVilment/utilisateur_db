package fr.vilment.utilisateur.repository;

import java.util.ArrayList;

import fr.vilment.utilisateur.beans.Pizza;


public interface IPizzaRepository {

	public ArrayList<Pizza> findAll();
	public Pizza findOne(int id);
	public void delete(int id);
}

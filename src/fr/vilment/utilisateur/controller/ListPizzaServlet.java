package fr.vilment.utilisateur.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vilment.utilisateur.beans.Pizza;
import fr.vilment.utilisateur.beans.Utilisateur;
import fr.vilment.utilisateur.business.impl.PizzaBusiness;

/**
 * Servlet implementation class ListPizzaServlet
 */
@WebServlet(name = "listPizza", urlPatterns = { "/listPizza" })
public class ListPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaBusiness pB = new PizzaBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pizza> pizzas = pB.findAll();
		
		request.setAttribute("pizzas", pizzas);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/listPizza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

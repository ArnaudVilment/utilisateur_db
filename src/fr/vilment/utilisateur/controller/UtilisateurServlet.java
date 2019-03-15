package fr.vilment.utilisateur.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vilment.utilisateur.beans.Utilisateur;
import fr.vilment.utilisateur.business.impl.UtilisateurBusiness;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet(name = "listUtilisateur", urlPatterns = { "/listUtilisateur" })
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurBusiness utilisateurB = new UtilisateurBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Utilisateur> utilisateurs = utilisateurB.findAll();
		
		request.setAttribute("utilisateurs", utilisateurs);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/listUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}

package fr.vilment.utilisateur.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vilment.utilisateur.business.impl.UtilisateurBusiness;

/**
 * Servlet implementation class SupUtilisateurServlet
 */
@WebServlet(name = "supUtilisateur", urlPatterns = { "/supUtilisateur" })
public class SupUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurBusiness utilisateurB = new UtilisateurBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		utilisateurB.supprimerUtilisateur(Integer.parseInt(request.getParameter("id")));
		
		response.sendRedirect("listUtilisateur");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

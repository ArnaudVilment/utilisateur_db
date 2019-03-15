package fr.vilment.utilisateur.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.vilment.utilisateur.beans.Utilisateur;
import fr.vilment.utilisateur.business.impl.UtilisateurBusiness;

/**
 * Servlet implementation class NewUtilisateurServlet
 */
@WebServlet(name = "newUtilisateur", urlPatterns = { "/newUtilisateur" })
public class NewUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurBusiness utilisateurB = new UtilisateurBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/newUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		String numeroString = request.getParameter("numero");
		
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroString);
			String adresse = request.getParameter("adresse");

			String photo = request.getParameter("photo");

			String email = request.getParameter("email");

			String phone = request.getParameter("phone");

			boolean ok = utilisateurB.ajouterUtilisateur(
					nom, 
					prenom, 
					numero, 
					phone, 
					email, 
					adresse, 
					photo
					);

			if(ok)
				response.sendRedirect("listUtilisateur");
			else
				response.sendRedirect("newUtilisateur");  
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("newUtilisateur");  
		}
	}
}

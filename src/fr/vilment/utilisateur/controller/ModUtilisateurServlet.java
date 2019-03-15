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
 * Servlet implementation class ModUtilisateurServlet
 */
@WebServlet(name = "modUtilisateur", urlPatterns = { "/modUtilisateur" })
public class ModUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurBusiness uB = new UtilisateurBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		Utilisateur user = uB.getOne(id);
		
		request.setAttribute("utilisateur", user);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/modUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		String nom =request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		String numeroString = request.getParameter("numero");
		
		int numero = Integer.parseInt(numeroString);
		
		String phone = request.getParameter("phone");
		
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String photo = request.getParameter("photo");
		
		boolean ok = uB.update(id, nom, prenom, numero, phone, email, adresse, photo);
		
		if(ok) {
			response.sendRedirect("utilisateurInfo?id="+ id);
		}else {
			response.sendRedirect("modUtilisateur?id=" + id);
		}
	}

}

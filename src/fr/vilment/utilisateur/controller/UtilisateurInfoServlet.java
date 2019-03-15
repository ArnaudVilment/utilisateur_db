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
 * Servlet implementation class UtilisateurInfoServlet
 */
@WebServlet("/utilisateurInfo")
public class UtilisateurInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurBusiness ub = new UtilisateurBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int i = Integer.parseInt(idString);
		
		Utilisateur util = ub.getOne(i);
		
		request.setAttribute("utilisateur", util);
		
		this.getServletContext().
		getRequestDispatcher("/WEB-INF/pages/utilisateurInfo.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
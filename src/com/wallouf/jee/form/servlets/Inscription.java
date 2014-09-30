package com.wallouf.jee.form.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wallouf.jee.form.beans.Utilisateur;
import com.wallouf.jee.form.forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
@WebServlet( "/Inscription" )
public class Inscription extends HttpServlet {
    public static final String vue              = "/WEB-INF/inscription.jsp";
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";

    private static final long  serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( vue ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        InscriptionForm form = new InscriptionForm();
        Utilisateur utilisateur = form.inscrireUtilisateur( request );

        request.setAttribute( ATT_USER, utilisateur );
        request.setAttribute( ATT_FORM, form );

        this.getServletContext().getRequestDispatcher( vue ).forward( request, response );
    }

}

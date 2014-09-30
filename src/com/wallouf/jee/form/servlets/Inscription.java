package com.wallouf.jee.form.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inscription
 */
@WebServlet( "/Inscription" )
public class Inscription extends HttpServlet {
    public static final String vue                        = "/WEB-INF/inscription.jsp";
    public static final String PARAM_email                = "email";
    public static final String PARAM_password             = "motdepasse";
    public static final String PARAM_passwordConfirmation = "confirmation";
    public static final String PARAM_nom                  = "nom";
    public static final String ATT_ERREURS                = "erreurs";
    public static final String ATT_RESULTAT               = "resultat";

    private static final long  serialVersionUID           = 1L;

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
        String email = request.getParameter( PARAM_email );
        String motdepasse = request.getParameter( PARAM_password );
        String confirmation = request.getParameter( PARAM_passwordConfirmation );
        String nom = request.getParameter( PARAM_nom );

        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            /* Gérer les erreurs de validation ici. */
            erreurs.put( PARAM_email, e.getMessage() );
        }
        try {
            validationMotsDePasse( motdepasse, confirmation );
        } catch ( Exception e ) {
            /* Gérer les erreurs de validation ici. */
            erreurs.put( PARAM_password, e.getMessage() );
        }
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            /* Gérer les erreurs de validation ici. */
            erreurs.put( PARAM_nom, e.getMessage() );
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );

        this.getServletContext().getRequestDispatcher( vue ).forward( request, response );
    }

    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
                && confirmation.trim().length() != 0 ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.trim().length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

}

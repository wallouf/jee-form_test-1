package com.wallouf.jee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
@WebFilter( "/RestrictionFilter" )
public class RestrictionFilter implements Filter {

    public static final String ACCES_CONNEXION  = "/connexion";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    /**
     * Default constructor.
     */
    public RestrictionFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException,
            ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            req.getRequestDispatcher( ACCES_CONNEXION ).forward( req, res );
        } else {
            // pass the request along the filter chain
            chain.doFilter( request, response );
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init( FilterConfig fConfig ) throws ServletException {
        // TODO Auto-generated method stub
    }

}

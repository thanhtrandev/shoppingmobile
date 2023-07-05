package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			/* request.getSession(true).invalidate() */;
			HttpSession session = request.getSession(true);
			session.setAttribute("error", "logged out");
			session.removeAttribute("user");
			response.sendRedirect("login.jsp");
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 * rd.forward(request, response);
			 */
		}
		catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 * rd.forward(request, response);
			 */
		} 
		catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

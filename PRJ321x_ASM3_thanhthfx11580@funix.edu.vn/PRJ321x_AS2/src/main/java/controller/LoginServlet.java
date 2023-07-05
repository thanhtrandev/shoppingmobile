package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import bean.Account;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // vietnamese

		try {

			//request.getSession(true).invalidate();
			
		
			// make sure that email is valid

//			String regexMail = "[A-Z0-9_a-z]+@[A-Z0-9\\,a-z]+\\. [A-Za-z]{2,6}";
//
//			String regex = "[a-zA-Z0-9_!@#$%^&*]+"; // collect data from a login form
//
			String user = request.getParameter("username");
			String password = request.getParameter("password");

//			Account acc = new Account();
//
//			acc.setName(user);
//			acc.setPwd(password);
			HttpSession session = request.getSession(true);
//
//			if (!password.matches(regex) || !user.matches(regexMail)) {
//
//				session.setAttribute("error", "invalid syntax");
//
//				response.sendRedirect("login.jsp");
//
//			}

			// read information of account in web.xml

			String uid = getServletContext().getInitParameter("username");
			String pwd = getServletContext().getInitParameter("password");

			// check account use validate code in assignment 1 to valid user 
			//if (user !=null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
			// //set session
			
			if (user != null && password != null && user.equalsIgnoreCase(uid) && password.equals(pwd)) {
				// set session
				session.setAttribute("user", user);
				// login is valid, now redirect to index page of admin
				response.sendRedirect("ListController");

			} else {

				session.setAttribute("error", "Wrong username or password");

				response.sendRedirect("login.jsp");

			}

		} catch (NullPointerException e) {

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

			rd.forward(request, response);

		} catch (Exception ex) {

			response.getWriter().println(ex);

		}

	}

}

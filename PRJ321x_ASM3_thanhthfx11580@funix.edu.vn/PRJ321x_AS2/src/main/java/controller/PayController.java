package controller;
import model.Product;
import java.text.SimpleDateFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

import java.io.IOException;
import java.util.Date;

import dao.OrderDAO;
/**
 * Servlet implementation class PayController
 */
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Cart c = (Cart) session.getAttribute("cart");
		
		if(c == null || c.getAmount() == 0.0) {
			response.sendRedirect("ListController");
		}else {
		
		String user = (String) session.getAttribute("user");
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dateInsert = java.sql.Date.valueOf(dateFormat.format(date));
        
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.insertOder(user, 1, dateInsert + "", "CODE", "HN");
        
        int orderID = orderDAO.getOrderID();
        
        for (Product item : c.getItems()) {
        	orderDAO.insertOrderDetails(orderID, item.getProductId(), item.getNumber(), item.getNumber() * item.getPrice());
		}
        
        session.removeAttribute("cart");
        request.setAttribute("message", "Payment success");
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

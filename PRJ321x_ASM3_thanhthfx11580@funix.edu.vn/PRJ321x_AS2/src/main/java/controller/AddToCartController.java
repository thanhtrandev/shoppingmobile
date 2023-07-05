package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

/**
 * Servlet implementation class AddToCartController
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
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
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		if (!(id == null && action == null)) {
			if (action != null && action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart") == null) {
					List<Product> lst = new ArrayList<>();
					session.setAttribute("cart", new Cart(lst));
				}
				Product p = new ProductDAO().getProductById(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getProductId(), p.getProductName(), p.getDescription(), p.getPrice(),
						p.getImgSource(), p.getProductType(), p.getProductBrand(), 1));
				session.setAttribute("cart", c);
			}
			if (action != null && action.equalsIgnoreCase("minus")) {
				Product p = new ProductDAO().getProductById(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.minus(new Product(p.getProductId(), p.getProductName(), p.getDescription(), p.getPrice(),
						p.getImgSource(), p.getProductType(), p.getProductBrand()));
				session.setAttribute("cart", c);
			} else if (action != null && action.equalsIgnoreCase("delete")) {
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(Integer.parseInt(id));
				session.setAttribute("cart", c);
			}
		}
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

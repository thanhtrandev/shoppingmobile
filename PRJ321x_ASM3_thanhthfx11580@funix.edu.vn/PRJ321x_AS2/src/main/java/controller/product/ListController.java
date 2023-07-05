package controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.ProductDAO;
/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try (PrintWriter out = response.getWriter()){
			
			String txtSearch = request.getParameter("txtSearch");
			int pageSize = getPageSize(6, new ProductDAO().search(txtSearch).size());
			String index = request.getParameter("pageIndex");
	        int pageIndex = 0;
	        if (index == null) {
	            pageIndex = 1;
	        } else {
	            pageIndex = Integer.parseInt(index);
	        }
			
			List<Product> ls = new ProductDAO().searchWithPaging(txtSearch, pageIndex, 6);
			
			request.setAttribute("totalPage", pageSize);
	        request.setAttribute("numberProduct", 6);
	        request.setAttribute("pageIndex", pageIndex);
	        request.setAttribute("searchValue", txtSearch);
	        request.setAttribute("listP", ls);
	        
			request.getRequestDispatcher("Shop.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int getPageSize(int numberProduct, int allProduct) {
        int pageSize = allProduct / numberProduct;
        if (allProduct % numberProduct != 0) {
            pageSize = (allProduct / numberProduct) + 1;
        }
        return pageSize;

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

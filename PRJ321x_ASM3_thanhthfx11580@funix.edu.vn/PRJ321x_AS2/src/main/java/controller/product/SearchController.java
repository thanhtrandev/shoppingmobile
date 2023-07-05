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

import com.google.gson.JsonObject;

import dao.ProductDAO;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public int getPageSize(int numberProduct, int allProduct) {
        int pageSize = allProduct / numberProduct;
        if (allProduct % numberProduct != 0) {
            pageSize = (allProduct / numberProduct) + 1;
        }
        return pageSize;

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        
        String txtSearch = request.getParameter("txt");
        int pageSize = getPageSize(6, new ProductDAO().search(txtSearch).size());
		String index = request.getParameter("pageIndex");
        int pageIndex = 0;
        if (index == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.parseInt(index);
        }
        List<Product> list = new ProductDAO().searchWithPaging(txtSearch, pageIndex, 6);;

        PrintWriter out = response.getWriter();
        String product="";
        for (Product o : list) {
        	product +="<div class=\"col-12 col-sm-6 col-md-12 col-xl-4\">\r\n"
        			+ "						<div class=\"single-product-wrapper\">\r\n"
        			+ "							<!-- Product Image -->\r\n"
        			+ "							<div class=\"product-img\">\r\n"
        			+ "								<img src=\""+o.getImgSource()+"\" alt=\"\">\r\n"
        			+ "								<!-- Hover Thumb -->\r\n"
        			+ "								<!--<img class=\"hover-img\" src=\"img/product-img/product5.jpg\" alt=\"\">-->\r\n"
        			+ "							</div>\r\n"
        			+ "\r\n"
        			+ "							<!-- Product Description -->\r\n"
        			+ "							<div\r\n"
        			+ "								class=\"product-description d-flex align-items-center justify-content-between\">\r\n"
        			+ "								<!-- Product Meta Data -->\r\n"
        			+ "								<div class=\"product-meta-data\">\r\n"
        			+ "									<div class=\"line\"></div>\r\n"
        			+ "									<p class=\"product-price\">$"+o.getPrice()+"</p>\r\n"
        			+ "									<a href=\"InformationProductController?productID="+o.getProductId()+"\">\r\n"
        			+ "										<h6>"+o.getProductName()+"</h6>\r\n"
        			+ "									</a>\r\n"
        			+ "								</div>\r\n"
        			+ "								<!-- Ratings & Cart -->\r\n"
        			+ "								<div class=\"ratings-cart text-right\">\r\n"
        			+ "									<div class=\"ratings\">\r\n"
        			+ "										<i class=\"fa fa-star\" aria-hidden=\"true\"></i> <i\r\n"
        			+ "											class=\"fa fa-star\" aria-hidden=\"true\"></i> <i\r\n"
        			+ "											class=\"fa fa-star\" aria-hidden=\"true\"></i> <i\r\n"
        			+ "											class=\"fa fa-star\" aria-hidden=\"true\"></i> <i\r\n"
        			+ "											class=\"fa fa-star\" aria-hidden=\"true\"></i>\r\n"
        			+ "									</div>\r\n"
        			+ "									<div class=\"cart\">\r\n"
        			+ "										\r\n"
        			+ "										<a href=\"AddToCartController?id="+o.getProductId()+"&action=add\" data-toggle=\"tooltip\"\r\n"
        			+ "											data-placement=\"left\" title=\"Add to Cart\"><img\r\n"
        			+ "											src=\"img/core-img/cart.png\" alt=\"\"></a> <a href=\"Shop.jsp\"\r\n"
        			+ "											style='font-size: 16px;' title=\"Add to favourite\">&#129505;</a>\r\n"
        			+ "									</div>\r\n"
        			+ "								</div>\r\n"
        			+ "							</div>\r\n"
        			+ "						</div>\r\n"
        			+ "					</div>";
        }
        
        String strPaging = "";
        String active ="";
        for (int i = 1; i <= pageSize; i++) {
        	if(pageIndex == i) {
        		active = "active";
        	}else {
        		active = "";
        	}
			strPaging += "<li class=\"page-item "+active+"\"><a\r\n"
					+ "									class=\"page-link\"\r\n"
					+ "									href=\"ListController?pageIndex="+i+"&txtSearch="+txtSearch+"\">"+i+"</a></li>";
		}
        
        /* construct your json */
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("product", product);
        jsonResponse.addProperty("paging", strPaging);            

        /* send to the client the JSON string */
        response.getWriter().write(jsonResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

<%-- <%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page import="dao.DAO"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="model.Cart"%>

<div class="main-content-wrapper d-flex clearfix">
	<!-- Mobile Nav (max width 767px)-->
	<div class="mobile-nav">
		<!-- Navbar Brand -->
		<div class="amado-navbar-brand">
			<a href="Home.jsp"><img src="img/core-img/logo3.png" alt=""></a>
		</div>
		<!-- Navbar Toggler -->
		<div class="amado-navbar-toggler">
			<span></span><span></span><span></span>
		</div>
	</div>

	<!-- Header Area Start -->
	<header class="header-area clearfix">
		<!-- Close Icon -->
		<div class="nav-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<!-- Logo -->
		<div class="logo">
			<a href="index.html"><img src="img/core-img/logo4.png" alt=""></a>
		</div>
		<!-- Amado Nav -->
		<nav class="amado-nav">
			<ul>
				<li><a href="ListController">Shop</a></li>

				<li><a href="AddToCartController">Cart</a></li>



				<c:if test="${sessionScope.user == null}">
					<li><a href="login.jsp">Login</a></li>
				</c:if>
				<c:if test="${sessionScope.user != null}">
					<li><a href="LogoutServlet">Logout</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- Button Group -->
		<%
		/* DAO dao = new DAO();
		Product pNew = dao.getNewestProduct();
		int idNew = pNew.getId();
		int idBest = dao.getBestSeller(); */
		%>
		<div class="amado-btn-group mt-30 mb-100">
			<%--  <a href="productDetail?productID=<%= idBest%>" class="btn amado-btn mb-15">Bestseller</a>
            <a href="productDetail?productID=<%= idNew%>" class="btn amado-btn active">Newest Product</a> --%>
			<a href="productDetail?productID" class="btn amado-btn mb-15">Bestseller</a>
			<a href="productDetail?productID" class="btn amado-btn active">Newest
				Product</a>
		</div>
		<!-- Cart Menu -->
		<div class="cart-fav-search mb-100">
		<%
                                Cart c = (Cart) session.getAttribute("cart");
                                int size = 0;
                                if(c != null){
                                	size = c.getItems().size();
                                }

                                %>
			<a href="AddToCartController" class="cart-nav"><img src="img/core-img/cart.png"
				alt=""> Cart <span>(<%=size %>)</span></a> <a
				href="#" class="fav-nav"><img src="img/core-img/favorites.png"
				alt=""> Favourite</a>
			<!-- <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a> -->
		</div>
		<!-- Social Button -->
		<div class="social-info d-flex justify-content-between">
			<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
				href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
		</div>
	</header>
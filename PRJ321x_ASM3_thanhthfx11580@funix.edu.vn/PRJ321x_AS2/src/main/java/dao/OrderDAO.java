package dao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Cart;
import model.Order;
import context.DBContext;
public class OrderDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	public void insertOder(String userMail, int status, String orderDate, String orderDiscountCode, String orderAddress) {
		String query = "INSERT INTO orders (user_mail, order_status,order_date,order_discount_code,order_address)\n"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userMail);
            ps.setInt(2, status);
            ps.setString(3, orderDate);
            ps.setString(4, orderDiscountCode);
            ps.setString(5, orderAddress);
            ps.executeUpdate();
        } catch (Exception e) {
        }
	}
	
	public int getOrderID() {
        String query = "SELECT order_id from orders order BY order_id DESC limit 1";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
	
	public void insertOrderDetails(int orderID, int productID, int amount, double price) {
        String query = "INSERT INTO orders_detail VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.setDouble(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

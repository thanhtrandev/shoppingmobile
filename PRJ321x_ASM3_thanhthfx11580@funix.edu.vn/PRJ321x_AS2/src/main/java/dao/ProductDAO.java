package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import context.DBContext;

import java.util.ArrayList;
import model.Product;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> search(String txtSearch){
		List<Product> list = new ArrayList<>();
		String query = "select * from products";
		if(txtSearch != null && !txtSearch.trim().equals("")) {
			query += " where product_name like ?";
		}
       
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            if(txtSearch != null && !txtSearch.trim().equals("")) {
            	 ps.setString(1, "%" + txtSearch + "%");
            }
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

        } catch (Exception e) {
        }
        return list;
	}
    
	public List<Product> searchWithPaging(String txtSearch,int pageIndex, int pageSize){
		List<Product> list = new ArrayList<>();
		String query = "select * from products";
		if(txtSearch != null && !txtSearch.trim().equals("")) {
			query += " where product_name like ?";
		}
		query += " LIMIT ? OFFSET ?";
       
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            if(txtSearch != null && !txtSearch.trim().equals("")) {
            	 ps.setString(1, "%" + txtSearch + "%");
            	 
            	 ps.setInt(2, pageSize);
                 ps.setInt(3, pageIndex * pageSize - pageSize);
                 
            }else {
            	ps.setInt(1, pageSize);
                ps.setInt(2, pageIndex * pageSize - pageSize);
              
            }
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

        } catch (Exception e) {
        }
        return list;
	}
	
	public Product getProductById(String id) {
		String query = "select * from products where product_id = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, id);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }

        } catch (Exception e) {
        }
        return null;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author DELL
 */
public class ProductDAO {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection conn = DBContext.DBContext();
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Product";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return list;
    }

    public void add(Product st) {
        String query = "INSERT INTO Product(id, des, price) VALUES(?,?,?)";
        try {
            Connection connection = DBContext.DBContext();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getCode());
            pstmt.setString(2, st.getDescribe());
            pstmt.setString(3, st.getPrice());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String id) {
        String query = "delete from Product where id = ?";
        try {
            Connection connection = DBContext.DBContext();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void edit(String id, String des, String price) {
        String query = "UPDATE product SET des = ?, price = ? WHERE id=?";
        try {
            Connection connection = DBContext.DBContext();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, des);
            pstmt.setString(2, price);
            pstmt.setString(3, id);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Product getProductByCode(String id) {
        String query = "select *from product where id = ? ";
        try {
            Connection connection = DBContext.DBContext();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) {
        ProductDAO c = new ProductDAO();
        Product st = new Product("1111", "aaaaaaaaa", "12.3");
        c.add(st);


    }
}

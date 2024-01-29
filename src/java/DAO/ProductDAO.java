/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toden
 */
public class ProductDAO extends DAO {

    public ProductDAO() {
        super();
    }

    @Override
    public List<Product> getAllProduct() {
        String sql = "select * from Product_HE176693";
        List<Product> ProductList = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getNString(2);
                double price = rs.getDouble(3);
                int cid = rs.getInt(4);
                String img = rs.getString(5);
                int quantity = Integer.parseInt(rs.getString(6));
                ProductList.add(new Product(Id, name, price, cid, img, quantity));
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return ProductList;
    }

    @Override
    public List<Product> DelOneProduct(int id) {
        String sql = "Delete from Product_HE176693 where product_id = ?";
        List<Product> ProductList = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ProductList = getAllProduct();
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return ProductList;
    }

    @Override
    public Product getOnePro(int id) {
        String sql = "Select * from Product_HE176693 where product_id = ?";
        Product p = new Product();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getNString(2);
                double price = rs.getDouble(3);
                int cid = rs.getInt(4);
                String img = rs.getString(5);
                int quantity = rs.getInt(6);
                p = new Product(Id, name, price, cid, img, quantity);
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return p;
    }

    @Override
    public List<Product> addProduct(String name, double price, int cid, String img, int quantity) {
        String sql = "insert into Product_HE176693 values(?,?,?,?,?)";
        List<Product> ProductList = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, cid);
            ps.setString(4, img);
            ps.setInt(5, quantity);
            ps.executeUpdate();
            ProductList = getAllProduct();
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return ProductList;
    }

    @Override
    public List<Product> updateProduct(String name, double price, int cid, String img, int quantity, int pid) {
        String sql = "UPDATE [dbo].[Product_HE176693]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[category_id] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[quantity] = ?\n"
                + " WHERE product_id = ?";
        List<Product> ProductList = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, cid);
            ps.setString(4, img);
            ps.setInt(5, quantity);
            ps.setInt(6, pid);
            ps.executeUpdate();
            ProductList = getAllProduct();
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return ProductList;
    }

    @Override
    public List<Product> getProductByCate(int id) {
        String sql = "select * from Product_HE176693 where category_id = ?";
        List<Product> ProductList = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getNString(2);
                double price = rs.getDouble(3);
                int cid = rs.getInt(4);
                String img = rs.getString(5);
                int quantity = rs.getInt(6);
                ProductList.add(new Product(Id, name, price, cid, img, quantity));
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return ProductList;
    }

    @Override
    public List<Product> getProductByName(String productName) {
        try {
            String sql = "select *from Product_HE176693 where product_name like ?";
            List<Product> listPBN = new ArrayList<>();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getNString(2);
                double price = rs.getDouble(3);
                int cid = rs.getInt(4);
                String img = rs.getString(5);
                int quantity = Integer.parseInt(rs.getString(6));
                listPBN.add(new Product(Id, name, price, cid, img, quantity));
            }
            return listPBN;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}

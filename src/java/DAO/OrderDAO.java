/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cart;
import Model.Order;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toden
 */
public class OrderDAO extends DAO {

    public OrderDAO() {
        super();
    }

    @Override
    public void addOrder(int aid, List<Cart> carts) {
        double total = 0;
        for (Cart c : carts) {
            total += c.getPrice() * c.getAmmount();
        }
        String sql = "insert into Order_HE176693 values (?,?,?)";
        Date date = new Date();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, aid);
            ps.setDouble(3, total);
            ps.executeUpdate();
        } catch (Exception e) {
            status = "Error at addOrder " + e.getMessage();
        }

    }

    @Override
    public void addOrder(int aid, Product p) {
        String sql = "INSERT INTO [dbo].[Order_HE176693]\n"
                + "           ([order_date]\n"
                + "           ,[account_id]\n"
                + "           ,[product_id]\n"
                + "           ,[price]\n"
                + "           ,[total])\n"
                + "     VALUES (?,?,?,?,?)";
        Date date = new Date();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, aid);
            ps.setInt(3, p.getProductId());
            ps.setDouble(4, p.getListPrice());
            ps.setInt(5, 1);
            ps.executeUpdate();

        } catch (Exception e) {
            status = "Error at addOrder " + e.getMessage();
        }

    }

    @Override
    public int getNewestOrderId() {
        String sql = "select top 1 * from Order_HE176693 order by order_id desc";
        int id = 1;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            status = "Error at getNewestOrderId " + e.getMessage();
        }
        return id;
    }

    @Override
    public boolean addOrderDetail(List<Cart> carts) {
        String sql = "insert into OrderDetail values (?,?,?,?)";
        for (Cart c : carts) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, getNewestOrderId());
                ps.setInt(2, c.getProductId());
                ps.setInt(3, c.getAmmount());
                ps.setDouble(4, c.getPrice() * c.getAmmount());
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                status = "Error at addOrderDetail " + e.getMessage();
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addOrderDetail(Cart c) {
        String sql = "insert into OrderDetail values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getNewestOrderId());
            ps.setInt(2, c.getProductId());
            ps.setInt(3, c.getAmmount());
            ps.setDouble(4, c.getPrice() * c.getAmmount());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            status = "Error at addOrderDetail " + e.getMessage();

        }
        return false;
    }

    @Override
    public List<Order> getAllOrder() {
 try {
            List<Order> listO = new ArrayList<>();
            String sql = "SELECT [order_id]\n"
                    + "      ,[order_date]\n"
                    + "      ,[account_id]\n"
                    + "      ,[product_id]\n"
                    + "      ,[price]\n"
                    + "      ,[total]\n"
                    + "  FROM [dbo].[Order_HE176693]";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt(1));
                o.setOrderDate(rs.getDate(2));
                o.setAccount_id(rs.getInt(3));
                o.setProduct_id(rs.getInt(4));
                o.setPrice(rs.getDouble(5));
                o.setTotal(rs.getInt(6));
                listO.add(o);
            }

            return listO;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    } 

    @Override
    public void DelOneCart1(int aid, int pid) {
           String sql = "delete from Order_HE176693 where account_id = ? AND product_id = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setInt(2, pid);
            ps.executeUpdate();
            
        } catch (Exception e) {
            status = "Error at add Cart " + e.getMessage();
        }
    }
    

}

    


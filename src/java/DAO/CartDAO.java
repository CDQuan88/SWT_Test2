/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cart;
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
public class CartDAO extends DAO {

    public CartDAO() {
        super();
    }

    @Override
    public Cart getCardByAcAndP(int a, int p) {
        try {
            
            String sql = "SELECT [AccountId]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[ProductId]\n"
                    + "      ,[Image]\n"
                    + "      ,[Ammount]\n"
                    + "      ,[Price]\n"
                    + "  FROM [dbo].[Cart_HE176693] where AccountId =? AND ProductId=?  ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setInt(2, p);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cart c = new Cart();
                c.setAccountId(rs.getInt(1));
                c.setProductName(rs.getString(2));
                c.setProductId(rs.getInt(3));
                c.setImage(rs.getString(4));
                c.setAmmount(rs.getInt(5));
                c.setPrice(rs.getDouble(6));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Cart> getCartByAccount(int id) {
        String sql = "select c.AccountId, p.product_name, c.ProductId, p.quantity, p.img, p.list_price from Cart_HE176693 as c join Product_HE176693 as p on c.ProductId = p.product_id where c.AccountId = ?";
        List<Cart> CartList = new ArrayList<Cart>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt(1);
                String pName = rs.getString(2);
                int pid = rs.getInt(3);
                int ammount = rs.getInt(4);
                String img = rs.getString(5);
                double price = rs.getDouble(6);

                CartList.add(new Cart(aid, pName, pid, img, ammount, price));
            }
        } catch (Exception e) {
            status = "Error at read Cart " + e.getMessage();
        }
        return CartList;
    }

    @Override
    public List<Cart> addCart(int aid, int pid) {
        String sql = "insert into Cart_HE176693(AccountId,ProductId) values(?,?)";
        List<Cart> CartList = new ArrayList<Cart>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setInt(2, pid);
            ps.executeUpdate();
            CartList = getCartByAccount(aid);
        } catch (Exception e) {
            status = "Error at add Cart " + e.getMessage();
        }
        return CartList;
    }

    @Override
    public List<Cart> DelOneCart(int aid, int pid) {
        String sql = "delete from Cart_HE176693 where AccountId = ? AND ProductId = ? ";
        List<Cart> CartList = new ArrayList<Cart>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setInt(2, pid);
            ps.executeUpdate();
            CartList = getCartByAccount(aid);
        } catch (Exception e) {
            status = "Error at add Cart " + e.getMessage();
        }
        return CartList;
    }

    @Override
    public List<Cart> DelCartByAccountId(int aid) {
        String sql = "delete from Cart_HE176693 where AccountId = ? ";
        List<Cart> CartList = new ArrayList<Cart>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.executeUpdate();
            CartList = getCartByAccount(aid);
        } catch (Exception e) {
            status = "Error at add Cart " + e.getMessage();
        }
        return CartList;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
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
public class AccountDAO extends DAO {

    public AccountDAO() {
        super();
    }

    @Override
    public void updateAccount(String aname, String pass, String cusname, String phone, String address, int aid) {
        String sql = "UPDATE [dbo].[Account_HE176693]\n"
                + "   SET [account_name] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[customer_name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE account_id =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aname);
            ps.setString(2, pass);
            ps.setString(3, cusname);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setInt(6, aid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Account getAcByPhoneAEmail(String email, String phone,int check_id1,String answer1) {
        String sql = "select * from Account_HE176693 where email = ? AND phone =? AND check_id = ? AND answer = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setInt(3, check_id1);
            ps.setString(4, answer1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String accName = rs.getString(2);
                String password = rs.getString(3);
                String cusName = rs.getString(4);
                String phone1 = rs.getString(5);
                String address = rs.getString(6);
                int roleId = rs.getInt(8);
                int check_id = rs.getInt(9);
                String answer = rs.getString(10);
                acc = new Account(id, accName, password, cusName, phone1, address, email, roleId, check_id, answer);
                return acc;
            }
        } catch (Exception e) {
            status = "Error at findAccByEmail " + e.getMessage();
        }
        return null;

    }

    @Override
    public Account findAccByEmail(String email) {
        String sql = "select * from Account_HE176693 where email = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String accName = rs.getString(2);
                String password = rs.getString(3);
                String cusName = rs.getString(4);
                String phone = rs.getString(5);
                String address = rs.getString(6);
                int roleId = rs.getInt(8);
                int check_id = rs.getInt(9);
                String answer = rs.getString(10);
                acc = new Account(id, accName, password, cusName, phone, address, email, roleId, check_id, answer);
                return acc;
            }
        } catch (Exception e) {
            status = "Error at findAccByEmail " + e.getMessage();
        }
        return null;
    }

    @Override
    public Account addAcc(String account, String password, String customer, String phone, String address, String email, int check_id, String answer) {
        String sql = "INSERT INTO [dbo].[Account_HE176693]\n"
                + "           ([account_name]\n"
                + "           ,[password]\n"
                + "           ,[customer_name]\n"
                + "           ,[phone]\n"
                + "           ,[address]\n"
                + "           ,[email]\n"
                + "           ,[check_id]\n"
                + "           ,[answer])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        if (findAccByEmail(email) != null && findAccByEmail(email).getAccountId() > 0) {
            return null;
        }
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setNString(3, customer);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setInt(7, check_id);
            ps.setString(8, answer);
            ps.executeUpdate();
            return findAccByEmail(email);
        } catch (Exception e) {
            status = "Error at addAcc " + e.getMessage();
        }
        return null;
    }

    @Override
    public Account getOneAcc(int id) {
        String sql = "Select * from Account_HE176693 where account_id = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);
                int check_id = rs.getInt(9);
                String answer = rs.getString(10);

                acc = new Account(Id, name, pass, customerName, phone, address, email, roleId, check_id, answer);
            }
        } catch (Exception e) {
            status = "Error at getOneAcc " + e.getMessage();
        }
        return acc;
    }

    @Override
    public List<Account> getAllAccount() {
        String sql = "Select * From Account_HE176693";
        List<Account> AccList = new ArrayList<Account>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);
                int check_id = rs.getInt(9);
                String answer = rs.getString(10);
                AccList.add(new Account(Id, name, pass, customerName, phone, address, email, roleId, check_id, answer));
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return AccList;
    }

    @Override
    public int cusAccountExist(String email, String p) {
        String sql = "select a.account_id, a.email, a.password FROM Account_HE176693 as a "
                + "WHERE a.email = ? AND a.password = ?";
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return id;
    }

    @Override
    public Account findAccByName(String name, String p) {
        String sql = "select * from Account_HE176693 where account_name = ? and password = ?";
        Account acc = new Account();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Name = rs.getString(2);
                String pass = rs.getString(3);
                String customerName = rs.getString(4);;
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                int roleId = rs.getInt(8);
                int check_id = rs.getInt(9);
                String answer = rs.getString(10);
                acc = new Account(Id, Name, pass, customerName, phone, address, email, roleId, check_id, answer);
            }
        } catch (Exception e) {
            status = "Error at read Category " + e.getMessage();
        }
        return acc;
    }
}

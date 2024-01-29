/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBContext.DBContext;
import Model.Account;
import Model.Cart;
import Model.Category;
import Model.Check;
import Model.Order;
import Model.Product;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toden
 */
public class DAO {
    protected Connection con;
    protected String status="";
    public DAO(){
        try{
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status = "Error Connection "+e.getMessage();
        }
    }
    
    public void updateAccount(String aname ,String pass,String cusname,String phone ,String address ,int aid){
        
    }
    
    public List<Product> getAllProduct(){
        return null;
    }
    
    public List<Product> DelOneProduct(int id){
        return null;
    }
    
    public Product getOnePro(int id){
        return null;
    }
    
    public List<Product> addProduct(String name, double price, int cid, String img,int quantity){
        return null;
    }

    public List<Category> getAllCate() {
       return null;
    }
    
    public List<Account> getAllAccount(){
        return null;
    }
    
    public List<Product> getProductByName(String productName){
        
        return null;
        
    }
    
    public Account getAcByPhoneAEmail(String email,String phone,int check_id,String answer){
        
        return null;
        
    }
    public int cusAccountExist(String email, String p){
        return 0;
    }
    
    
    public Account getOneAcc(int id){
       return null;
    }
    
    public Account findAccByName(String name, String p){
        return null;
    }
    
   public List<Product> updateProduct(String name, double price, int cid, String img, int quantity,int pid){
        return null;
    }
    
    public List<Product> getProductByCate(int id){
        return null;
    }
    
    public List<Cart> getCartByAccount(int id){
         return null;
    }
    
    public void DelOneCart1(int aid, int pid)
    {}
            
    public List<Cart> addCart(int aid, int pid){
        return null;
    }
    
    public List<Cart> DelOneCart(int aid, int pid){
        return null;
    }
    
    public List<Cart> DelCartByAccountId(int aid){
        return null;
    }
    
    public int getNewestOrderId(){
        return 0;
    }
    
    public boolean addOrderDetail(List<Cart> carts){
        return false;
    }
    
    public void addOrder(int aid, List<Cart> carts){
       
    }
    
    public void addOrder(int aid, Product p){}
    
    public Cart getCardByAcAndP(int a,int p){
        return null;
    }
    
    public List<Order> getAllOrder(){
        return null;
    }
    
    public boolean addOrderDetail(Cart c){
        return false;
    }
    public Account findAccByEmail(String email){
        return null;
    }
            
    public Account addAcc(String account, String password, String customer, String phone, String address, String email,int check_id,String answer){
        return null;
    }
    
    public List<Check> getAllChecks(){
        return null;
    }
}

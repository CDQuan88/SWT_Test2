/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author toden
 */
public class Product {
    int productId;
    String productName;
    double listPrice;
    int CategoryId;
    String img;
    int quantity;

    public Product() {
    }

    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public Product(int productId, String productName, double listPrice, int CategoryId, String img,int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.listPrice = listPrice;
        this.CategoryId = CategoryId;
        this.img = img;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    

    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }
    
    
}

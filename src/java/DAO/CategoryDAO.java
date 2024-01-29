/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toden
 */
public class CategoryDAO extends DAO {
    public CategoryDAO(){
        super();
    }
    
     @Override
     public List<Category> getAllCate() {
        String sql = "select * from Category_HE176693";
        List<Category> CateList = new ArrayList<Category>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int Id = rs.getInt(1);
                String name = rs.getString(2);
                
                CateList.add(new Category(Id, name));
            }
        } catch (Exception e) {
            status = "Error at read Category "+e.getMessage();
        }
        return CateList;
    }
}

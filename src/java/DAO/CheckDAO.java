/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Check;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cao Duy Quân
 */
public class CheckDAO extends DAO {

    @Override
    public List<Check> getAllChecks() {
        try {
            List<Check> listC = new ArrayList<>();
            String sql = "SELECT [check_id]\n"
                    + "      ,[check_question]\n"
                    + "  FROM [dbo].[Check_HE176693]";
            
            PreparedStatement ps =con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {   
                Check c = new Check();
                c.setCheck_id(rs.getInt(1));
                c.setCheck_question(rs.getString(2));
                listC.add(c);
            }
            return listC;
        } catch (SQLException ex) {
            Logger.getLogger(CheckDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

}

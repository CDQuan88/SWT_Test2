/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cao Duy Quân
 */
public class Check {
   int check_id;
   String check_question;

    public Check(int check_id, String check_question) {
        this.check_id = check_id;
        this.check_question = check_question;
    }

    public Check() {
    }

    public int getCheck_id() {
        return check_id;
    }

    public void setCheck_id(int check_id) {
        this.check_id = check_id;
    }

    public String getCheck_question() {
        return check_question;
    }

    public void setCheck_question(String check_question) {
        this.check_question = check_question;
    }
   
    
}

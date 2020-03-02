package com.mycompany.myproject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDB {
    public static ArrayList<User> getAll(){
        String sql = "SELECT * FROM user";
        ArrayList<User> users = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String usrname = rs.getString("usrname");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String passwd = rs.getString("passwd");
                String phoneno = rs.getString("phoneno");
                User u = new User();
                u.setUsrname(usrname);
                u.setAge(age);
                u.setEmail(email);
                u.setPasswd(passwd);
                u.setPhoneno(phoneno);
                users.add(u);
            }
        }catch(SQLException e){
            System.out.println("Cant execute query!!");
        }
        return users;
    }  
    
    public static void delete(User user){
        try {
            String sql = "DELETE FROM user " + "WHERE email = '" + user.getEmail() + "'";
            Connection conn = DBUtil.getConn();
            
            Statement statement = conn.createStatement();
            int r = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

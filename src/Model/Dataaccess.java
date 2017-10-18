/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connection.Pgconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */

//metode que insereix un usuari
public class Dataaccess{
    Pgconnection pg=new Pgconnection();
    Connection con;
    List<User> userList=new ArrayList<User>();
    public boolean createUser(User user) throws SQLException{
        if(checkUser(user)){
            insertUser(user);
            return true;
        }
        return false;
    }
    
    
    public boolean insertUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
    
        String sql="insert into users (name,username,password) values(?,?,?,?)";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getPassword());
        stmt.setInt(4, user.getRole());
        stmt.executeUpdate();
        System.out.println("Record is inserted into DBUSER table!");
        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
        return true;  
    }
    
    
    
    public boolean modifyUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
        if(checkUser(user)){
        String sql="update users set name=?,password=?m role=? where username=?";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPassword());
        stmt.setInt(3, user.getRole());
        stmt.setString(4, user.getUsername());
        stmt.executeUpdate();
       
        }catch(Exception ex){
            return false;
        }
            return true;
        }
        return false;
    
    }
    
    public void deleteUser(User user) throws SQLException{
         String sql="delete from users where username="+"user.getUsername()";
          if(checkUser(user)){
               
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.executeUpdate();
       
        }catch(Exception ex){
            
        }
            
        }else{
            
        }
        
        
    }
    
    public void setRoleUser(User user, int role){
        if(role==1 || role==2){
         String query="insert into roles( values";
            try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(query);
                
        }catch (Exception ex){
                    
                    
         }        
            
        }
        
    }
       
    
    public boolean checkUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
        String query="select username from users where username=?";
       
        try{
        PreparedStatement stat=con.prepareStatement(query);
        stat.setString(1, user.getUsername());
        ResultSet rs=stat.executeQuery();
            System.out.println(stat.toString());
        if(rs.next()){
          if(rs.getString(1).matches(user.getUsername())) {   
           return true;}
           
        }
                
        }catch (Exception ex){
                    System.out.println(ex.getMessage());   
                    
         }        
        con.close();
        return false;
    }
    
    public boolean checkPass(User user){
        pg.connect();
        con=pg.getCon();
        String query="select password from users where username=?";
        try{
        PreparedStatement stat=con.prepareStatement(query);
        stat.setString(1, user.getUsername());
        ResultSet rs=stat.executeQuery();
        if(rs.next()){
          if(rs.getString(1).matches(user.getPassword())) {   
           return true;}
        }
                
        }catch (Exception ex){
                System.out.println(ex.getMessage());    
                    
         }        
        
        return false;
        
    }
    
    public int getId(){
        int id=-1;
        try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery("select user_id from users order by user_id desc limit 1");
        if(rs.next()){
            id=rs.getInt(1)+1;
        }
             
        }catch(Exception e){
                     System.out.println(e.getMessage());   
                }   
        return id;   
    }
    
    public int getUserId(User user){
        int user_id=0;
         try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery("select user_id from users where user=");
        if(rs.next()){
            user_id=rs.getInt(1)+1;
        }
             
        }catch(Exception e){
                     System.out.println(e.getMessage());   
                }   
        
        return user_id;
    }
    
    public List<User> userList(){
        pg.connect();
        con=pg.getCon();
        String query="select name,username from users";
        String name, username, password;
        int role;
        
        try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(query);
        while(rs.next()){
            name=rs.getString(1);
            username=rs.getString(2);
            password=rs.getString(3);
            role=rs.getInt(4);
            User u=new User(name,username,password,role);
            userList.add(u);
                        
        }
                           
        }catch (Exception ex){
                     System.out.println(ex.getMessage());   
                    
         }        
        
        return userList;
    }
    
}

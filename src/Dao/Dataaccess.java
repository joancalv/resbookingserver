/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.Pgconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joan
 */

//metode que insereix un usuari
public class Dataaccess extends Pgconnection{
    Connection con;
    public boolean createUser(Users user) throws SQLException{
        if(checkUser(user)){
            insertUser(user);
            return true;
        }
        return false;
    }
    
    
    public void insertUser(Users user){
           
        String sql="insert into ﻿users (name,username,password) VALUES(?,?,?)";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getPassword());
        stmt.execute();
        }catch(Exception ex){
            
        }
          
    }
    
    
    
    public void modifyUser(Users user){
        if(checkUser(user)){
                String sql="update users set name=?,password=? where username="+"user.getUsername()";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getPassword());
        stmt.executeUpdate();
       
        }catch(Exception ex){
            
        }
            
        }else{
            
        }
    
    
    }
    
    public void deleteUser(Users user){
        
          if(checkUser(user)){
                String sql="delete from users where username="+"user.getUsername()";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.executeUpdate();
       
        }catch(Exception ex){
            
        }
            
        }else{
            
        }
        
        
    }
    
    public void setRoleUser(Users user, int role){
        if(role==1 || role==2){
         String query="insert into roles( values";
            try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(query);
        if(rs.first()){
           return true;
        }
                
        }catch (Exception ex){
                    
                    
         }        
            
        }
        
    }
    
    public void removeRoleUser(){
        
        
    }      
    
    public boolean checkUser(Users user){
        String query="select username from users where username="+"user.getUsername()";
        
        try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(query);
        if(rs.first()){
           return true;
        }
                
        }catch (Exception ex){
                    
                    
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
                    
                }   
        return id;   
    }
    
    public int getUserId(Users user){
        int user_id=0;
         try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery("select user_id from users where user=");
        if(rs.next()){
            user_id=rs.getInt(1)+1;
        }
             
        }catch(Exception e){
                    
                }   
        
        return user_id;
    }
}

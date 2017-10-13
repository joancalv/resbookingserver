/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.Pgconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joan
 */

//metode que insereix un usuari
public class Dataaccess extends Pgconnection{
    Connection con;
    public void createUser(Users user) throws SQLException{
        String sql="insert into users VALUES(?,?,?)";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getPassword());
        stmt.execute();
    }
    
    
    public void modifyUser(){
    
    
    }
    
    public void deleteUser(){
        
        
    }
    
    public void setRoleUser(){
        
    }
    
    public void removeRoleUser(){
        
        
    }       
}

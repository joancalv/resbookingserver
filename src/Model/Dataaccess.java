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
 * Aquesta clase en l'encarregada de manipular direcmament les dades amb la base de dades, segon el paramatres que li arribin.
 * @author joan
 */


public class Dataaccess{
    Pgconnection pg=new Pgconnection();
    Connection con;
    List<User> userList=new ArrayList<User>();
//    public boolean createUser(User user) throws SQLException{
//        if(checkUser(user)){
//            insertUser(user);
//            return true;
//        }
//        return false;
//    }
    
    //Metode que insereix un usuari al base de dades a partir d'un objecte usuari
    public boolean insertUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
    
        String sql="insert into users (name,username,password) values(?,?,?,?,?)";
        try{
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getPassword());
        stmt.setInt(4, user.getRole());
        stmt.setInt(5,user.getState());
        stmt.executeUpdate();

        }catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
            return false;
        } finally { 
           con.close();
        }
        return true;  
    }
    
    
   // Modifica les dades d'un usuari que ja existeix 
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
            return true;
            }catch(Exception ex){
                 System.out.println(ex.getLocalizedMessage());
                return false;
            
                } finally { 
                   con.close();
                }
         
            }
                return false;
        
    
    }
    
  //Elimina el usuari de la base dades
    public boolean deleteUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
        String sql="delete from users where username=?";
            if(checkUser(user)){
               
                try{
            
                PreparedStatement stmt=con.prepareStatement(sql);
                stmt.setString(1, user.getUsername());
                stmt.executeUpdate();
                return true;
                }catch(Exception ex){
                    System.out.println(ex.getLocalizedMessage());
                }  finally { 
                con.close();
             }
            
        }
        
        return false;
    }
    //Modifica el rol d'un usuari
    public void setRoleUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
         String query="udpdate users set id_role=? where username=?";
            try{
        PreparedStatement stat=con.prepareStatement(query);
        stat.setInt(1, user.getRole());
        stat.setString(2, user.getUsername());
        
                
        }catch (Exception ex){
              System.out.println(ex.getLocalizedMessage());      
                    
         }    finally { 
              con.close();     
        }
        
    }
       
    //Comprova si el usuari existeix a la base de dades
    public boolean checkUser(User user) throws SQLException{
        pg.connect();
        con=pg.getCon();
        String query="select username from users where username=?";
       
        try{
            PreparedStatement stat=con.prepareStatement(query);
            stat.setString(1, user.getUsername());
            ResultSet rs=stat.executeQuery();
             if(rs.next()){
                if(rs.getString(1).matches(user.getUsername())) {   
                return true;}
           
            }
                
            }catch (Exception ex){
                    System.out.println(ex.getMessage());   
                    
             } finally { 
           con.close();
        }       
          return false;
    }
    //Comprova que el password proporcionat el es mateix de la base dades
    public boolean checkPass(User user) throws SQLException{
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
                    
         }  finally { 
           con.close();
        }      
        
        return false;
        
    }
//    Sense ús. Métodes que retornen la id i la darrera id donada
//    public int getId() throws SQLException{
//        int id=-1;
//        try{
//        Statement stat=con.createStatement();
//        ResultSet rs=stat.executeQuery("select user_id from users order by user_id desc limit 1");
//        if(rs.next()){
//            id=rs.getInt(1)+1;
//        }
//             
//        }catch(Exception e){
//                     System.out.println(e.getMessage());   
//                }  
//         finally { 
//           con.close();
//        }
//        return id;   
//    }
//    
//    public int getUserId(User user){
//        int user_id=0;
//         try{
//        Statement stat=con.createStatement();
//        ResultSet rs=stat.executeQuery("select user_id from users where user=");
//        if(rs.next()){
//            user_id=rs.getInt(1)+1;
//        }
//             
//        }catch(Exception e){
//                     System.out.println(e.getMessage());   
//                }   
//        
//        return user_id;
//    }
    //Retorna una llista amb tots els usuaris
    public List<User> userList() throws SQLException{
        pg.connect();
        con=pg.getCon();
        String query="select name,username,role,state from users";
        String name, username, password;
        int role,state;
        
        try{
        Statement stat=con.createStatement();
        ResultSet rs=stat.executeQuery(query);
        while(rs.next()){
            name=rs.getString(1);
            username=rs.getString(2);
            password=rs.getString(3);
            role=rs.getInt(4);
            state=rs.getInt(5);
            User u=new User(name,username,password,role,state);
            userList.add(u);
                        
        }
                           
        }catch (Exception ex){
                     System.out.println(ex.getMessage());   
                    
         }  finally { 
           con.close();
        }   
        
        return userList;
    }
    
}

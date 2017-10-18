/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author joan
 */
public class Pgconnection {
   Connection conn;
  public void connect(){
     
            String urlDatabase =  "jdbc:postgresql://192.168.150.180:5432/ajl"; 
            String user="postgres";
            String password="test";
                    
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase,user,password);
                System.out.println("Connection was succefully established=) ");
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
            
}
  
  
  public Connection getCon(){     
            return this.conn ;
}
    
}

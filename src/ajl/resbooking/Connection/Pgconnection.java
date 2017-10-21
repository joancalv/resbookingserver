<<<<<<< HEAD:src/ajl/resbooking/Connection/Pgconnection.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajl.resbooking.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Aquesta clase estableix una connexió amb una base de dades PostGresSQL
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
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
            
}
  
  
  public Connection getCon(){     
            return this.conn ;
}
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Aquesta clase estableix una connexió amb una base de dades PostGresSQL
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
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
            
}
  
  
  public Connection getCon(){     
            return this.conn ;
}
    
}
>>>>>>> 25b2dadb72e33e9f8033a70ba6ab3f62fada7695:src/Connection/Pgconnection.java

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
    
  public void connect(){
    Connection conn = null;
            String urlDatabase =  "jdbc:postgresql://nyrxhbqi:46QZohznk4JbTbPCDwX-ZT-5_xtQ2hYg@horton.elephantsql.com:5432/nyrxhbqi"; 
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase);
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
            System.out.println("Connection was succefully established=) ");
}
    
}

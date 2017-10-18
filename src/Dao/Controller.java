/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */
public class Controller {
    Dataaccess acces;
    List<Users> users=new ArrayList<Users>();
    
//Comrpovem que pot fer login, primer comprovem si el usuari existeix, i despres comprovem la contrasenya    
    public boolean login(Users user) throws SQLException{
        acces=new Dataaccess();
        if(acces.checkUser(user)){
                if(acces.checkPass(user)){
                return true;
            }
        }
       
        return false;
    }
    //Comprovem que no existeix a la base dades, sino existeix el creem
    public boolean newUser(Users user) throws SQLException{
        acces=new Dataaccess();
        if(acces.insertUser(user)){
            return true;
        }else{
            return false;
        }
    }
    //Comprovem que esta el usuari, i el modifiquem.
        public boolean modifyUser(Users user) throws SQLException{
        acces=new Dataaccess();
        if(acces.modifyUser(user)){
            return true;
        }else{
            return false;
        }
    }
        
      //Comprovem que existeix el usuari abans de borrarlo.
        public boolean deleteUser(Users user) throws SQLException{
        acces=new Dataaccess();
        if(!acces.checkUser(user)){
            acces.deleteUser(user);
            return true;
        }else{
            return false;
        }
    }   
        
     public List<Users> listUser(){
         acces=new Dataaccess();
         users.addAll(acces.userList());
         return users;
     }      
        
      
}

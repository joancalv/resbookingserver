/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */
public class Controller {
    Dataaccess acces;
    List<User> users=new ArrayList<User>();
    
//Comrpovem que pot fer login, primer comprovem si el usuari existeix, i despres comprovem la contrasenya    
    public boolean login(User user) throws SQLException{
        acces=new Dataaccess();
        if(acces.checkUser(user)){
                if(acces.checkPass(user)){
                return true;
            }
        }
       
        return false;
    }
    //Comprovem que no existeix a la base dades, sino existeix el creem
    public boolean newUser(User user) throws SQLException{
        acces=new Dataaccess();
        if(acces.insertUser(user)){
            return true;
        }else{
            return false;
        }
    }
    //Comprovem que esta el usuari, i el modifiquem.
        public boolean modifyUser(User user) throws SQLException{
        acces=new Dataaccess();
        if(acces.modifyUser(user)){
            return true;
        }else{
            return false;
        }
    }
        
      //Comprovem que existeix el usuari abans de borrarlo.
        public boolean deleteUser(User user) throws SQLException{
        acces=new Dataaccess();
        if(!acces.checkUser(user)){
            acces.deleteUser(user);
            return true;
        }else{
            return false;
        }
    }   
        
     public List<User> listUser(){
         acces=new Dataaccess();
         users.addAll(acces.userList());
         return users;
     }      
        
      
}

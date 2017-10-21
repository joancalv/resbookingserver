<<<<<<< HEAD:src/ajl/resbooking/Model/Controller.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajl.resbooking.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta clase s'encarrega de cridar el métdoes que manipulen directamente la base de dades.
 * Si ha pogut efectuar la operació retorn verdader sino fals.
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
        
     public List<User> listUser() throws SQLException{
         acces=new Dataaccess();
         users.addAll(acces.userList());
         return users;
     }      
        
      
}
=======
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
 * Aquesta clase s'encarrega de cridar el métdoes que manipulen directamente la base de dades.
 * Si ha pogut efectuar la operació retorn verdader sino fals.
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
        
     public List<User> listUser() throws SQLException{
         acces=new Dataaccess();
         users.addAll(acces.userList());
         return users;
     }      
        
      
}
>>>>>>> 25b2dadb72e33e9f8033a70ba6ab3f62fada7695:src/Model/Controller.java

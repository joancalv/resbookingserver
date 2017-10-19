/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerConection;

import Model.User;
import java.io.Serializable;
import java.util.List;

/**
 * Classe que crea el Paquet de Dades. Te diferents constructors per poder encapsular els
 * diferents grups de dades. El primer valor sempre correspon a l'ordre que ha de realitzar el servidor
 * i va acompanyat de les dades necessaries perque ho realitzi
 * @author Alfons
 */
public class PaquetDades implements Serializable{
    
    private int numOperacio;
    private User usuaris;
    private boolean isTrue;
    private static final long serialVersionUID = -832217726;
    private List<User> userList;

    
    /**
     * 
     * @param numOperacio Ordre que ha de realitzar el servidor
     * @param usuaris Un usuari del sistema
     */
   public PaquetDades(int numOperacio, User usuaris){
     this.numOperacio=numOperacio;   
     this.usuaris=usuaris;
    }
   /**
    * 
    * @param numOperacio Ordre que ha de realitzar el servidor
    * @param isTrue 
    */
   public PaquetDades(int numOperacio, boolean isTrue){
     this.numOperacio=numOperacio;   
     this.isTrue=isTrue;
    }
   
   /**
    * 
    * @param numOperacio Ordre que ha de realitzar el servidor
    */
   public PaquetDades(int numOperacio){
     this.numOperacio=numOperacio;   
     this.isTrue=isTrue;
    }
   /**
    * 
    * @param numOperacio Ordre que ha de realitzar el servidor
    * @param userList Llista de tots els Usuaris
    */
   public PaquetDades(int numOperacio,List<User> userList ){
     this.numOperacio=numOperacio;   
     this.userList=userList;
    }

    public int getNumOperacio() {
        return numOperacio;
    }

    public void setNumOperacio(int numOperacio) {
        this.numOperacio = numOperacio;
    }

    public User getUsuaris() {
        return usuaris;
    }

    public void setUsuaris(User usuaris) {
        this.usuaris = usuaris;
    }
    
    public boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

  public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}

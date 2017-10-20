/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Es la clase on definim el usuari amb el seu constructor
 * @author joan
 */
public class User {
    
  String name;
  String username;
  String password;
  int role;
  int state;

  
   public User(String name, String username, String password, int role, int state){
     this.name=name;
     this.username=username;   
     this.password=password;
     this.role=role;
     this.state=role;
    }
   
     public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

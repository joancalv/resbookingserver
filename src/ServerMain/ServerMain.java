/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerMain;

import ServerConection.RebreDades;

/**
 * Classe principal del servidor on es crea el fil que espera les peticions
 * @author Alfons
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RebreDades escoltant=new RebreDades();
        escoltant.start();
    }
    
}

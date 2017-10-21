/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajl.resbooking.ServerConection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Classe que s'encarrega d'enviar dades a traves d'un Socket
 * @author Alfons
 */
public class EnviarDades {
    
    private String ipDesti; 
    private int portEscoltaDesti;
    
    public EnviarDades(String ip, int portEscoltaDesti){
        this.ipDesti=ipDesti;
        this.portEscoltaDesti=portEscoltaDesti;
        
    }
    
    /**
     * Metode que permet enviar les dades
     * @param paquetDades, Les dades s'encapsularan dins de l'objecte PaquetDades
     */
    public void enviarDades(PaquetDades paquetDades){
      
        try {
            Socket client=new Socket(ipDesti, portEscoltaDesti);
            ObjectOutputStream out=new ObjectOutputStream (client.getOutputStream());
            out.writeObject(paquetDades);
            client.close();

        } catch (IOException ex) {
            System.out.println("Error al client "+ex);
        }
 
    }
    
}

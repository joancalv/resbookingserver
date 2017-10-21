/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajl.resbooking.ServerConection;

import ajl.resbooking.Model.Controller;
import ajl.resbooking.Model.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que crea un fil que resta permanentment a l'espera de noves connexions dels clients.
 * Quan es crea la petició, identifica el numero d'ordre, l'executa i retorna una resposta.
 * @author Alfons
 */
public class RebreDades extends Thread{
    
    private PaquetDades paquetDades;
    private PaquetDades paquetResposta;
    private boolean isOperationCompleated=false;
   
    private int portEscoltaServidor=7070;
    private int portEscoltaClient=7777;
    private String IPServidor="localhost";
    private String IPClient="localhost";
    
       
    public void run(){

        try {
            Controller c=new Controller();
            ServerSocket servidor=new ServerSocket(portEscoltaServidor);
             
            while (true){

                System.out.println("Esperant");
                Socket s=servidor.accept();
                System.out.println("in..");
                ObjectInputStream in=new ObjectInputStream (s.getInputStream());
                System.out.println("apunt de llegir dades..");
                System.out.println("creem un objecte");
                PaquetDades paquetDades=(PaquetDades)in.readObject();;
                //PaquetDades paquetDades=(PaquetDades)in.readObject();
                System.out.println("Hem rebut les dades");
                int numOperacio=paquetDades.getNumOperacio();
                System.out.println("num operacio: "+ numOperacio);
                
                Socket client=new Socket(IPClient, portEscoltaClient);
                ObjectOutputStream out=new ObjectOutputStream (client.getOutputStream());
                
                switch(numOperacio){
                    case 1://Usuari potConectar-se
                        Boolean isLog=c.login(paquetDades.getUsuaris());  
                        paquetResposta=new PaquetDades(1, isLog);
                        out.writeObject(paquetResposta);
                        client.close();
  
                    case 2://obtenir Llista Usuaris
                        System.out.println("Obtenim dades client"+servidor.getInetAddress()+" , "+servidor.getLocalPort());
                        System.out.println("Estem al case 2");
                        List<User> llistaUsuaris=c.listUser();
                        System.out.println("longitud llista?: "+llistaUsuaris.size());
                        paquetResposta=new PaquetDades(2, llistaUsuaris);
                        System.out.println("Enviem dades de resposta");
                        out.writeObject(paquetResposta);
                        client.close();
                        System.out.println("fi");
                        
                    case 3://actualitzar Usuari
                        isOperationCompleated=c.modifyUser(paquetDades.getUsuaris());
                        paquetResposta=new PaquetDades(3,isOperationCompleated);
                        out.writeObject(paquetResposta);
                        client.close();
                        
                    case 4://afegir Usuari
                        isOperationCompleated=c.newUser(paquetDades.getUsuaris());
                        paquetResposta=new PaquetDades(3,isOperationCompleated);
                        out.writeObject(paquetResposta);
                        client.close();
                        
                    case 5://desactivar Usuari
                        //ToDO, crec que al controller falta el metode per modificar el rol del usuari 

                }

            }
        } catch (IOException ex) {
            System.out.println("Error al server "+ex);
            Logger.getLogger(RebreDades.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al server "+ex);
            Logger.getLogger(RebreDades.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            System.out.println("Error al server "+ex);
            Logger.getLogger(RebreDades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


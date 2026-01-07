/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author giova
 */
public class ReceptorUDP {
    public static void main(String[] args){
        
        int puerto = 5001;
        
        try{
            // Abrir socket UDP en el puerto
            DatagramSocket receptor = new DatagramSocket(puerto);
            System.out.println("Receptor EDP escuchando en el puerto "+ puerto + "...");
            
            // Preparar buffer y paquete
            byte[] buffer = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            
            // Recibir el mensaje
            receptor.receive(paquete);
            
            // Convertir mensaje a String
            String mensaje = new String(
            paquete.getData(),
                    0,
                    paquete.getLength()
            );
            
            System.out.println("Mensaje recibido: "+ mensaje);
            
            // Cerrar socket
            receptor.close();
            
        } catch (IOException ex) {
            System.out.println("Error en el receptor UDP");
            ex.printStackTrace();
        }
        
    }
}

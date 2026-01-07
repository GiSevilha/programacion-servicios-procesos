package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EmisorUDP {
    public static void main(String[] args) {
        
        int puerto = 5001;
        String mensaje = "Hola UDP";
        
        try {
            // Abrir el socket UDP
            DatagramSocket emisor = new DatagramSocket();
            
            // Obtener dirección IP del receptor
            InetAddress direccion = InetAddress.getByName("localhost");
            
            // Convertir mensaje a bytes
            byte[] datos = mensaje.getBytes();
            
            // Crear paquete UDP
            DatagramPacket paquete = new DatagramPacket(
            datos,
            datos.length,
            direccion,
            puerto);
            
            // Enviar paquete
            emisor.send(paquete);
            System.out.println("Mensaje enviado: " + mensaje);
            
            // Cerrar socket
            emisor.close();
            
            
        } catch (IOException e) {
            System.out.println("Error en el emisor");
            e.printStackTrace();
        }
    }
}

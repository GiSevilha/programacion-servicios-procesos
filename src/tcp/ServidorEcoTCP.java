package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ServidorEcoTCP {
    public static void main(String[] args){
        
        int puerto = 5000;
        
        try{
            // crear el servidor y abrir el puerto
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor eco escuchando en el puerto " + puerto + "...");
            
            // esperar a que un cliente se conecte
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            // leer mensaje del cliente
            BufferedReader entrada = new BufferedReader(
            new InputStreamReader(cliente.getInputStream())
            );
            
            // enviar mensaje al cliente
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            
            // leer mensaje del cliente
            String mensaje = entrada.readLine();
            System.out.println("Mensaje recibido: " + mensaje);
            
            // Enviar eco (devolver el mismo mensaje)
            salida.println(mensaje);
            
            // Cerrar recursos
            entrada.close();
            salida.close();
            cliente.close();
            servidor.close();
            
            System.out.println("Servidor cerrado");
        } catch (IOException e) {
            System.out.println("Error en el servidor");
            e.printStackTrace();
        }
    }
}

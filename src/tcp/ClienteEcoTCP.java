package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteEcoTCP {
    public static void main(String[] args) {
        
        String servidor = "localhost";
        int puerto = 5000;
        
        try {
            
            // conectar al servidor
            Socket socket = new Socket(servidor, puerto);
            System.out.println("Conectado al servidor");
            
            // flujo de salida (enviar mensaje)
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            
            // flujo de entrada (recibir respuesta)
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Mensaje a enviar
            String mensaje = "Hola servidor";
            System.out.println("Enviando: " + mensaje);
            salida.println(mensaje);
            
            // recibir eco del servidor
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
            
            // cerrar recursos
            entrada.close();
            salida.close();
            socket.close();
            
        } catch (IOException e) {
            System.getLogger("Error en el cliente");
            e.printStackTrace();
        }
    }
}

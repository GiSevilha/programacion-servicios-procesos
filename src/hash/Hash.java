
package hash;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Hash {
    public static void main(String[] args) {
        
        try {
            // paso 1: crear la llave
            KeyGenerator generador = KeyGenerator.getInstance("AES");
            generador.init(128); // tamaño de la llave
            SecretKey miLlave = generador.generateKey();

            // paso 2: crear el objeto motor
            Cipher motor = Cipher.getInstance("AES");

            // paso 3: configurar el motor para CIFRAR
            String mensaje = "Este es un secreto de examen";

            // le digo al motor que se prepare para encriptar
            motor.init(Cipher.ENCRYPT_MODE, miLlave);

            // paso 4: ejecutar la transformación. Encripto el mensaje
            byte[] mensajeCifrado = motor.doFinal(mensaje.getBytes());

            System.out.println("Mensaje ilegible: " + new String(mensajeCifrado));

            // Descifrar

            // Primero preparo el motor para descifrar
            motor.init(Cipher.DECRYPT_MODE, miLlave);

            byte[] textoDescifrado = motor.doFinal(mensajeCifrado);
            System.out.println("Descifrado: " + new String(textoDescifrado));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

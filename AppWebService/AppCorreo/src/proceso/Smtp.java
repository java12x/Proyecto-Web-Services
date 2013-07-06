package proceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Smtp {

    public static void enviar(String correo, String host, String msgSub) {
        try {

            new EnviadorMail(host, 465, "jarauzosinaga@gmail.com", "java12xx", correo, "Respuesta Sistema", msgSub);
            System.out.println("Respuesta enviada a <" + correo + ">: " + msgSub);
        } catch (Exception ex) {
        }
    }

    public static void main(String agrs[]) {
        Smtp.enviar("jarauzosinaga@gmail.com", "smtp.gmail.com", "prueba de mensaje");
    }
}

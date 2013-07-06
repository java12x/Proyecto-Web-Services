package proceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Pop3 implements Runnable {

    private String user;
    private String pass;
    private String host;
    private PrintWriter pw;
    private BufferedReader br;

    public Pop3(String host, String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.host = host;
        //run();
    }

    public void run() {
        SSLSocket socket = null;
        SSLSocketFactory factory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        Procesar procesar = new Procesar("ayuda");
        while (true) {
            String correo = "";
            try {
                String msg = "";
                socket = (SSLSocket) factory.createSocket(host, 995);

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.println(leerServer(br));

                pw.flush();
                pw.println("user " + user);
                pw.flush();
                System.out.println(leerServer(br));
                pw.println("pass " + pass);
                pw.flush();
                System.out.println(leerServer(br));

                System.out.print("Revisando...");
                Thread.sleep(2000);
                pw.println("stat");

                pw.flush();
                int cant = cantidad(br.readLine());
                System.out.println(cant + " mensajes nuevos");
                for (int i = 1; i <= cant; i++) {
                    pw.println("retr " + i);
                    pw.flush();
                    String data;
                    String subject = "";


                    boolean su = false;
                    boolean fr = false;
                    do {
                        data = br.readLine();
                        msg += data;
                        System.out.println(data);
                        if (data.indexOf("Subject:") != -1) {
                            subject = data;
                            su = true;
                        } else if (data.indexOf("From:") != -1) {
                            correo = data;
                            fr = true;
                        }
                    } while (!data.equals("."));
                    System.out.println("en el pop3");
                    try {
                        msg = msg.substring(msg.indexOf("<comando>"), msg.indexOf("</comando>")).substring(9).trim();
                        correo = correo.substring(correo.indexOf("<") + 1, correo.indexOf(">"));
                        System.out.println("recibido de " + correo);
                        subject = mensaje(subject);
                        procesar = new Procesar(msg);
                        Smtp.enviar(correo, host, procesar.procesar());
                    } catch (Exception e) {
                        Smtp.enviar(correo, "smtp.gmail.com", procesar.procesar());
                    }
                }
                for (int j = 1; j <= cant; j++) {
                    pw.println("dele " + j);
                    pw.flush();
                    br.readLine();
                }
                pw.println("quit");
                pw.flush();
                pw.close();
                br.close();
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Pop3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pop3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private int cantidad(String linea) {
        String aux = linea.trim();
        aux = aux.substring(aux.indexOf(" "), aux.length());
        aux = aux.trim();
        aux = aux.substring(0, aux.indexOf(" "));
        return Integer.parseInt(aux);
    }

    private String mensaje(String linea) {
        String aux = linea.trim();
        aux = aux.substring(aux.indexOf(":") + 1, aux.length());
        aux = aux.trim();
        return aux;
    }

    private String leerServer(BufferedReader In) throws IOException {
        String Datos = null, userInput = "";

        do {
            userInput = In.readLine();
            if (Datos == null) {
                Datos = userInput;
            } else {
                Datos = Datos + "\n" + userInput;
            }
        } while (In.ready());

        return Datos;
    }

    public static void main(String[] args) {
        Pop3 p = new Pop3("pop.gmail.com", "jarauzosinaga@gmail.com", "java12xx");
        Thread t = new Thread(p);
        t.start();
    }
}

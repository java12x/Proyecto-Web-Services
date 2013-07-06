/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

/**
 *
 * @author Daniela
 */
public class EnviadorMail {

    public EnviadorMail(String servidor, int puerto, String remitente, String contrasenia, String destinatario, String asunto,
            String cuerpo) {

        Properties props = new Properties();
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.host", servidor);
        props.put("mail.smtp.port", puerto);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", puerto);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new autentificadorSMTP(remitente, contrasenia);
            Session session = Session.getInstance(props, auth);
            // session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(remitente));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    destinatario));
            Transport.send(msg);
        } catch (Exception mex) {
//            mex.printStackTrace();
        }

    }

    private class autentificadorSMTP extends javax.mail.Authenticator {

        private String remitente;
        private String contrasenia;

        public autentificadorSMTP(String remitente, String contrasenia) {
            this.remitente = remitente;
            this.contrasenia = contrasenia;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remitente, contrasenia);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EnviadorMail EnviadorMail = new EnviadorMail("smtp.gmail.com", 465, "jarauzosinaga@gmail.com",
                "java12xx", "hectorcarballo.hco@gmail.com", "Este es el asunto de mi correo", "Este es el cuerpo de mi correo");
    }
}

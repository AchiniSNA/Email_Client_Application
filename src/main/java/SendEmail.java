import java.io.Serializable;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;



public class SendEmail implements Serializable {
    private String address;   
    private String subject;
    private String body;
    public String date;
    final String username = "asanjnam1999@gmail.com";
    final String password = "aihrkzfkrzwdekjl";
    final String SMTPserver = "smtp.gmail.com";
    final String ServerPort = "587";
    public DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public SendEmail(String address, String subject, String body) {
        this.address = address;
        this.subject = subject;
        this.body = body;

        Properties prop = new Properties();
        prop.put("mail.smtp.user", username);
        prop.put("mail.smtp.host", SMTPserver);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "587");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator authenticator = new SMTPAuthenticator();
            Session session = Session.getInstance(prop, authenticator);

            Message message = new MimeMessage(session);
            message.setText(body);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(address));
            Transport.send(message);
            System.out.println("Send successfully.");
        } catch (Exception e) {
            System.err.println("Error occurred." + e);
        }

    }
    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
    
}

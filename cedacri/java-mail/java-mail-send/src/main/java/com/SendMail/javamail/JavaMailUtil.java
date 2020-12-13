package com.SendMail.javamail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Transport.send;

public class JavaMailUtil {
    public static void sendMail(String recepient) throws Exception
    {
        System.out.println("Preparing sent email");
        Properties properties = new Properties();

        //настройки для подключение к почте
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        properties.put("mail.smtp.port","587");//порт gmail почты

        //Мыло, пароль
        String myAccountEmail ="stefanboblic@gmail.com"; 
        String password = "*******"; 

       
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });

        
        Message message = prepareMessage(session,myAccountEmail,recepient);

        send(message);
        System.out.println("Message sent succesfull");
    }


    
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Timo mail");
            message.setContent("<img src=\"https://avatarfiles.alphacoders.com/858/85848.gif\">", "text/html");
            return message;
        }catch (Exception exception)
        {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,exception);
        }
        return null;
     }




}

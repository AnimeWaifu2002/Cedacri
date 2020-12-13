package com.example.jdbc;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Message;

public class JDBCDemo {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL="jdbc:mysql://localhost:3306/Postavka?useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    static final String USER="Stefan";
    static final String PASSWORD="2002";

    public static void main(String[]args)
            throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        System.out.println("Registration of JDBC driver");
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        System.out.println("Executing...");
        statement=connection.createStatement();

        String sql;
        sql = "SELECT * FROM Zakazchik";

        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("\nZakazchik:");
        while(resultSet.next())
        {
            String cod = resultSet.getString("cod_zakaz");
            String nameZ = resultSet.getString("Nazv_zakaz");
            String Adress = resultSet.getString("Adress");
            String Telefon=resultSet.getString("Telefon");

            System.out.println("\n=====================");

            System.out.println("cod_zakaz:\t" + cod);
            System.out.println("Nazv_zakaz:\t" + nameZ);
            System.out.println("Adress:\t" + Adress);
            System.out.println("Telefon:\t" + Telefon);
        }

        System.out.println("Closing connection");
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("Preparing sent email");
        Properties properties = new Properties();

        //настройки для подключение к почте
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust","smtp.gmail.com");//это свойство позволяет мне запустить связь с почтой через ssl протокол.
        properties.put("mail.smtp.port","587");//порт gmail почты

        //Мыло, пароль
        String myAccountEmail ="stefanboblic@gmail.com"; //input here Email
        String password = "Tedy2002"; //input here pw

        //Создаем сессию-аутентификаю, которое возращает значение пароля, мыла.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });

        //Создаётся связь с тем, кому мы отправляем письмо. Для этого нам надо подробнее описать метод prepareMessage
        Message message = prepareMessage(session,myAccountEmail,recepient);

        send(message);
        System.out.println("Message sent succesfull");
    }


    //Создается метод prepareMessage
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My second  Email");
            message.setText("How lovely to talk to yourself <ЗЗЗЗЗЗ");
            return message;
        }catch (Exception exception)
        {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,exception);
        }
        return null;
     }
    }
}

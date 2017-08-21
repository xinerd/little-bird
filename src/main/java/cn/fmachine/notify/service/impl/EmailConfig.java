package cn.fmachine.notify.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Author: shin
 * Date: 8/19/17
 */
@Configuration
public class EmailConfig {


    @Value("${email.host}")
    private String host;

    @Value("${email.port}")
    private String port;

    @Value("${email.socketFactoryPort}")
    private String socketFactoryPort;

    @Value("${email.auth}")
    private String auth;

    @Value("${email.socketFactoryClass}")
    private String socketFactoryClass;

    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    @Bean
    public Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.socketFactory.port", socketFactoryPort);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.socketFactory.class", socketFactoryClass);
        return props;
    }

    @Bean
    public Session getSession() {
        return Session.getDefaultInstance(getProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }
}

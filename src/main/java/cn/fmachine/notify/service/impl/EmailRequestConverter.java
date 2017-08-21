package cn.fmachine.notify.service.impl;

import cn.fmachine.notify.model.EmailSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Author: shin
 * Date: 8/19/17
 */
@Component
public class EmailRequestConverter {

    @Autowired
    private Session session;

    @Value("${email.username}")
    private String username;

    public Message emailSpecToMsg(EmailSpec spec) throws MessagingException {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
                        formatRecipients(spec.getRecipients())));
        msg.setSubject(spec.getSubject());
        msg.setText(spec.getText());
        return msg;
    }

    private String formatRecipients(List<String> recipients) {
        return recipients.stream().reduce("", (a, b) -> a + "," + b).substring(1);
    }
}

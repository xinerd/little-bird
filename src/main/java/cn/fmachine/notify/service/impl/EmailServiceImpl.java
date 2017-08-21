package cn.fmachine.notify.service.impl;

import cn.fmachine.notify.model.EmailSpec;
import cn.fmachine.notify.model.Reply;
import cn.fmachine.notify.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

/**
 * Author: shin
 * Date: 8/19/17
 */
@Component
public class EmailServiceImpl implements IEmailService {


    @Autowired
    private EmailRequestConverter emailRequestConverter;

    @Override
    public Reply send(EmailSpec spec) {
        Reply reply = new Reply();
        try {
            Message msg = emailRequestConverter.emailSpecToMsg(spec);
            Transport.send(msg);
            reply.setStatus("SUC");
        } catch (MessagingException e) {
            reply.setStatus("FAILED");
            e.printStackTrace();
        }
        return reply;
    }
}

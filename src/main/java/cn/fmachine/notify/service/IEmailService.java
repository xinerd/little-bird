package cn.fmachine.notify.service;

import cn.fmachine.notify.model.EmailSpec;
import cn.fmachine.notify.model.Reply;
import org.springframework.stereotype.Service;

/**
 * Author: shin
 * Date: 8/16/17
 */
@Service
public interface IEmailService {

    Reply send(EmailSpec spec) throws Exception;
}

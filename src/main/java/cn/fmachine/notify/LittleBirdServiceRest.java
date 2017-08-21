package cn.fmachine.notify;

import cn.fmachine.notify.model.EmailSpec;
import cn.fmachine.notify.model.Reply;
import cn.fmachine.notify.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: shin
 * Date: 8/19/17
 */
@RestController
public class LittleBirdServiceRest {

    @Autowired
    private EmailServiceImpl eBird;

    @RequestMapping(value = "/email", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Reply> search(@RequestBody EmailSpec spec) {
        Reply reply = eBird.send(spec);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResponseEntity<Reply> test(@RequestBody EmailSpec spec) {
        Reply reply = eBird.send(spec);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }
}

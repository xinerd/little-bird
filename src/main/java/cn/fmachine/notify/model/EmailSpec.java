package cn.fmachine.notify.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Author: shin
 * Date: 8/19/17
 */
@Data
@Builder
public class EmailSpec {

    private List<String> recipients;

    private String subject;

    private String text;

    private Protocol protocol;

    private enum Protocol {
        TLS, SSL
    }

}

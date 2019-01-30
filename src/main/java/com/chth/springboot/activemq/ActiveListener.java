package com.chth.springboot.activemq;

import com.chth.springboot.activemq.common.ActiveQueueUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author: 程泰恒
 * @date: 2019/1/30 9:31
 */
@Component
public class ActiveListener {

    @JmsListener(destination = ActiveQueueUtils.MESSAGE_TRANSMIT)
    public void getMessage(TextMessage textMessage) throws JMSException {
        System.out.println("=================message info :" + textMessage.getText());
    }

}

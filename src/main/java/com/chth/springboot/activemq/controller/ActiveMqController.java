package com.chth.springboot.activemq.controller;

import com.chth.springboot.activemq.common.ActiveQueueUtils;
import com.google.common.collect.Maps;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Message;
import java.util.Map;

/**
 * @author: 程泰恒
 * @date: 2019/1/30 10:55
 */

@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 向队列发送延迟信息
     * @param delayTime 延迟时间（毫秒）当为0或者负数的时候没有延迟
     * @param message 要发送的信息
     * @return
     */
    @GetMapping("/send-message")
    public Map sendMessage(@RequestParam("message") String message,@RequestParam("delayTime") Long  delayTime) {
        Map<Object, Object> map = Maps.newHashMap();
        jmsTemplate.send(ActiveQueueUtils.MESSAGE_TRANSMIT, session -> {
            Message jmsMessage = session.createTextMessage(message);
            jmsMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayTime);
            return jmsMessage;
        });
        map.put("message", message);
        return map;

    }
}

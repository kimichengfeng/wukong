package com.whitehorse.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * 消费者程序
 * 一定要注意实现MessageListener，我们只需要获取message的body即可，通过json来转换我们需要的程序（比如我们可以发送一个map，map存放方法和实体，这样我们可以通过反射来调用不同的程序来运行）。
 */
public class SpittleAlertHandler implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String body = new String(message.getBody(), "UTF-8");
            System.out.println(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

package com.whitehorse.rabbitMQ;

import org.springframework.context.ApplicationContext;

public class ConsumerMain {
    static ApplicationContext context = null;

    /**
     * @param args
     */
    public static void main(String[] args) {
        context  = new org.springframework.context.support.ClassPathXmlApplicationContext("amqp/amqp-consumer.xml");
    }
}

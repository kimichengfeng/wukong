package com.whitehorse.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 生产者程序
 * 其中convertAndSend方法默认第一个参数是交换机名称，第二个参数是路由名称，第三个才是我们发送的数据
 */
public class ProducerMain {
    private static ApplicationContext context;
    public static void main(String[] args) throws InterruptedException {
        context = new ClassPathXmlApplicationContext("amqp/amqp-producer.xml");
        AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");
        for (int i = 0; i < 10; i++) {
            System.out.println("Sending message #" + i);
            Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
            template.convertAndSend(spittle);
            Thread.sleep(3000);
        }
        System.out.println("Done!");
    }
}

package sg.com.msiglobal.mqconsumer;


import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
public class ActiveMQConfig {


    @Bean
    public JmsTemplate jmsTemplate() throws Exception{
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        //jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        return jmsTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        /*10.130.1.23*//*6yhnji9^*/
        /*tcp://192.168.0.221:61616*/
        /*5tgb6yhn*/

        activeMQConnectionFactory.setBrokerURL("tcp://10.130.1.23:61616");
        activeMQConnectionFactory.setUser("amqadmin");
        activeMQConnectionFactory.setPassword("6yhnji9^");
        //activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.mailshine.springbootstandaloneactivemq"));
        return  activeMQConnectionFactory;
    }
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws Exception{
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        return factory;
    }
}

package sg.com.msiglobal.mqconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("Q.LRTO01.AFC.CCSRO.004")
    private String topic;

    public void sendMessage(String message){
        try{
            System.out.println("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
            System.err.println("Recieved Exception during send Message: "+ e);
            e.printStackTrace();
        }
    }
}

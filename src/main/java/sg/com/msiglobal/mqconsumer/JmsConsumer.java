package sg.com.msiglobal.mqconsumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;




@Component
public class JmsConsumer {


    @JmsListener(id="testlistener",destination = "Q.LRTO01.AFC.CCSRO.004", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {

        try{

            System.out.println("received message: " + message);
        } catch(Exception e) {
            System.err.println("Received Exception : "+ e);
            e.printStackTrace();
        }

    }
}

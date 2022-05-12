package sg.com.msiglobal.mqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceMessageController {

    @Autowired
    JmsProducer jmsProducer;

    @GetMapping(value="/api/test")
    public String sendMessage(@PathVariable(value="message") String message){
        try {
            jmsProducer.sendMessage(message);
            System.out.println("message sent");
            return "OK";
        } catch (Exception e){
            e.printStackTrace();
            return "Also OK";
        }
    }
    @GetMapping("/api/test1/{message}")
    public String testMessage(@PathVariable String message){
        try {
            System.out.println("message received: " + message);
            jmsProducer.sendMessage(message);
            System.out.println("message sent");
            return "OK";
        } catch (Exception e){
            e.printStackTrace();
            return "Also OK";
        }
    }


}

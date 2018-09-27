package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/alert")
    @SendTo("/msg/alert")
    public Greeting alert(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Alert, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/alert")
    public String alertPost(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        Greeting g = new Greeting("Alert post, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        messagingTemplate.convertAndSend("/msg/alert", g);
        return "index";
    }
}

package api.web.controller;

import api.web.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RootController {
    private List<Message> messages = new ArrayList<>();

    @PostConstruct
    private void init() {
        messages.add(new Message("Message 1"));
        messages.add(new Message("Message 2"));
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public List<Message> getMessages() {
        return messages;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public int pingTest() {
        return HttpStatus.OK.value();
    }
}

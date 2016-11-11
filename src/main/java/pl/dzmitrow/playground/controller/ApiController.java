package pl.dzmitrow.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dzmitrow.playground.model.Greeting;
import pl.dzmitrow.playground.repositories.GreetingsRepository;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private GreetingsRepository greetingsRepository;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Lok'tar Ogar!";
    }

    @RequestMapping(path = "/greetings", method = RequestMethod.GET)
    public Iterable<Greeting> getGreetings() {
        return greetingsRepository.findAll();
    }


}

package pl.dzmitrow.playground.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dzmitrow.playground.model.Greeting;
import pl.dzmitrow.playground.repositories.GreetingsRepository;

@RestController
@RequestMapping("api")
public class ApiController {

    private static final Logger log = Logger.getLogger(ApiController.class);

    @Autowired
    private GreetingsRepository greetingsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Lok'tar Ogar!";
    }

    @GetMapping("/greetings")
    public Iterable<Greeting> getGreetings() {
        return greetingsRepository.findAll();
    }

    @GetMapping(value = "/greetings/{language}")
    public Greeting getGreetingsByLanguage(@PathVariable String language) {
        return greetingsRepository.findByLanguage(language);
    }


}

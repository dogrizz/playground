package pl.dzmitrow.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.dzmitrow.playground.model.Greeting;
import pl.dzmitrow.playground.repositories.GreetingsRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
 
    @Autowired
    private GreetingsRepository greetingsRepository;

    @Override
    public void run(String... strings) throws Exception {
        greetingsRepository.save(new Greeting("Orcish", "Lok'tar Ogar"));
    }
}
package pl.dzmitrow.playground.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dzmitrow.playground.model.Greeting;

import java.util.List;

public interface GreetingsRepository extends CrudRepository<Greeting, String>{

    Greeting findByLanguage(String language);

}

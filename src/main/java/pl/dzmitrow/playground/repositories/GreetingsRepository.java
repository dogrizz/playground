package pl.dzmitrow.playground.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dzmitrow.playground.model.Greeting;

public interface GreetingsRepository extends CrudRepository<Greeting, String>{
}

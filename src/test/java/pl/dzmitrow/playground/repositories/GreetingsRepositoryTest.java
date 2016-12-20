package pl.dzmitrow.playground.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dzmitrow.playground.model.Greeting;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
// If not for swagger this should be run with @DataJpaTest instead of those two below
// see: https://github.com/springfox/springfox/issues/654
@Transactional
@SpringBootTest
public class GreetingsRepositoryTest {

    @Autowired
    private GreetingsRepository greetingsRepository;

    @Test
    public void loaderTest() {
        List<Greeting> greetins = new ArrayList<Greeting>();
        greetingsRepository.findAll().forEach(x -> greetins.add(x));
        assertEquals(1, greetins.size());
    }

    @Test
    public void queryMethodTest() {
        Greeting greeting = greetingsRepository.findByLanguage("Orcish");
        assertNotNull(greeting);
    }

    @Test
    public void queryMethodEmptyResultTest() {
        Greeting greeting = greetingsRepository.findByLanguage("Elven");
        assertNull(greeting);

    }

}

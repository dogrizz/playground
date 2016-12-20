package pl.dzmitrow.playground.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.dzmitrow.playground.model.Greeting;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class GreetingsRepositoryTest {

    @Autowired
    GreetingsRepository greetingsRepository;

    @Test
    public void loaderTest(){
        List<Greeting> greetins = new ArrayList<Greeting>();
        greetingsRepository.findAll().forEach(x -> greetins.add(x));
        assertEquals(1,greetins.size());
    }

    @Test
    public void queryMethodTest(){
        Greeting greeting = greetingsRepository.findByLanguage("Orcish");
        assertNotNull(greeting);
    }

    @Test
    public void queryMethodEmptyResultTest(){
        Greeting greeting = greetingsRepository.findByLanguage("Elven");
        assertNull(greeting);

    }

}

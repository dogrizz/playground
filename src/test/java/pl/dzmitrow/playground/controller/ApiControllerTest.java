package pl.dzmitrow.playground.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.dzmitrow.playground.model.Greeting;
import pl.dzmitrow.playground.repositories.GreetingsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GreetingsRepository greetingsRepository;


    @Test
    public void getAllGreetingsShouldReturn() throws Exception {
        Greeting g = new Greeting("Orcich", "Lok'tar Ogar");
        List<Greeting> greetings = new ArrayList<>();
        greetings.add(g);

        given(this.greetingsRepository.findAll())
                .willReturn(greetings);

        this.mvc.perform(get("/api/greetings").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(g.getGreeting())));
    }

}

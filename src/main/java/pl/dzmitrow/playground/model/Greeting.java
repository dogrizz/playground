package pl.dzmitrow.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    private String language;

    @Column(nullable = false)
    private String greeting;

    public Greeting() {
    }

    public Greeting(String language, String greeting) {
        this.language = language;
        this.greeting = greeting;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greeting greeting1 = (Greeting) o;

        if (language != null ? !language.equals(greeting1.language) : greeting1.language != null) return false;
        return greeting != null ? greeting.equals(greeting1.greeting) : greeting1.greeting == null;

    }

    @Override
    public int hashCode() {
        int result = language != null ? language.hashCode() : 0;
        result = 31 * result + (greeting != null ? greeting.hashCode() : 0);
        return result;
    }
}

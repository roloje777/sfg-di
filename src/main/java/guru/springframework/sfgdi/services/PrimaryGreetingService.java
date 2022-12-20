package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
Indicates that a bean should be given preference when multiple candidates
are qualified to autowire a single-valued dependency.
If exactly one 'primary' bean exists among the candidates,
it will be the autowired value.
 */
@Primary
@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world from Primary Bean";
    }
}

package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("PT")
@Service("I18nService")
public class I18nPortugueseGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Olá Mundo";
    }
}

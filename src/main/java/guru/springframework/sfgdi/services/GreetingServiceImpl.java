package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/*
Spring managed service
Indicates that an annotated class is a "Service",
originally defined by Domain-Driven Design (Evans, 2003)
as "an operation offered as an interface that stands alone
in the model, with no encapsulated state."
 */
@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world";
    }
}

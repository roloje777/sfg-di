package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {
    SetterInjectedController controller;
    @BeforeEach
    void setUp() {
        // Mimic what the Spring framework would do
        // using the setter to inject dependencies
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
       System.out.println(controller.getGreeting());
    }
}
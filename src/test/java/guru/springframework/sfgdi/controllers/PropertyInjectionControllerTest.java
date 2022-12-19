package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectionControllerTest {
    PropertyInjectionController controller;
    @BeforeEach
    void setUp() {
        // here we mimic what the Spring Framework would do
        controller = new PropertyInjectionController();// return a controller
        // controller uses the service
        controller.greetingService = new ConstructorGreetingService();// return a service
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());

    }
}
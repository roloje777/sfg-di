package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectionControllerTest {
    PropertyInjectionController controller;
    @BeforeEach
    void setUp() {
        // here we mimic what the Spring Framework would do
        controller = new PropertyInjectionController();// return a controller
        // controller uses the service
        controller.greetingService = new GreetingServiceImpl();// return a service
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());

    }
}
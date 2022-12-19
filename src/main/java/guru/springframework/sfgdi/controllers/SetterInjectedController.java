package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller  // Spring managed controller
public class SetterInjectedController {

    private GreetingService greetingService;

    /*
    Marks a constructor, field, setter method, or config method as to be
    autowired by Spring's dependency injection facilities.
    */
  @Qualifier("setterInjectedGreetingService")
   @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }


}

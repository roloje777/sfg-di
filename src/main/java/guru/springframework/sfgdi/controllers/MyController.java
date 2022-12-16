package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

// add as Spring managed controller
@Controller
public class MyController {

    public String sayHello(){
        System.out.println("Hello world!!");
        return "Hi folks!!!";
    }
}

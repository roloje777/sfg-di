package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SfgDiApplication.class, args);
		// return a context from the application
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
	    /*
	       return a reference to the controller from the context
	       by default the name is the same, bu starts with lowercase
	       Must cast as it's an Object type returned
	     */
		MyController myController = (MyController)ctx.getBean("myController");

		String greeting = myController.sayHello();
		System.out.println(greeting);
	}

}

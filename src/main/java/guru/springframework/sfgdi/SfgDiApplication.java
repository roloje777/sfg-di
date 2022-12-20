package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import guru.springframework.sfgdi.controllers.PropertyInjectionController;
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

		System.out.println("------ Primary Bean");
		System.out.println(myController.sayHello());

		/*
		  example of Spring managed dependency injections
		  One needs to add the tags in the Controllers and Service classes/interfaces

		 */

		System.out.println("------ Property");
		PropertyInjectionController propertyInjectionController = (PropertyInjectionController) ctx.getBean("propertyInjectionController");
		System.out.println(propertyInjectionController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}

package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/*
   this loads the datasource properties from the
   ./resources/datasource.properties file

   These files are added to the classpath
   and the resources folder is added to the jar file

 */
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreeingServiceConfig {

    /*
       This bean will configure the
       datasource properties via the configuration
       on startup.
       see @PropertySource("classpath:datasource.properties")
       and @Value("${guru.name}")String userName,
                                  @Value("${guru.password}")String password,
                                  @Value("{guru.jdbcurl}")String jdbUrl
       injects the values from the properties file
     */
    @Bean
    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConfiguration.getUsername());
        fakeDataSource.setPassword(sfgConfiguration.getPassword());
        fakeDataSource.setJdbUrl(sfgConfiguration.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Profile({"default","dog"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
//    @Bean
//    ConstructorGreetingService constructorGreetingService(){
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile("EN")
    @Bean()
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService(){
        return new I18NSpanishService();
    }
}

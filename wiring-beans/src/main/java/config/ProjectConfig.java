package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

//    @Bean
//    public Parrot parrot() {
//         Parrot parrot = new Parrot();
//         parrot.setName("Kiki");
//         return parrot;
//    }
//
//    @Bean
//    public Person person(Parrot parrot) {
//        Person person = new Person();
//        person.setName("Laura");
//        person.setParrot(parrot);
//        return person;
//    }

}

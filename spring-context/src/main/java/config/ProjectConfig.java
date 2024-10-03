package config;

import beans.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("beans") // Method 2 to add Beans to the Spring Context
public class ProjectConfig {

//    Method 1 to add Beans to the Spring Context
//    @Bean
//    public Parrot parrot() {
//        Parrot parrot = new Parrot();
//        parrot.setName("Kesha");
//        return parrot;
//    }

}

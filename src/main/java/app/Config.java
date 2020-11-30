package app;

import app.entities.Address;
import app.entities.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("app")
public class Config {
    @Scope("prototype")
    @Bean
    public Customer customerYuval() {
        return new Customer("Yuval", "Garti", "1", new Address());
    }
}

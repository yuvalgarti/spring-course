package app;

import app.entities.Address;
import app.entities.Customer;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("app")
@EnableAspectJAutoProxy
public class Config {
    @Scope("prototype")
    @Bean
    public Customer customerYuval() {
        return new Customer("Yuval", "Garti", "1", new Address());
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("");
        driverManagerDataSource.setSchema("yuval");
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        return driverManagerDataSource;
    }

}

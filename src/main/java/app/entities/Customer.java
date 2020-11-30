package app.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Scope("prototype")
@Component
@Primary
public class Customer {
    private String firstName;
    private String lastName;
    private String id;

    @Autowired
    private Address address;

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " is in @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + " is in @PreDestroy");
    }

}

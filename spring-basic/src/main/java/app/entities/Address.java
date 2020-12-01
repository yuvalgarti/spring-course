package app.entities;

import lombok.*;
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
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String zipCode;
    private String country;

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " is in @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + " is in @PreDestroy");
    }

}

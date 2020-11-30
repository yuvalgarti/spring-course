package app.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Scope("prototype")
@Component
public class Account {
    private String number;
    private double balance;
    private double overdraftCap;
    private double overdraftInterest;
}

package app.entities;

import app.annotations.BasicAuthorization;
import app.annotations.BasicMeasurement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Scope("prototype")
@Component
public class Account {
    private String number;

    @Getter(onMethod_ = {@BasicAuthorization(policyName = "SECRET"), @BasicMeasurement})
    @Setter(onMethod_ = {@BasicAuthorization, @BasicMeasurement})
    private double balance;
    private double overdraftCap;
    private double overdraftInterest;
}

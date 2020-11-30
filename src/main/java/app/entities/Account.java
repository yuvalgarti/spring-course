package app.entities;

import app.annotations.BasicAuthorization;
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

    @Getter(onMethod_ = {@BasicAuthorization(policyName = "SECRET")})
    @Setter(onMethod_ = {@BasicAuthorization})
    private double balance;
    private double overdraftCap;
    private double overdraftInterest;
}

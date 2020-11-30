package app;

import app.entities.Address;
import app.entities.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Customer customerYuval = (Customer) context.getBean("customerYuval");
        customerYuval.getAddress().setAddress1("Add1");
        customerYuval.getAddress().setAddress2("Add2");
        customerYuval.getAddress().setCity("Ness Ziona");
        customerYuval.getAddress().setZipCode("12345");
        customerYuval.getAddress().setCountry("Israel");


        Address address = context.getBean(Address.class);
        address.setAddress1("NewAdd1");
        address.setAddress2("NewAdd2");
        System.out.println(customerYuval);
        System.out.println(address);

        context.close();
    }
}

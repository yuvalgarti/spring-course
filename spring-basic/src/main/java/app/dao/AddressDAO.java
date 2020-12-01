package app.dao;

import app.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class AddressDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        //Address a = jdbcTemplate.queryForObject("select * from address;", Address.class);
        //jdbcTemplate.update()
        //System.out.println(a);
    }

    public void insertAddress(Address address) {
        jdbcTemplate.update("insert into address values(?, ?, ?, ?, ?)",
                address.getAddress1(), address.getAddress2(), address.getCity(), address.getZipCode(), address.getCountry());
    }

}

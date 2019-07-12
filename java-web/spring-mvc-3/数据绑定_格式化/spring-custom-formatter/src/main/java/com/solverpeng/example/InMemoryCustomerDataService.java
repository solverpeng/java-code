package com.solverpeng.example;

import org.fluttercode.datafactory.impl.DataFactory;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Stream;

public class InMemoryCustomerDataService implements CustomerDataService {
    private Map<Long, Customer> customerMap = new HashMap<>();


    @PostConstruct
    private void postConstruct () {
        Stream.iterate(1L, a -> a + 1)
                .limit(10)
                .forEach(this::createCustomer);
    }

    private void createCustomer (Long id) {
        DataFactory df = new DataFactory();
        Customer c = new Customer();
        c.setName(df.getName());
        c.setId(id);
        Address a = new Address();
        a.setStreet(df.getNumberText(4) + " " + df.getStreetName());
        a.setCity(df.getCity());
        a.setCounty(df.getItem(Locale.getISOCountries()));
        a.setZipCode(df.getNumberText(5));
        c.setAddress(a);
        customerMap.put(c.getId(), c);
    }



    @Override
    public List<Customer> getAllUsers () {
        return new ArrayList<>(customerMap.values());
    }
}

package com.theara.restful.restfulwebservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.theara.restful.restfulwebservice.model.CreditCard;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class CreditCardController {

    private final String[] INCLUDED_FIELDS = {"cardHolder", "cardNumber"};

    @GetMapping("credit-cards/{id}")
    public MappingJacksonValue getCreditCardById(@PathVariable int id){

        CreditCard creditCard = new CreditCard("Theara Seng", "XX-NUMBER-OF-CARD-" + id, new Date(), "SECRET");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(INCLUDED_FIELDS);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("creditCard", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(creditCard);

        mapping.setFilters(filterProvider);

        return mapping;

    }

    @GetMapping("credit-cards")
    public MappingJacksonValue getCreditCards(){

        List<CreditCard> creditCards = Arrays.asList(
                new CreditCard("Theara Seng", "XX-NUMBER-OF-CARD-1", new Date(), "SECRET"),
                new CreditCard("Dara Keng", "XX-NUMBER-OF-CARD-2", new Date(), "SECRET"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(INCLUDED_FIELDS);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("creditCard", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(creditCards);

        mapping.setFilters(filterProvider);

        return mapping;

    }

}

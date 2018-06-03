package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){

        List<SomeBean> someBean = Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"));
        return getMappingJacksonValue(someBean, "value1", "value2");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retriaveListSomeBean(){
        List<SomeBean> someBeans = Arrays.asList(
                new SomeBean("value1", "value2", "value3", "value4"),
                new SomeBean("value1", "value2", "value3", "value4"));

        return getMappingJacksonValue(someBeans, "value1", "value3");
    }

    private MappingJacksonValue getMappingJacksonValue(List<SomeBean> someBean, String... properties) {

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}

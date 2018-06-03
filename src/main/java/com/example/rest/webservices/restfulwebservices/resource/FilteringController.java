package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1", "value2","value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retriaveListSomeBean(){
        return Arrays.asList(
                new SomeBean("value1", "value2","value3", "value4"),
                new SomeBean("value1", "value2","value3", "value4"));
    }
}

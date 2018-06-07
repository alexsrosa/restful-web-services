package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.Name;
import com.example.rest.webservices.restfulwebservices.bean.PersonV1;
import com.example.rest.webservices.restfulwebservices.bean.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    /**
     * URI Versioning.
     *
     * Use by Twitter
     */
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Alex Silveira");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Alex", "Silveira"));
    }

    /**
     * Request Parameter versioning: Use with param "version" and value "1"
     *
     * Use by Amazon
     */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Alex Silveira");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Alex", "Silveira"));
    }


    /**
     * Headers versioning: Use in header with param "X-API-VERSION" and value "1"
     *
     * Use by Microsoft
     */
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Alex Silveira");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Alex", "Silveira"));
    }

    /**
     * Media Type versioning: Use in header with param "Accept" and value "application/vnd.company.app-v1+json"
     *
     * Use by GitHub
     */
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Alex Silveira");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Alex", "Silveira"));
    }
}

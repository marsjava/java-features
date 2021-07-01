package com.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    // URI versioning (Twitter)
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("Antony Ivan");
    }
    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Person("Antony", "Ivan"));
    }

    //Request Parameter versioning (Amazon)
    @GetMapping(value="/person/param", params = "version=1")
    public PersonV1 getPersonV1Param(){
        return new PersonV1("Antony Ivan");
    }
    @GetMapping(value="/person/param", params = "version=2")
    public PersonV2 getPersonV2Param() {
        return new PersonV2(new Person("Antony", "Ivan"));
    }

    // Custom Header versioning (Microsoft)
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header(){
        return new PersonV1("Antony Ivan");
    }
    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Person("Antony", "Ivan"));
    }

    // Accept header/MIME type versioning (Media type versioning - Content negotiation or accept header) GitHub
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1Produces(){
        return new PersonV1("Antony Ivan");
    }
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2Produces() {
        return new PersonV2(new Person("Antony", "Ivan"));
    }
}

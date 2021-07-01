package com.rest.webservices.versioning;

public class PersonV2 {
    private Person person;

    public PersonV2() {
    }

    public PersonV2(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

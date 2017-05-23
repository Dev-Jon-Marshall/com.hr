package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Contact
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContactId")
    private Integer contactId;

    @Version
    private Integer version;

    @OneToOne(cascade=CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;



    public Contact () {}

    public Contact(Person person, Address address)
    {
        this.setPerson(person);
        this.setAddress(address);

    }

    public Integer getContactId()
    {
        return contactId;
    }

    public void setContactId(Integer contactId)
    {
        this.contactId = contactId;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

//    public Employee getEmployee()
//    {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee)
//    {
//        this.employee = employee;
//    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}

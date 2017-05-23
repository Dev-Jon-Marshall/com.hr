package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressId")
    private Integer addressId;

    @Version
    private Integer version;

    @Column(name="Street")
    private String street;

    @Column(name="StreetExt")
    private String streetExt;

    @Column(name="City")
    private String city;

    @Column(name="State")
    private String state;

    @Column(name="Zip")
    private Integer zip;


    public Address () {}

    public Address (String street, String city, String state, Integer zip )
    {
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }

    public Address (String street, String streetExt, String city, String state, Integer zip )
    {
        this.setStreet(street);
        this.setStreetExt(streetExt);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }



    public Integer getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreetExt()
    {
        return streetExt;
    }

    public void setStreetExt(String streetExt)
    {
        this.streetExt = streetExt;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Integer getZip()
    {
        return zip;
    }

    public void setZip(Integer zip)
    {
        this.zip = zip;
    }


}

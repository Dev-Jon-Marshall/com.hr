package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PersonId")
    private Integer personId;

    @Version
    private Integer version;

    @Column(name = "Title")
    private String title;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "CreateDate")
    private LocalDate createDate;

    @Column(name = "DisplayFirstName")
    private String displayFirstName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Birthday")
    private LocalDate birthday;


    public Person()
    {
    }

    public Person(String firstName, String lastName)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }


    public Integer getPersonId()
    {
        return personId;
    }

    public void setPersonId(Integer personId)
    {
        this.personId = personId;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate)
    {
        this.createDate = createDate;
    }

    public String getDisplayFirstName()
    {
        return displayFirstName;
    }

    public void setDisplayFirstName(String displayFirstName)
    {
        this.displayFirstName = displayFirstName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }
}


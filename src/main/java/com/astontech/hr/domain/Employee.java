package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee extends Person
{

    @Column(name="Background")
    private String background;

    @OneToMany
    private List<Project> projects;



    public Employee() {}

    public Employee(String background)
    {
        this.background = background;
    }



    public String getBackground()
    {
        return background;
    }

    public void setBackground(String background)
    {
        this.background = background;
    }

    public List<Project> getProjects()
    {
        return projects;
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }
}
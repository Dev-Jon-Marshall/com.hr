package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProjectId")
    private Integer id;

    @Version
    private Integer version;

    @Column(name="ProjectName")
    private String projectName;

    @Column(name="ClientName")
    private String clientName;

    @Column(name="FieldRate")
    private Integer fieldRate;




    public Project() {}

    public Project(String projectName, String clientName, Integer fieldRate)
    {
        this.projectName = projectName;
        this.clientName = clientName;
        this.fieldRate = fieldRate;
    }


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public Integer getFieldRate()
    {
        return fieldRate;
    }

    public void setFieldRate(Integer fieldRate)
    {
        this.fieldRate = fieldRate;
    }
}
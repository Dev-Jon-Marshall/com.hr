package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
@Entity
public class VehicleModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer vehicleModelId;

    @Version
    private Integer version;

    private String vehicleModelName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Vehicle> vehicleList;

    public VehicleModel () {}

    public VehicleModel(String vehicleModelName)
    {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleModel(Integer vehicleModelId, Integer version, String vehicleModelName)
    {
        this.vehicleModelId = vehicleModelId;
        this.version = version;
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleModel (String vehicleModelName, List<Vehicle> vehicleList)
    {
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleList(vehicleList);
    }

    public Integer getVehicleModelId()
    {
        return vehicleModelId;
    }

    public void setVehicleModelId(Integer vehicleModelId)
    {
        this.vehicleModelId = vehicleModelId;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getVehicleModelName()
    {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName)
    {
        this.vehicleModelName = vehicleModelName;
    }

    public List<Vehicle> getVehicleList()
    {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList)
    {
        this.vehicleList = vehicleList;
    }
}

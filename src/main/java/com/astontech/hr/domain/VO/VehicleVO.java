package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.time.LocalDate;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public class VehicleVO
{
    private Vehicle vehicle;
    private VehicleModel vehicleModel;
    private VehicleMake vehicleMake;

    private String newVehicleMake;
    private String newVehicleModel;
    private String newVehicle;
    private String[] newVehicleList;
    private String[] newVehicleModelList;

    public VehicleVO(){}



    //region CUSTOM METHODS
    //SHOULD MOVE INTO COMMON HELPERS AND MAKE GENERIC**********
    public void splitNewVehicleIntoArray()
    {
        //regex for splitting on new line or carriage return is "\\r?\\n"
        this.setNewVehicleList(this.newVehicle.split("\\r?\\n"));
    }

    public void splitNewVehicleModelIntoArray()
    {
        //regex for splitting on new line or carriage return is "\\r?\\n"
        this.setNewVehicleModelList(this.newVehicleModel.split("\\r?\\n"));
    }


    public String getNewVehicle()
    {
        return newVehicle;
    }

    public void setNewVehicle(String newVehicle)
    {
        this.newVehicle = newVehicle;
    }

    public String getNewVehicleMake()
    {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake)
    {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel()
    {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel)
    {
        this.newVehicleModel = newVehicleModel;
    }

    public String[] getNewVehicleList()
    {
        return newVehicleList;
    }

    public void setNewVehicleList(String[] newVehicleList)
    {
        this.newVehicleList = newVehicleList;
    }

    public String[] getNewVehicleModelList()
    {
        return newVehicleModelList;
    }

    public void setNewVehicleModelList(String[] newVehicleModelList)
    {
        this.newVehicleModelList = newVehicleModelList;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public VehicleModel getVehicleModel()
    {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel)
    {
        this.vehicleModel = vehicleModel;
    }

    public VehicleMake getVehicleMake()
    {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake)
    {
        this.vehicleMake = vehicleMake;
    }
    //endregion

}

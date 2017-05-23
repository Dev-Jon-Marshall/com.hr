package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public interface VehicleService
{
    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

    //CUSTOM QUERY
    VehicleModel findVehicleModelIdByVehicleId(Integer vehicleId);
}

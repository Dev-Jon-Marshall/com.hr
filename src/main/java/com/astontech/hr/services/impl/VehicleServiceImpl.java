package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<Vehicle> listAllVehicles()
    {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id)
    {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle)
    {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable)
    {
        return vehicleRepository.save(vehicleIterable);
    }

    @Override
    public void deleteVehicle(Integer id)
    {
        vehicleRepository.delete(id);
    }


    @Override
    public VehicleModel findVehicleModelIdByVehicleId(Integer vehicleId)
    {
        return vehicleModelRepository.findOne(vehicleRepository.findVehicleModelIdByVehicleId(vehicleId));
    }
}

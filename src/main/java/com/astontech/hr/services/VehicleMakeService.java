package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public interface VehicleMakeService
{
    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer id);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteElement(Integer id);
}

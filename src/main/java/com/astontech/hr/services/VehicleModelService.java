package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public interface VehicleModelService
{
    Iterable<VehicleModel> listAllVehicleModels();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicleModel(Integer id);

    //CUSTOM QUERY
    VehicleMake findVehicleMakeIdByVehicleModelId(Integer vehicleModelId);

    List<VehicleModel> findVehicleModelsByVehicleMakeId(Integer vehicleMakeId);
}

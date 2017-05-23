package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer>
{
    @Query(value = "SELECT VEHICLE_MODEL_VEHICLEMODELID FROM VEHICLE_MODEL_VEHICLE_LIST " +
                    "where vehicle_list_vehicleid = :vehicleId"
                    , nativeQuery = true
        )
    Integer findVehicleModelIdByVehicleId(@Param("vehicleId") Integer vehicleId);
}

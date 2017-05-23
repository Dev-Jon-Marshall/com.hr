package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer>
{
    @Query(value = "SELECT VEHICLE_MAKE_VEHICLEMAKEID FROM VEHICLE_MAKE_VEHICLE_MODEL_LIST " +
                    "where VEHICLE_MODEL_LIST_VEHICLEMODELID = :vehicleModelId"
                    , nativeQuery = true)
    Integer findVehicleMakeIdByVehicleModelId(@Param("vehicleModelId") Integer vehicleModelId);




    @Query(value = "select * from VEHICLE_MODEL B " +
                    "inner join  VEHICLE_MAKE_VEHICLE_MODEL_LIST A on B.VEHICLE_MODEL_ID = A.VEHICLE_MODEL_LIST_VEHICLEMODELID " +
                    "where a.VEHICLE_MAKE_VEHICLEMAKEID = :vehicleMakeId"
                    , nativeQuery = true)
    List<VehicleModel> findVehicleModelsByVehicleMakeId(@Param("vehicleMakeId") Integer vehicleMakeId);




}

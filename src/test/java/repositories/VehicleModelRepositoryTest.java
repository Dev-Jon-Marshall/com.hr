package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/21/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleModelRepositoryTest
{
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Test
    public void findVehicleModelsByVehicleMakeId()
    {
        //FORD
        List<VehicleModel> fordModels = new ArrayList<>();
        fordModels.add(new VehicleModel("Taurus"));
        fordModels.add(new VehicleModel("Focus"));
        fordModels.add(new VehicleModel("F150"));

        //******************************************************************************************************
        //Vehicle Make Seed

        //VehicleMake(String vehicleMakeName, List<VehicleModel> vehicleModelList)
        List<VehicleMake> vehicleMakes = new ArrayList<>();
        vehicleMakes.add(new VehicleMake("Ford",fordModels));

        vehicleMakeRepository.save(vehicleMakes);

        List<VehicleModel> vehicleModelList = vehicleModelRepository.findVehicleModelsByVehicleMakeId(1);

        assertEquals(3, vehicleModelList.size());

        System.out.println(vehicleModelList);

    }
}

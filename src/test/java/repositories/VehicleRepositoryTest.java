package repositories;


import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/14/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleRepositoryTest
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Test
    public void testGetModelIdByVehicleId()
    {
        List <Vehicle> taurusList = new ArrayList<>(); //localDateAttributeConverter.convertToDatabaseColumn(2016,9,22)));
        taurusList.add(new Vehicle(2016,"123ABC","123asd789r","BLUE","true",25000, LocalDate.of(2016, 9, 22)));
        taurusList.add(new Vehicle(2016,"456ABC","8d594jfuth","GREEN","true",30000, LocalDate.of(2016,9,22)));
        taurusList.add(new Vehicle(2015,"789ABC","4kg5d84jf9","BLACK","true",25000, LocalDate.of(2016,9,22)));

        vehicleModelRepository.save(new VehicleModel("Taurus", taurusList));

        Vehicle vehicle = vehicleRepository.findOne(1);
        System.out.println(vehicle.getColor());
        assertEquals("BLUE", vehicle.getColor());
        Integer modelByVehicleId = vehicleRepository.findVehicleModelIdByVehicleId(1);
        assertEquals(new Integer(1), modelByVehicleId);
        VehicleModel vehicleModel = vehicleModelRepository.findOne(modelByVehicleId);
        System.out.println("Retrieved Model ID: " + modelByVehicleId);
        assertEquals("Taurus", vehicleModel.getVehicleModelName());
    }
}

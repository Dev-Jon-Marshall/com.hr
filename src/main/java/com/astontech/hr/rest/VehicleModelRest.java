package com.astontech.hr.rest;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@RestController
@RequestMapping("/api/vehicle_editModel")
public class VehicleModelRest
{
    private Logger log = Logger.getLogger(VehicleModelRest.class);

    @Autowired
    private VehicleModelService vehicleModelService;

    //GET ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<VehicleModel> getAll()
    {
        return vehicleModelService.listAllVehicleModels();
    }

    //GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public VehicleModel getById(@PathVariable int id)
    {
        return vehicleModelService.getVehicleModelById(id);
    }

    //POST SAVE
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public VehicleModel save(@ModelAttribute("vehicleModel") VehicleModel vehicleModel)
    {
        return vehicleModelService.saveVehicleModel(vehicleModel);
    }

    //POST DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id)
    {
        boolean result = false;
        try
        {
            vehicleModelService.deleteVehicleModel(id);
            result = true;
        }
        catch(Exception ex)
        {
            log.info(ex);
        }
        return result;
    }

}

package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/13/2017.
 */
@Controller
public class VehicleController
{
    private Logger log = Logger.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    //******************************************************************************************************
    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public String vehicleHome()
    {
        return "admin/vehicleHome";
    }


    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.GET)
    public String adminVehicle(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_list";
    }


    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model)
    {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_list";
    }


    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEditGET(@PathVariable int id, Model model)
    {

        Vehicle vehicle = vehicleService.getVehicleById(id);

        VehicleModel vehicleModel = vehicleService.findVehicleModelIdByVehicleId(id);
        Integer modelId = vehicleModel.getVehicleModelId();

        VehicleMake vehicleMake = vehicleModelService.findVehicleMakeIdByVehicleModelId(modelId);

        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicleModelID", vehicleModel);
        model.addAttribute("vehicleMakeID", vehicleMake);



        return "admin/vehicle/vehicle_editVehicle";

    }


    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleEditPOST(@ModelAttribute("vehicle") Vehicle vehicle, Model model,
                                  @RequestParam Integer id)
    {

        vehicle.setId(id);
        vehicleService.saveVehicle(vehicle);


        return "redirect:/admin/vehicle/list";
    }



    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/addModel", method = RequestMethod.GET)
    public String addModelGet(Model model)
    {
        model.addAttribute("vehicleMake", new VehicleMake());
        //model.addAttribute("warningAlert", "visible");

        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_editModel";

    }



    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public @ResponseBody List<VehicleModel> vehicleModelsByVehicleMake(@RequestParam(value = "selectedMake", required = true) Integer Make)
    {
        return vehicleModelService.findVehicleModelsByVehicleMakeId(Make);
    }



    @RequestMapping(value = "/admin/vehicle/addModel", method = RequestMethod.POST)
    public String addModelPost(VehicleMake vehicleMake, Model model, @RequestParam("inputNewVehicleModel") String newVehicleModel)
    {
        VehicleMake vehicleMakeToUpdate = vehicleMakeService.getVehicleMakeById(vehicleMake.getVehicleMakeId());

        int oldList = vehicleMakeToUpdate.getVehicleModelList().size();

        //if new element (Unbound text box) has a value, add it to the list
        if(!newVehicleModel.equals(""))
        {
            if(vehicleMakeToUpdate.getVehicleModelList() == null)
            {
                List<VehicleModel> modelList = new ArrayList<VehicleModel>();
                modelList.add(new VehicleModel(newVehicleModel));
                vehicleMakeToUpdate.setVehicleModelList(modelList);
            }
            else
            {
                vehicleMakeToUpdate.getVehicleModelList().add(new VehicleModel(newVehicleModel));
            }
        }

         int newList = vehicleMakeToUpdate.getVehicleModelList().size();

        vehicleMakeService.saveVehicleMake(vehicleMakeToUpdate);

        if(newList > oldList)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("vehicleMake", new VehicleMake());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        //return "redirect:/admin/vehicle/addModel";
        return "/admin/vehicle/vehicle_editModel";
    }

    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/addMake", method = RequestMethod.GET)
    public String addMakeGet(Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());
        //model.addAttribute("warningAlert", "visible");

        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_editMake";

    }

    @RequestMapping(value = "/admin/vehicle/addMake", method = RequestMethod.POST)
    public String addMakePost(VehicleVO vehicleVO, Model model)
    {
        VehicleMake newVehicleMake = new VehicleMake();

        newVehicleMake.setVehicleMakeName(vehicleVO.getNewVehicleMake());

        vehicleMakeService.saveVehicleMake(newVehicleMake);

        model.addAttribute("vehicleVO", new VehicleVO());

        if(newVehicleMake.getVehicleMakeId() == null)
            model.addAttribute("errorAlert", "visible");
        else
            model.addAttribute("successAlert", "visible");

        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "/admin/vehicle/vehicle_editMake";

    }

    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/addVehicle", method = RequestMethod.GET)
    public String addVehicleGet(VehicleVO vehicleVO, Model model)
    {
        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_addVehicle";

    }


    @RequestMapping(value = "/admin/vehicle/addVehicle", method = RequestMethod.POST)
    public String addVehiclePost(VehicleVO vehicleVO, Model model)
    {
        VehicleModel vehicleModelToUpdate = vehicleModelService.getVehicleModelById(vehicleVO.getVehicleModel().getVehicleModelId());

        Vehicle newVehicle = vehicleVO.getVehicle();

        //checks size of vehicle list before adding new vehicle
        int oldList = vehicleModelToUpdate.getVehicleList().size();

        //add new vehicle
        if (vehicleModelToUpdate.getVehicleList() == null)
        {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            vehicleList.add(newVehicle);
            vehicleModelToUpdate.setVehicleList(vehicleList);
        } else
        {
            vehicleModelToUpdate.getVehicleList().add(newVehicle);
        }

        //checks size of list after adding new vehicle
        int newList = vehicleModelToUpdate.getVehicleList().size();

        vehicleModelService.saveVehicleModel(vehicleModelToUpdate);

        //logic for error/success alerts
        if(newList > oldList)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        //reset page on reload
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());


        return "/admin/vehicle/vehicle_addVehicle";
    }


    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String deleteVehicleGet(@PathVariable int id, Model model)
    {
        Vehicle vehicleToDelete = vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicleToDelete);

        return "admin/vehicle/vehicle_deleteVehicle";

    }


    //******************************************************************************************************
    @RequestMapping(value = "/admin/vehicle/deleteVehicle/{id}", method = RequestMethod.POST)
    public String deleteVehiclePost(@PathVariable int id, Model model, @RequestParam("deleteVehicleConfirm") String confirm)
    {



        if(confirm.equals("DELETE"))
        {
            Vehicle vehicleToDelete = vehicleService.getVehicleById(id);
            VehicleModel vehicleModelToAdjust = vehicleService.findVehicleModelIdByVehicleId(id);



            List<Vehicle> originalList = vehicleModelToAdjust.getVehicleList();
            List<Vehicle> newList = new ArrayList<Vehicle>();
            for (Vehicle vehicle : originalList) {
                if (!vehicle.getId().equals(vehicleToDelete.getId()))
                {
                    newList.add(vehicle);
                }
            }

            vehicleModelToAdjust.setVehicleList(newList);
            vehicleModelService.saveVehicleModel(vehicleModelToAdjust);

            model.addAttribute("successAlert", "visible");
        }
        else
        {
            model.addAttribute("errorAlert", "visible");
        }


        model.addAttribute("vehicle", new Vehicle());
        return "/admin/vehicle/vehicle_deleteVehicle";

    }



}

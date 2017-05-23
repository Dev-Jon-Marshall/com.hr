package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.*;

import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/9/2017.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        generateElementAndElementTypes();
        generateVehicleVehicleMakeVehicleModelData();
        generateEmployees();
    }

    private void generateElementAndElementTypes()
    {   //Type Seed
        ElementType laptopType = new ElementType ("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        //Type Seed
        ElementType emailType = new ElementType ("Email");

        List<Element> elementList1 = new ArrayList<>();
        elementList1.add(new Element("Work"));
        elementList1.add(new Element("Home"));

        emailType.setElementList(elementList1);

        elementTypeService.saveElementType(emailType);

        //Type Seed
        ElementType phoneType = new ElementType ("Phone");

        List<Element> elementList2 = new ArrayList<>();
        elementList2.add(new Element("Cell"));


        phoneType.setElementList(elementList2);

        elementTypeService.saveElementType(phoneType);
    }

    private void generateVehicleVehicleMakeVehicleModelData()
    {   //******************************************************************************************************
        //Vehicle Seed

        //Vehicle(Integer year, String licensePlate, String vin, String color, boolean isPurchase, Integer purchasePrice, LocalDate purchaseDate)
        //FORD
        List <Vehicle> taurusList = new ArrayList<>(); //localDateAttributeConverter.convertToDatabaseColumn(2016,9,22)));
        taurusList.add(new Vehicle(2016,"123ABC","123asd789r","BLUE","true",25000, LocalDate.of(2016,9,22)));
        taurusList.add(new Vehicle(2016,"456ABC","8d594jfuth","GREEN","true",30000, LocalDate.of(2016, 9, 22)));
        taurusList.add(new Vehicle(2015,"789ABC","4kg5d84jf9","BLACK","true",25000, LocalDate.of(2016,9,22)));

        //vehicleService.saveVehicleList(taurusList);

        List <Vehicle> focusList = new ArrayList<>();
        focusList.add(new Vehicle(2016,"123ABC","123asd789r","BLUE","true",25000, LocalDate.of(2016,9,22)));
        focusList.add(new Vehicle(2016,"456ABC","8d594jfuth","GREEN","true",30000, LocalDate.of(2016,9,22)));
        focusList.add(new Vehicle(2015,"789ABC","4kg5d84jf9","BLACK","true",25000, LocalDate.of(2016,9,22)));

        //vehicleService.saveVehicleList(focusList);

        List <Vehicle> f150List = new ArrayList<>();
        f150List.add(new Vehicle(2016,"123ABC","123asd789r","BLUE","true",25000, LocalDate.of(2016,9,22)));
        f150List.add(new Vehicle(2016,"456ABC","8d594jfuth","GREEN","true",30000, LocalDate.of(2016,9,22)));
        f150List.add(new Vehicle(2015,"789ABC","4kg5d84jf9","BLACK","true",25000, LocalDate.of(2016,9,22)));

        //vehicleService.saveVehicleList(f150List);

        //CHEVROLET
        List <Vehicle> impalaList = new ArrayList<>();
        impalaList.add(new Vehicle(2014,"123ABC","123asd789r","RED","true",25000, LocalDate.of(2014,9,22)));
        impalaList.add(new Vehicle(2014,"456ABC","8d594jfuth","TAN","true",30000, LocalDate.of(2014,9,22)));
        impalaList.add(new Vehicle(2014,"789ABC","4kg5d84jf9","WHITE","true",40000, LocalDate.of(2014,9,22)));

        //vehicleService.saveVehicleList(impalaList);

        List <Vehicle> aveoList = new ArrayList<>();
        aveoList.add(new Vehicle(2014,"123ABC","123asd789r","RED","true",25000, LocalDate.of(2014,9,22)));
        aveoList.add(new Vehicle(2014,"456ABC","8d594jfuth","TAN","true",30000, LocalDate.of(2014,9,22)));
        aveoList.add(new Vehicle(2014,"789ABC","4kg5d84jf9","WHITE","true",40000, LocalDate.of(2014,9,22)));

        //vehicleService.saveVehicleList(aveoList);

        List <Vehicle> silveradoList = new ArrayList<>();
        silveradoList.add(new Vehicle(2014,"123ABC","123asd789r","RED","true",25000, LocalDate.of(2014,9,22)));
        silveradoList.add(new Vehicle(2014,"456ABC","8d594jfuth","TAN","true",30000, LocalDate.of(2014,9,22)));
        silveradoList.add(new Vehicle(2014,"789ABC","4kg5d84jf9","WHITE","true",40000, LocalDate.of(2014,9,22)));

        //vehicleService.saveVehicleList(silveradoList);

        //******************************************************************************************************
        //Vehicle Model Seed

        //VehicleModel(String vehicleModelName, List<Vehicle> vehicleList)
        //FORD
        List<VehicleModel> fordModels = new ArrayList<>();
        fordModels.add(new VehicleModel("Taurus", taurusList));
        fordModels.add(new VehicleModel("Focus", focusList));
        fordModels.add(new VehicleModel("F150", f150List));

        //vehicleModelService.saveVehicleModelList(fordModels);

        //CHEVROLET
        List<VehicleModel> chevyModels = new ArrayList<>();
        chevyModels.add(new VehicleModel("Impala", impalaList));
        chevyModels.add(new VehicleModel("Aveo", aveoList));
        chevyModels.add(new VehicleModel("Silverado", silveradoList));

        //vehicleModelService.saveVehicleModelList(chevyModels);

        //******************************************************************************************************
        //Vehicle Make Seed

        //VehicleMake(String vehicleMakeName, List<VehicleModel> vehicleModelList)
        List<VehicleMake> vehicleMakes = new ArrayList<>();
        vehicleMakes.add(new VehicleMake("Ford",fordModels));
        vehicleMakes.add(new VehicleMake("Chevrolet", chevyModels));

        vehicleMakeService.saveVehicleMakeList(vehicleMakes);





    }

    private void generateEmployees()
    {
        //ONE
        Address address1 = new Address("100 Work Lane", "HereAndNow", "MN", 55110);

        Employee employee1 = new Employee();
        employee1.setFirstName("Jon");
        employee1.setLastName("Marshall");
        employee1.setBackground("Wannabe Java Developer");

        Contact contact1 = new Contact();
        contact1.setAddress(address1);
        contact1.setPerson(employee1);
        contactService.saveContact(contact1);



        //TWO
        Address address2 = new Address("500 Park Place", "Fuzzy", "Navel", 16988);

        Employee employee2 = new Employee();
        employee2.setFirstName("Jerry");
        employee2.setLastName("MooFun");
        employee2.setBackground("Crazy JQuery Researcher");

        Contact contact2 = new Contact();
        contact2.setAddress(address2);
        contact2.setPerson(employee2);
        contactService.saveContact(contact2);



        //THREE
        Address address3 = new Address("7500 Crash Course", "Harry", "ColdaSac", 16988);

        Employee employee3 = new Employee();
        employee3.setFirstName("Tony");
        employee3.setLastName("Tiger");
        employee3.setBackground("Retired .NET Dude");

        Contact contact3 = new Contact();
        contact3.setAddress(address3);
        contact3.setPerson(employee3);
        contactService.saveContact(contact3);

        //FOUR
        Address address4 = new Address("9999 Round UP Lane", "Java", "Expressway", 18888);

        Person person4 = new Person();
        person4.setFirstName("Bipin");
        person4.setLastName("Butala");

        Contact contact4 = new Contact();
        contact4.setAddress(address4);
        contact4.setPerson(person4);
        contactService.saveContact(contact4);

        //FIVE
        Address address5 = new Address("10 Bucks", "Aint", "Enough", 18888);

        Person person5 = new Person();
        person5.setFirstName("Mike");
        person5.setLastName("Bike-Man");

        Contact contact5 = new Contact();
        contact5.setAddress(address5);
        contact5.setPerson(person5);
        contactService.saveContact(contact5);

        //SIX
        Address address6 = new Address("1 2 surf blvd", "SoCal", "California", 18888);

        Person person6 = new Person();
        person6.setFirstName("Aaron");
        person6.setLastName("Lover-(of Dad Jokes)");

        Contact contact6 = new Contact();
        contact6.setAddress(address6);
        contact6.setPerson(person6);
        contactService.saveContact(contact6);
    }
}

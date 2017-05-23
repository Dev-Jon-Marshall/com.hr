package services;


import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;

import com.astontech.hr.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest
{
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeServiceSaveTest()
    {
        Employee employee = new Employee();
        employee.setFirstName("Tony");
        employee.setLastName("Tiger");
        employee.setBackground("Retired .NET Dude");

        assertNull(employee.getPersonId());
        employeeService.saveEmployee(employee);
        assertNotNull(employee.getPersonId());

        //fetch
        Employee fetchedEmployee = employeeService.getEmployeeById(employee.getPersonId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getPersonId(), fetchedEmployee.getPersonId());

        //update
        fetchedEmployee.setFirstName("TonyUPDATE");
        employeeService.saveEmployee(fetchedEmployee);

        Employee fetchUpdateEmployee = employeeService.getEmployeeById(fetchedEmployee.getPersonId());
        assertEquals("TonyUPDATE", fetchUpdateEmployee.getFirstName());

    }

}

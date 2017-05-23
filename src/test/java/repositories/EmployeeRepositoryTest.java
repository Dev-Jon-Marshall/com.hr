package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class EmployeeRepositoryTest
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave()
    {
        //save
        Employee employee = new Employee();
        employee.setFirstName("BipinTEST");
        employee.setLastName("ButalaTEST");
        employee.setBackground("Java GuruTEST");

        assertNull(employee.getPersonId());
        employeeRepository.save(employee);
        assertNotNull(employee.getPersonId());

        //fetch
        Employee fetchedEmployee = employeeRepository.findOne(employee.getPersonId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getPersonId(), fetchedEmployee.getPersonId());

        //update
        fetchedEmployee.setFirstName("BipinUPDATE");
        employeeRepository.save(fetchedEmployee);

        Employee fetchUpdateEmployee = employeeRepository.findOne(fetchedEmployee.getPersonId());
        assertEquals("BipinUPDATE", fetchUpdateEmployee.getFirstName());


    }
}

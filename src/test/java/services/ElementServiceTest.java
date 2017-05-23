package services;

import com.astontech.hr.Application;

import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementService;
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
 * Created by Jonathan.Marshall on 3/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementServiceTest
{
    @Autowired
    private ElementService elementService;

    @Test
    public void elementServiceSaveTest()
    {
        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementService.saveElement(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementService.getElementById(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementService.saveElement(fetchedElement);

        Element updatedElement = elementService.getElementById(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
    }

}

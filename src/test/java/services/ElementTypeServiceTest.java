package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
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
 * Created by Jonathan.Marshall on 3/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementTypeServiceTest
{
    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void elementServiceSaveTest()
    {
        //setup element
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Phone");

        //save element, verify it has an ID after the save
        assertNull(elementType.getId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getId());

        //fetch
        ElementType fetchedElementType = elementTypeService.getElementTypeById(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        //update
        fetchedElementType.setElementTypeName("Email");
        elementTypeService.saveElementType(fetchedElementType);

        ElementType updatedElementType = elementTypeService.getElementTypeById(fetchedElementType.getId());
        assertEquals(updatedElementType.getElementTypeName(), "Email");
    }
}

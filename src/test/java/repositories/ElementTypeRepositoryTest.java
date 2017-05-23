package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest
{
    @Autowired
    
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testSaveElementType()
    {
        //setup elementType
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Phone");

        //save elementType, verify it has an ID after the save
        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        //fetch
        ElementType fetchedElementType = elementTypeRepository.findOne(elementType.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getId(), fetchedElementType.getId());

        //update
        fetchedElementType.setElementTypeName("Email");
        elementTypeRepository.save(fetchedElementType);

        ElementType updatedElementType = elementTypeRepository.findOne(fetchedElementType.getId());
        assertEquals(updatedElementType.getElementTypeName(), "Email");
    }

    @Test
    public void testSaveElementTypeList()
    {
        List<ElementType> elementTypeList = new ArrayList<>();

        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("Email"));
        elementTypeList.add(new ElementType("Laptop"));
        elementTypeList.add(new ElementType("PayRate"));

        elementTypeRepository.save(elementTypeList);

        Iterable<ElementType> fetchedElementTypeList = elementTypeRepository.findAll();

        int count = 0;
        for(ElementType elementType : fetchedElementTypeList) {

            count++;
            System.out.println("count: " + count+ " " +elementType.getElementTypeName());
        }

        //assertEquals(5, count);
    }

    @Test
    public void testFindByName()
    {
        ElementType elementType = new ElementType("FindTestSingle");
        elementTypeRepository.save(elementType);

        ElementType foundByNameElementType = elementTypeRepository.findByElementTypeName("FindTestSingle");

        assertEquals(elementType.getId(), foundByNameElementType.getId());
    }

    @Test
    public void testFindAllByName()
    {
        ElementType elementType1 = new ElementType("FindTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("FindTest");
        elementTypeRepository.save(elementType2);
        ElementType elementType3 = new ElementType("FindTest");
        elementTypeRepository.save(elementType3);

        List<ElementType> foundAllByNameElementType = elementTypeRepository.findAllByElementTypeName("FindTest");

        assertEquals(3, foundAllByNameElementType.size());
    }

    @Test
    public void findAllByElementTypeNameContainingAllIgnoreCase()
    {
        ElementType elementType1 = new ElementType("ContainsTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("ContainsTest");
        elementTypeRepository.save(elementType2);

        List<ElementType> testContains = elementTypeRepository.findAllByElementTypeNameContainingAllIgnoreCase("contains");

        assertEquals(2, testContains.size());
    }

    @Test
    public void findAllByElementTypeNameStartingWith()
    {
        ElementType elementType = new ElementType("ZTest");
        elementTypeRepository.save(elementType);

        List<ElementType> testStartsWith = elementTypeRepository.findAllByElementTypeNameStartingWith("Z");

        assertEquals(1, testStartsWith.size());
    }
}

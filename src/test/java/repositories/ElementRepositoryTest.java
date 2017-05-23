package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest
{
    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement()
    {
        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
    }

    @Test
    public void testSaveElementList()
    {
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for(Element element : fetchedElementList) {

           count++;
            System.out.println("count: " + count+ " " +element.getElementName());
        }

        //assertEquals(5, count);
    }

    @Test
    public void testFindByName()
    {
        Element element = new Element("FindTestSingle");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTestSingle");

        assertEquals(element.getId(), foundByNameElement.getId());
    }

    @Test
    public void testFindAllByName()
    {
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundAllByNameElement.size());
    }

//    @Test
//    public void findTop3ByIdOrderByElementNameAsc()
//    {
////        Element element1 = new Element("FindTop3");
////        elementRepository.save(element1);
////        Element element2 = new Element("FindTop3");
////        elementRepository.save(element2);
////        Element element3 = new Element("FindTop3");
////        elementRepository.save(element3);
//
//        List<Element> top3ByName = elementRepository.findTop3ByIdOrderByElementNameAsc("FindTop3");
//
//        System.out.println("Top 3:" + top3ByName);
//        assertEquals(3, top3ByName.size());
//    }

    @Test
    public void findAllByElementNameContainingAllIgnoreCase()
    {
        Element element1 = new Element("ContainsTest");
        elementRepository.save(element1);
        Element element2 = new Element("ContainsTest");
        elementRepository.save(element2);

        List<Element> testContains = elementRepository.findAllByElementNameContainingAllIgnoreCase("contains");

        assertEquals(2, testContains.size());
    }

    @Test
    public void findAllByElementNameStartingWith()
    {
        Element element = new Element("ZTest");
        elementRepository.save(element);

        List<Element> testStartsWith = elementRepository.findAllByElementNameStartingWith("Z");

        assertEquals(1, testStartsWith.size());
    }

    @Test
    public void findByIdLessThan()
    {
        List<Element> testLessId = elementRepository.findByIdLessThan(5);

        assertEquals(4, testLessId.size());

    }
}

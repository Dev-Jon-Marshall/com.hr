package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ContactRepositoryTest
{
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSave()
    {
        //save
        Address address = new Address("100 popular lane", "Here", "MN", 55110);

        assertNull(address.getAddressId());
        addressRepository.save(address);
        assertNotNull(address.getAddressId());

        Contact contact = new Contact();
        contact.setAddress(address);

        assertNull(contact.getContactId());
        contactRepository.save(contact);
        assertNotNull(contact.getContactId());


        //Fetch
        Contact fetchedContact = contactRepository.findOne(contact.getAddress().getAddressId());
        assertNotNull(fetchedContact);
        assertEquals(contact.getAddress().getAddressId(), fetchedContact.getAddress().getAddressId());

        //Update
        fetchedContact.getAddress().setStreet("200 UPDATE lane");

        addressRepository.save(fetchedContact.getAddress());

        Contact fetchedUpdateContact = contactRepository.findOne(fetchedContact.getAddress().getAddressId());
        assertEquals("200 UPDATE lane", fetchedUpdateContact.getAddress().getStreet());

    }





}

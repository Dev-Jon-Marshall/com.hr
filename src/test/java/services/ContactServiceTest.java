package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ContactServiceTest
{
    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Test
    public void contactServiceSaveTest()
    {
        //save
        Address address = new Address("100 popular lane", "Here", "MN", 55110);

        assertNull(address.getAddressId());
        addressService.saveAddress(address);
        assertNotNull(address.getAddressId());

        Contact contact = new Contact();
        contact.setAddress(address);

        assertNull(contact.getContactId());
        contactService.saveContact(contact);
        assertNotNull(contact.getContactId());


        //Fetch
        Contact fetchedContact = contactService.getContactById(contact.getAddress().getAddressId());
        assertNotNull(fetchedContact);
        assertEquals(contact.getAddress().getAddressId(), fetchedContact.getAddress().getAddressId());

        //Update
        fetchedContact.getAddress().setStreet("200 UPDATE lane");

        addressService.saveAddress(fetchedContact.getAddress());

        Contact fetchedUpdateContact = contactService.getContactById(fetchedContact.getAddress().getAddressId());
        assertEquals("200 UPDATE lane", fetchedUpdateContact.getAddress().getStreet());

    }

}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */
public interface ContactRepository extends CrudRepository<Contact, Integer>
{

}

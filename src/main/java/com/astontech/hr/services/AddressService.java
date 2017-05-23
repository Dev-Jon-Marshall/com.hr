package com.astontech.hr.services;

import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */
public interface AddressService
{
    Iterable<Address> listAllAddress();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    Iterable<Address> saveAddressList(Iterable<Address> addressIterable);

    void deleteAddress(Integer id);
}

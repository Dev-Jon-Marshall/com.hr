package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
public interface ElementRepository extends CrudRepository<Element, Integer>
{
    //will auto generate required code from the structure of the method name
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findTop3ByIdOrderByElementNameAsc(String elementName);

    List<Element> findAllByElementNameContainingAllIgnoreCase(String contains);

    List<Element> findAllByElementNameStartingWith(String startsWith);

    List<Element> findByIdLessThan(Integer elementId);




}

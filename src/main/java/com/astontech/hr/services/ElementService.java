package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/9/2017.
 */
public interface ElementService
{
    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

    //Custom Repository Methods*******
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    List<Element> findAllByElementNameContainingAllIgnoreCase(String contains);

    List<Element> findAllByElementNameStartingWith(String startsWith);
}

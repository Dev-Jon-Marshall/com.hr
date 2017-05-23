package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/9/2017.
 */
public interface ElementTypeService
{
    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    //Custom Repository Methods*******
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeNameContainingAllIgnoreCase(String contains);

    List<ElementType> findAllByElementTypeNameStartingWith(String startsWith);
}

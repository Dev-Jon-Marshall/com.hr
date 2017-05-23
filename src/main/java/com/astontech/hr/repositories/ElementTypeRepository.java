package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType, Integer>
{
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeNameContainingAllIgnoreCase(String contains);

    List<ElementType> findAllByElementTypeNameStartingWith(String startsWith);
}

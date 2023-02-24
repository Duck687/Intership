package com.ws.Order.repository;

import com.ws.Order.models.PartsList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsListRepository extends CrudRepository<PartsList,Long> {
}

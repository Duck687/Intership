package com.ws.order.repository;

import com.ws.order.models.PartsList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsListRepository extends CrudRepository<PartsList,Long> {
}

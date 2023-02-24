package com.ws.Order.repository;

import com.ws.Order.models.MasterAssignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterAssigRepository extends CrudRepository<MasterAssignments,Long> {
}

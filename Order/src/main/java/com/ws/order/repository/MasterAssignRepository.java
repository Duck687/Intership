package com.ws.order.repository;

import com.ws.order.models.MasterAssignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterAssignRepository extends CrudRepository<MasterAssignments,Long> {
}

package com.ws.order.repository;

import com.ws.order.models.AdministratorAssignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAssignRepository extends CrudRepository<AdministratorAssignments,Long> {
}

package com.ws.Order.repository;

import com.ws.Order.models.AdministratorAssignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAssigRepository extends CrudRepository<AdministratorAssignments,Long> {
}

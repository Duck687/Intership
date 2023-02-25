package com.ws.order.service;

import com.ws.order.models.MasterAssignments;
import com.ws.order.repository.MasterAssigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MastersAssigService {
    @Autowired
    private MasterAssigRepository masterAssigRepository;

    public List<MasterAssignments> getAllMasterAssignments() {
        return (List<MasterAssignments>) masterAssigRepository.findAll();
    }

    public MasterAssignments getMasterAssignmentsById(Long id) {
        return masterAssigRepository.findById(id).get();
    }

    public void saveOrUpdateMasterAssignments(MasterAssignments account) {
        masterAssigRepository.save(account);
    }

    public void deleteMasterAssignments(Long id) {
        masterAssigRepository.deleteById(id);
    }
}

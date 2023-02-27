package com.ws.order.service;

import com.ws.order.models.MasterAssignments;
import com.ws.order.repository.MasterAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MastersAssignService {
    @Autowired
    private MasterAssignRepository masterAssignRepository;

    public List<MasterAssignments> getAllMasterAssignments() {
        return (List<MasterAssignments>) masterAssignRepository.findAll();
    }

    public MasterAssignments getMasterAssignmentsById(Long id) {
        return masterAssignRepository.findById(id).get();
    }

    public void saveOrUpdateMasterAssignments(MasterAssignments account) {
        masterAssignRepository.save(account);
    }

    public void deleteMasterAssignments(Long id) {
        masterAssignRepository.deleteById(id);
    }
}

package com.ws.Order.service;

import com.ws.Order.models.MasterAssignments;
import com.ws.Order.repository.MasterAssigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MastersAssigService {
    @Autowired
    private MasterAssigRepository MasterAssigRepository;

    public List<MasterAssignments> getAllMasterAssignments() {
        return (List<MasterAssignments>) MasterAssigRepository.findAll();
    }

    public MasterAssignments getMasterAssignmentsById(Long id) {
        return MasterAssigRepository.findById(id).get();
    }

    public void saveOrUpdateMasterAssignments(MasterAssignments account) {
        MasterAssigRepository.save(account);
    }

    public void deleteMasterAssignments(Long id) {
        MasterAssigRepository.deleteById(id);
    }
}

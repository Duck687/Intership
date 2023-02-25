package com.ws.order.service;

import com.ws.order.models.AdministratorAssignments;
import com.ws.order.repository.AdminAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAssignService {
    @Autowired
    private AdminAssignRepository adminAssignRepository;
    public List<AdministratorAssignments> getAllAdminAssig() {
        return (List<AdministratorAssignments>) adminAssignRepository.findAll();
    }

    public AdministratorAssignments getAdminAssigById(Long id) {
        return adminAssignRepository.findById(id).get();
    }

    public void saveOrUpdateAdminAssig(AdministratorAssignments account) {
        adminAssignRepository.save(account);
    }

    public void deleteAdminAssig(Long id) {
        adminAssignRepository.deleteById(id);
    }
}

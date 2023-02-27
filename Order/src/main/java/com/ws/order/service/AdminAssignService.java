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
    public List<AdministratorAssignments> getAllAdminAssign() {
        return (List<AdministratorAssignments>) adminAssignRepository.findAll();
    }

    public AdministratorAssignments getAdminAssignById(Long id) {
        return adminAssignRepository.findById(id).get();
    }

    public void saveOrUpdateAdminAssign(AdministratorAssignments account) {
        adminAssignRepository.save(account);
    }

    public void deleteAdminAssign(Long id) {
        adminAssignRepository.deleteById(id);
    }
}

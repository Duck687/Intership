package com.ws.order.service;

import com.ws.order.models.AdministratorAssignments;
import com.ws.order.repository.AdminAssigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAssigService {
    @Autowired
    private AdminAssigRepository adminAssigRepository;
    public List<AdministratorAssignments> getAllAdminAssig() {
        return (List<AdministratorAssignments>) adminAssigRepository.findAll();
    }

    public AdministratorAssignments getAdminiAssigById(Long id) {
        return adminAssigRepository.findById(id).get();
    }

    public void saveOrUpdateAdminAssig(AdministratorAssignments account) {
        adminAssigRepository.save(account);
    }

    public void deleteAdminAssig(Long id) {
        adminAssigRepository.deleteById(id);
    }
}

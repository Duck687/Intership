package com.ws.Order.service;

import com.ws.Order.models.AdministratorAssignments;
import com.ws.Order.repository.AdminAssigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAssigService {
    @Autowired
    private AdminAssigRepository AdminAssigRepository;
    public List<AdministratorAssignments> getAllAdminAssig() {
        return (List<AdministratorAssignments>) AdminAssigRepository.findAll();
    }

    public AdministratorAssignments getAdminiAssigById(Long id) {
        return AdminAssigRepository.findById(id).get();
    }

    public void saveOrUpdateAdminAssig(AdministratorAssignments account) {
        AdminAssigRepository.save(account);
    }

    public void deleteAdminAssig(Long id) {
        AdminAssigRepository.deleteById(id);
    }
}

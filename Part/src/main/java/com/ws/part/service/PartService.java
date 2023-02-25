package com.ws.part.service;

import com.ws.part.models.Part;
import com.ws.part.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;
    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }
    public Part getPartById(Long id) {
        return partRepository.findById(id).get();
    }
    public void saveOrUpdatePart(Part part) {
        partRepository.save(part);
    }
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

}

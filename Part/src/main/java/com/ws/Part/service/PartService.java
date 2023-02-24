package com.ws.Part.service;

import com.ws.Part.models.Part;
import com.ws.Part.repository.PartRepository;
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
    public void saveOrUpdatePart(Part Part) {
        partRepository.save(Part);
    }
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

}

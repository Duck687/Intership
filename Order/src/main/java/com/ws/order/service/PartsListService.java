package com.ws.order.service;

import com.ws.order.models.PartsList;
import com.ws.order.repository.PartsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartsListService {
    @Autowired
    private PartsListRepository partsListRepository;
    public List<PartsList> getAllPartsList() {
        return (List<PartsList>) partsListRepository.findAll();
    }

    public PartsList getPartsListById(Long id) {
        return partsListRepository.findById(id).get();
    }

    public void saveOrUpdatePartsList(PartsList account) {
        partsListRepository.save(account);
    }

    public void deletePartsList(Long id) {
        partsListRepository.deleteById(id);
    }
}

package com.ws.Order.service;

import com.ws.Order.models.PartsList;
import com.ws.Order.repository.PartsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartsListService {
    @Autowired
    private PartsListRepository PartsListRepository;
    public List<PartsList> getAllPartsList() {
        return (List<PartsList>) PartsListRepository.findAll();
    }

    public PartsList getPartsListById(Long id) {
        return PartsListRepository.findById(id).get();
    }

    public void saveOrUpdatePartsList(PartsList account) {
        PartsListRepository.save(account);
    }

    public void deletePartsList(Long id) {
        PartsListRepository.deleteById(id);
    }
}

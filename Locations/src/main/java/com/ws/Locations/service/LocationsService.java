package com.ws.Locations.service;
import com.ws.Locations.models.Locations;
import com.ws.Locations.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }

    public Locations getLocationById(Long id) {
        return locationsRepository.findById(id).get();
    }

    public Locations saveOrUpdateLocation(Locations location) {
        return locationsRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationsRepository.deleteById(id);
    }


}
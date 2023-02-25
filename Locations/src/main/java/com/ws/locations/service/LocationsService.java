package com.ws.locations.service;
import com.ws.locations.models.Locations;
import com.ws.locations.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
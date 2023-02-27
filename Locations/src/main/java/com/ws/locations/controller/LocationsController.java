package com.ws.locations.controller;

import com.ws.locations.models.Locations;
import com.ws.locations.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping("")
    public ResponseEntity<List<Locations>> getAllLocations() {
        List<Locations> locations = locationsService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable Long id) {
        Locations location = locationsService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Locations> createLocation(@RequestBody Locations location) {
        Locations newLocation = locationsService.saveOrUpdateLocation(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locations> updateLocation(@PathVariable Long id, @RequestBody Locations location) {
        Locations updatedLocation = locationsService.saveOrUpdateLocation(location);
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
        locationsService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.ws.Part.controller;


import com.ws.Part.models.Part;
import com.ws.Part.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping("")
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        Part Part = partService.getPartById(id);
        if (Part != null) {
            return new ResponseEntity<>(Part, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void createPart(@RequestBody Part Part) {
        partService.saveOrUpdatePart(Part);
    }

    @PutMapping("/{id}")
    public void updatePart(@PathVariable Long id, @RequestBody Part Part) {
        partService.saveOrUpdatePart(Part);
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable Long id) {
        partService.deletePart(id);
    }
}

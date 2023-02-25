package com.ws.part.controller;


import com.ws.part.models.Part;
import com.ws.part.service.PartService;
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
        Part part = partService.getPartById(id);
        if (part != null) {
            return new ResponseEntity<>(part, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public void createPart(@RequestBody Part part) {
        partService.saveOrUpdatePart(part);
    }

    @PutMapping("/{id}")
    public void updatePart(@PathVariable Long id, @RequestBody Part part) {
        partService.saveOrUpdatePart(part);
    }

    @DeleteMapping("/{id}")
    public void deletePart(@PathVariable Long id) {
        partService.deletePart(id);
    }
}

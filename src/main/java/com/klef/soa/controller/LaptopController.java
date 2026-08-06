package com.klef.soa.controller;

import com.klef.soa.entity.Laptop;
import com.klef.soa.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    // Insert
    @PostMapping
    public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.addLaptop(laptop);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable("id") Long laptopId, @RequestBody Laptop laptop) {
        Laptop updatedLaptop = laptopService.updateLaptop(laptopId, laptop);
        return ResponseEntity.ok(updatedLaptop);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable("id") Long laptopId) {
        String message = laptopService.deleteLaptop(laptopId);
        return ResponseEntity.ok(message);
    }

    // Display All
    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }

    // Display By ID
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable("id") Long laptopId) {
        return ResponseEntity.ok(laptopService.getLaptopById(laptopId));
    }

    // Find By Brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Laptop>> getLaptopsByBrand(@PathVariable("brand") String brand) {
        return ResponseEntity.ok(laptopService.getLaptopsByBrand(brand));
    }

    // Find By Processor
    @GetMapping("/processor/{processor}")
    public ResponseEntity<List<Laptop>> getLaptopsByProcessor(@PathVariable("processor") String processor) {
        return ResponseEntity.ok(laptopService.getLaptopsByProcessor(processor));
    }
}
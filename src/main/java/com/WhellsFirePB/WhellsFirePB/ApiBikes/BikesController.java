package com.WhellsFirePB.WhellsFirePB.ApiBikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ApiBikes/Bikes")
@CrossOrigin(origins = "http://localhost:8080")
public class BikesController {

    private final BikesServices bikeService;

    @Autowired
    public BikesController(BikesServices bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping
    public List<Bikes> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bikes> getBikeById(@PathVariable int id) {
        Optional<Bikes> bike = bikeService.getBikeById(id);
        return bike.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bikes> addBike(@RequestBody Bikes bike) {


        bikeService.addBike(bike);
        return new ResponseEntity<>(bike, HttpStatus.CREATED);
    }
}

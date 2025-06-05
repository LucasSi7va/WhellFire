package com.WhellsFirePB.WhellsFirePB.ApiMotos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ApiMotos/Motos")
@CrossOrigin(origins = "http://localhost:8080")
public class MotosController {

    private final MotosServices motoService;

    @Autowired
    public MotosController(MotosServices motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public List<Motos> getAllMotos() {
        return motoService.getAllMotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motos> getMotoById(@PathVariable int id) {
        Optional<Motos> moto = motoService.getMotoById(id);
        return moto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Motos> addMoto(@RequestBody Motos moto) {
        motoService.addMoto(moto);
        return new ResponseEntity<>(moto, HttpStatus.CREATED);
    }
}

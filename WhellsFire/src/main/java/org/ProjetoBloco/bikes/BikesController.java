package org.ProjetoBloco.bikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikes") // URL base: http://localhost:8080/bikes
public class BikesController {

    @Autowired
    private RepositoryBike repo;

    @GetMapping
    public List<Bikes> listarTodas() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bikes> buscarPorId(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Bikes adicionar(@RequestBody Bikes bikes) {
        return repo.save(bikes);
    }

    @PutMapping("/{id}")
    public Bikes atualizar(@PathVariable Long id, @RequestBody Bikes newBike) {
        return repo.findById(id).map(b -> {
            b.setMarca(newBike.getMarca());
            b.setModelo(newBike.getModelo());
            b.setCor(newBike.getCor());
            b.setTipo(newBike.getTipo());
            b.setPreco(newBike.getPreco());
            return repo.save(b);
        }).orElseGet(() -> {
            newBike.setId(id);
            return repo.save(newBike);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

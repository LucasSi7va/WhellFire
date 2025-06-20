package com.WhellsFirePB.WhellsFirePB.ApiMotos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MotosServices {

    private final List<Motos> motos = new ArrayList<>(Arrays.asList(
            new Motos(1, "Moto Urbana", "Honda", "CG 160", "Urbana", 13000.00, true, "https://honda.com.br/motos/cg160.jpg"),
            new Motos(2, "Trail Off-road", "Yamaha", "XTZ 250", "Trail", 18000.00, true, "https://yamaha.com.br/xtz250.jpg"),
            new Motos(3, "Esportiva", "Kawasaki", "Ninja 400", "Esportiva", 28000.00, false, "https://kawasaki.com.br/ninja400.jpg"),
            new Motos(4, "Scooter", "Honda", "PCX 160", "Scooter", 15500.00, true, "https://honda.com.br/pcx160.jpg"),
            new Motos(5, "Custom", "Harley-Davidson", "Iron 883", "Custom", 50000.00, false, "https://harley.com/iron883.jpg"),
            new Motos(6, "Naked", "BMW", "G 310 R", "Naked", 32000.00, true, "https://bmw-motorrad.com/g310r.jpg")
    ));

    public List<Motos> getAllMotos() {
        return motos;
    }

    public Optional<Motos> getMotoById(int id) {
        return motos.stream().filter(m -> m.getId() == id).findFirst();
    }

    public void addMoto(Motos moto) {
        motos.add(moto);
    }
}

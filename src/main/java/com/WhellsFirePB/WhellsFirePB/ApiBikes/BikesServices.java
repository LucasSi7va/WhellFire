package com.WhellsFirePB.WhellsFirePB.ApiBikes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BikesServices {

    private final List<Bikes> bikes = new ArrayList<>(Arrays.asList(
            new Bikes(1, "Bike Urbana", "Caloi", "City Tour", "Urbana", 1500.00, true, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR9n1i3-rDvsNZHmYRSXpdfWTJ-o1QhmKcapsKHTHFvM7c7g1kNODeNx7Y7W6g7"),
            new Bikes(2, "Mountain Bike", "Specialized", "Rockhopper", "MTB", 3200.00, false, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ4IZj6ylDaRs5Ux5bTlJ6YWxp9KzKfeBaF75sHqgLxeG1xg5A5OCZHekvY7cKi"),
            new Bikes(3, "Speed Racer", "Cannondale", "SuperSix EVO", "Speed", 8900.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTsmeemNB6tbzfvQOL4Mqg283E3CG6RmsVdB-oo1GaBdycE6DbomCKk-OZPINZQ"),
            new Bikes(4, "Elétrica Compacta", "Sense", "Easy", "Elétrica", 4200.00, true, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTeJ10m0H0kiAbXGT9wjxadDr5IxAsnz6noyi4bd6ZpFd40d50QrYc9kAQqBAUm"),
            new Bikes(5, "Bike Infantil", "Houston", "Kids Fun", "Infantil", 800.00, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfh68KmBQn7gymZRDRx0cg8K0VoqZhBIjdPgS2QauOJRq6-AAy3rh6TBATv_TG"),
            new Bikes(6, "Dobrável Urbana", "Durban", "Bay 6", "Dobrável", 1350.00, false, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQVp-GYOeI9xUn_qC_sVZCFvw4gEQarZRciaG7r3JNQSaaKSEfh8EG2bJ4Tl8t5"),
            new Bikes(7, "Gravel Explorer", "Trek", "Checkpoint ALR", "Gravel", 6100.00, true, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS7Bda_a7QqVxQZm3bqS9-XR5GF0RVrTWiEQ0-Ht0LfyXmmmllfcCW0KYPiY6ON"),
            new Bikes(8, "Speed Pro", "Scott", "Addict RC", "Speed", 9500.00, false, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwIvabqkUYTUvwjNl-kpH4yU9AipW7UGtj6OrVzUX_U0ZFKmVGW1qaDI-Pl5mf"),
            new Bikes(9, "MTB Agressiva", "GT", "Avalanche", "MTB", 2800.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcShkWgRJXntBCBgm9tT3AoFA-oRvSoIOAYtmo7qHOuHZLg-j-_GHPCzmCKqCPS3"),
            new Bikes(10, "E-Bike Urbana", "Caloi", "E-Vibe", "Elétrica", 4700.00, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiHh_29cbltaMY--bWFl-JL9aYz7vABEuuhinEvCQvIBMgbmLW_VicQKYHGPpt"),
            new Bikes(11, "Bike Retrô", "Monark", "Barra Circular", "Urbana", 950.00, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHlzmAN9cMZIwv2K2r4WZJqgwy-Mja2DGMXVy3K21oUJLLOdssDGLEgBb1Ncur"),
            new Bikes(12, "Infantil Aro 16", "Track", "Toy Bike", "Infantil", 650.00, true, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS9Yka8Jw0b6VPPp80DXHRjYmIsfVjXadKoZpaB9ppvv7f2i2gbyMw1JvTAjLrL"),
            new Bikes(13, "Elétrica Power", "Oggi", "Big Wheel", "Elétrica", 5300.00, false, "https://viverdebike.com.br/wp-content/uploads/2020/11/2019-Recon-2-1024x768.jpg"),
            new Bikes(14, "MTB Trail", "Sense", "Impact", "MTB", 3900.00, true, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcThemr77fowFb9OfmiHwUfDshRQPiJpjPNkjdPz9eQsoTIsGdhWFiJYq_VPB6-z"),
            new Bikes(15, "Bike Simples", "KSW", "Aro 29", "Urbana", 1100.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSmpJksIj0y1sdhYk_DpDVKMYgAhj0fEX2h7ObQgTVEIFK1uP1tHtNyCwJRVcv4"),
            new Bikes(16, "Speed Leve", "Giant", "Contend", "Speed", 7200.00, false, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTRZ8ssv99TBcOY-AW6zIwPo3zh_WQlolgiH6CxFzXTmYgDsnCTNYF_7VdThs9J"),
            new Bikes(17, "Gravel Light", "Cannondale", "Topstone", "Gravel", 5600.00, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPVemeHt2eauNRHN5Ska68WUHSEhR0Rfw5PkerixAkD488v_xSBCBog_GLnzo5"),
            new Bikes(18, "Dobrável Compact", "Durban", "One", "Dobrável", 1200.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcShZjKlXi5GvxZKFAzcE24zU7w5mPxCc3EuAB1flkuzzXlfS5TcTJ61NzWK3JNI"),
            new Bikes(19, "Elétrica City", "Lev", "Smart", "Elétrica", 3900.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQokM3Un1oLLSJ0S6znvL7Sj2fJF7B-2B3CNNwPSjOMB87UT6-H59sTIGQucZlM"),
            new Bikes(20, "Infantil Radical", "Colli", "Kids Max", "Infantil", 720.00, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQShrAC1K2q96Hk4EjScsnFY09-UQEV-RFq3ciPBuXzRTtbvYgAdR82IdeTu3Ha")
    ));

    public List<Bikes> getAllBikes() {
        return bikes;
    }

    public Optional<Bikes> getBikeById(int id) {
        return bikes.stream()
                .filter(bike -> bike.getId() == id)
                .findFirst();
    }


    public void addBike(Bikes bike) {

        this.bikes.add(bike);
    }

}

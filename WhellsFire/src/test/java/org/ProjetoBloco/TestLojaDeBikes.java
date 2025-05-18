package org.ProjetoBloco;

import CadastroLogin.Cadastro;
import CadastroLogin.Login;
import org.ProjetoBloco.API.ApiDeBikes;
import org.ProjetoBloco.bikes.Bikes;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestLojaDeBikes {

    @Test
    void testCadastro() {
        Cadastro cadastro = new Cadastro();
        cadastro.cadastrar();
        System.out.println("Cadastro realizado com sucesso");
        System.out.println("Realizar o login");
        Login.realizarLogin(cadastro);
    }


    @Test
    void testListarBikes() {
        ApiDeBikes api = new ApiDeBikes();
        List<Bikes> bikes = api.buscarBikes();

        System.out.println("\nLista de bikes:");
        for (Bikes bike : bikes) {
            System.out.println("Id: " + bike.getId() + " | Marca: " + bike.getMarca() + " | Modelo: " + bike.getModelo());
        }
    }
}

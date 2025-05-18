package org.ProjetoBloco;

import CadastroLogin.Cadastro;
import CadastroLogin.Login;
import org.ProjetoBloco.API.ApiDeBikes;
import org.ProjetoBloco.bikes.Bikes;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {

            Cadastro cadastro = new Cadastro();
            cadastro.cadastrar();
            Login login = new Login();
            login.realizarLogin(cadastro);
            System.out.println("Login realizado com sucesso");

        ApiDeBikes api = new ApiDeBikes();
        List<Bikes> bikes = api.buscarBikes();

        System.out.println("\nLista de bikes:");
        for (Bikes bike : bikes) {
            System.out.println("Id: " + bike.getId() + " | Marca: " + bike.getMarca() + " | Modelo: " + bike.getModelo());
        }

    }
}

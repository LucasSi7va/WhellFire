package CadastroLogin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cadastro {
    public   String nome;
     public String senha;

     public  LocalDate nascimento;


    Scanner scanner = new Scanner(System.in);
    public Cadastro() {

    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void cadastrar(){
        System.out.println("Insira o cadastro");
        System.out.println("Digite o nome: ");
        this.nome = scanner.nextLine();
        System.out.println("Digite a senha: ");
        this.senha = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValida = false;

        while(!dataValida){
        try {
            System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
            this.nascimento = LocalDate.parse(scanner.nextLine(), formatter);
            dataValida = true;

        } catch (Exception e) {
            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
        }

        }


    }
}

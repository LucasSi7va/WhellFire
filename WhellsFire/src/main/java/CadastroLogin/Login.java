package CadastroLogin;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Login {
 public static  void cadastrarLogin() {
     Cadastro cadastro = new Cadastro();

     cadastro.cadastrar();

     System.out.println("cadastro realizado com sucesso");
     System.out.println("usuario: " + cadastro.getNome() + "\n senha: " + cadastro.getSenha());

 }



    public static void realizarLogin(@NotNull Cadastro cadastro){

      boolean loginValido = false;


      while(!loginValido) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Digite o nome: ");
          String nome = scanner.nextLine();
          System.out.println("Digite a senha: ");
          String senha = scanner.nextLine();

          if (nome.equals(cadastro.getNome()) && senha.equals(cadastro.getSenha())) {
              System.out.println("Login realizado com sucesso");
              loginValido = true;
          } else {
              System.out.println("Login falhou");
          }
      }
    }


}

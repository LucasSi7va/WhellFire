package com.WhellsFirePB.WhellsFirePB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }


    @GetMapping("/index")
    public String home(){
        return "index";
    }

@GetMapping("/aluguelOuCompra")
    public String aluguelOuCompra(){
        return "aluguelOuCompra";
}

@GetMapping("/aluguel")
    public String aluguel(){
        return "aluguel";
}

@GetMapping("/pagamento")
    public String pagamento(){
        return "pagamento";
}


}

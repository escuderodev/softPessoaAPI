package br.com.escuderodev.soft.pessoa.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/source")
public class DocumentacaoController {

    @GetMapping
    public String linksUteis() {
        return """
                <br>
                === Links Úteis ===
                <br>
                <a href='https://github.com/escuderodev/softPessoaAPI' target="_blank">GitHub do Projeto</a>
                <br>
                <a href='http://localhost/swagger-ui/index.html#/' target="_blank">Documentação com Swagger</a>
                <br>
                <a href='https://www.linkedin.com/in/escuderodev/' target="_blank">Linkedin</a>
               
                <br>
                <br>
                === Contatos ===
                <br>
                Eduardo Escudero
                <br>
                fone: (11) 95500-5284
                """;
    }
}

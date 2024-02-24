package br.com.escuderodev.soft.pessoa.controller;

import br.com.escuderodev.soft.pessoa.model.DadosAtualizaPessoa;
import br.com.escuderodev.soft.pessoa.model.DadosCadastroPessoa;
import br.com.escuderodev.soft.pessoa.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class PessoaControllerMVC {

    @Autowired
    private PessoaService service;

    @GetMapping("formulario")
    public String loadRegistrationForm(Long id, Model model) {
        if (id != null) {
            var pessoa = service.findById(id);
            System.out.println(pessoa.getSexo());
            model.addAttribute("pessoa", pessoa);
        }
        return "pessoa/cadastro";
    }

    @GetMapping("lista")
    public String loadListPessoa(Model model) {
        model.addAttribute("pessoas", service.findAllNotPageable());
        return "pessoa/listagem";
    }

    @PostMapping
    @Transactional
    public String create(DadosCadastroPessoa dados) {
        service.create(dados);
        return "redirect:/app/lista";
    }

    @PutMapping
    @Transactional
    public String update(DadosAtualizaPessoa dados) {
        service.update(dados);
        return "redirect:/app/lista";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id) {
        service.delete(id);
        return "redirect:/app/lista";
    }
}
package br.com.escudero.cadastro.pessoa.controler;

import br.com.escudero.cadastro.pessoa.dao.IPessoa;
import br.com.escudero.cadastro.pessoa.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private IPessoa dao;

    @GetMapping
    public List<Pessoa> listaDePessoas() {
        return (List<Pessoa>) dao.findAll();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaNova = dao.save(pessoa);
        return pessoaNova;
    }

    @PutMapping
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaNova = dao.save(pessoa);
        return pessoaNova;
    }

    @DeleteMapping("/{idpessoa}")
    public Optional<Pessoa> excluirPessoa(@PathVariable Integer idpessoa) {
        Optional<Pessoa> pessoa = dao.findById(idpessoa);
        dao.deleteById(idpessoa);
        return pessoa;
    }

}

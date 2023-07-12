package br.com.escuderodev.soft_java_api.controller;

import br.com.escuderodev.soft_java_api.domain.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = repository.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPessoa(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);
        var uri = uriBuilder.path("pessoa/{idpessoa}").buildAndExpand(pessoa.getIdpessoa()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhaPessoa(pessoa));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPessoa(@RequestBody @Valid DadosAtualizaPessoa dados) {
        var pessoa = repository.getReferenceById(dados.idpessoa());
        pessoa.atualizaDados(dados);
        return ResponseEntity.ok(new DadosDetalhaPessoa(pessoa));
    }

    @DeleteMapping("/{idpessoa}")
    @Transactional
    public ResponseEntity deletarPessoaPorId(@PathVariable Long idpessoa) {
        var pessoa = repository.getReferenceById(idpessoa);
        repository.deleteById(idpessoa);
        return ResponseEntity.noContent().build();
    }
}

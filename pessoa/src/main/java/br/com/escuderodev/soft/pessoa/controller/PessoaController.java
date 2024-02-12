package br.com.escuderodev.soft.pessoa.controller;

import br.com.escuderodev.soft.pessoa.model.DadosAtualizaPessoa;
import br.com.escuderodev.soft.pessoa.model.DadosCadastroPessoa;
import br.com.escuderodev.soft.pessoa.model.DadosListagemPessoa;
import br.com.escuderodev.soft.pessoa.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>> findAllPessoa(@PageableDefault(size = 10,page = 0,sort = {"id"})Pageable pagination) {
        var page = service.findAll(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity findPessoaById(@PathVariable Long id) {
        var pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    @Transactional
    public ResponseEntity createPessoa(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = service.create(dados);
        var uri = uriBuilder.path("pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePessoa(@RequestBody @Valid DadosAtualizaPessoa dados) {
        service.update(dados);
        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePessoa(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

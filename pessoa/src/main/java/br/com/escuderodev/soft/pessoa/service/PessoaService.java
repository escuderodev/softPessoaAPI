package br.com.escuderodev.soft.pessoa.service;

import br.com.escuderodev.soft.pessoa.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Page<DadosListagemPessoa> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"})Pageable pagination) {
        return repository.findAll(pagination).map(DadosListagemPessoa::new);
    }

    public Pessoa findById(Long id) {
        return repository.getReferenceById(id);
    }

    public Pessoa create(DadosCadastroPessoa dados) {
        var pessoa = new Pessoa(dados);
        return repository.save(pessoa);
    }

    public Pessoa update(DadosAtualizaPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizaDados(dados);
        return pessoa;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

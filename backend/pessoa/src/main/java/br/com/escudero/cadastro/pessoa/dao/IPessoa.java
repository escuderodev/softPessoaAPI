package br.com.escudero.cadastro.pessoa.dao;

import br.com.escudero.cadastro.pessoa.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface IPessoa extends CrudRepository<Pessoa, Integer> {
}

package br.com.escuderodev.softapi.dao;

import br.com.escuderodev.softapi.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface IPessoa extends CrudRepository<Pessoa, Integer> {
}


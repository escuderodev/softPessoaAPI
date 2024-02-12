package br.com.escuderodev.soft.pessoa.model;

import java.time.LocalDate;

public record DadosListagemPessoa(
        Long id,
        String nome,
        Sexo sexo,
        String email,
        LocalDate dataNascimento,
        String naturalidade,
        String nacionalidade,
        String cpf
) {
        public DadosListagemPessoa(Pessoa pessoa) {
                this(pessoa.getId(), pessoa.getNome(), pessoa.getSexo(), pessoa.getEmail(), pessoa.getDataNascimento(), pessoa.getNaturalidade(), pessoa.getNacionalidade(), pessoa.getCpf());
        }
}

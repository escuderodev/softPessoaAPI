package br.com.escuderodev.soft_java_api.domain.pessoa;

import java.time.LocalDate;

public record DadosDetalhaPessoa(Long idpessoa, String nome, String sexo, String email, LocalDate dataDeNascimento,
        String naturalidade, String nacionalidade, String cpf) {

    public DadosDetalhaPessoa(Pessoa pessoa) {
        this(pessoa.getIdpessoa(), pessoa.getNome(), pessoa.getSexo(), pessoa.getEmail(), pessoa.getDataDeNascimento(),
                pessoa.getNaturalidade(), pessoa.getNacionalidade(), pessoa.getCpf());
    }
}

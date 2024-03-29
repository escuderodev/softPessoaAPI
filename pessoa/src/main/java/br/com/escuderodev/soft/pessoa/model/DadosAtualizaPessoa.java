package br.com.escuderodev.soft.pessoa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosAtualizaPessoa(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotNull
        Sexo sexo,
        @Email
        String email,
        @NotNull
        LocalDate dataNascimento,
        String naturalidade,
        String nacionalidade,
        @NotBlank @CPF
        String cpf
) {
}

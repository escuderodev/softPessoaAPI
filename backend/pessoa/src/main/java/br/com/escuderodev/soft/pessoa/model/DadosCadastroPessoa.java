package br.com.escuderodev.soft.pessoa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @Enumerated
        Sexo sexo,
        @Email
        String email,
        LocalDate dataNascimento,
        String naturalidade,
        String nacionalidade,
        @NotBlank @CPF
        String cpf
) {
}

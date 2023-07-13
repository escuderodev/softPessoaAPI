package br.com.escuderodev.soft_java_api.models.pessoa;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank(message = "o nome é obrigatório!")
        String nome,
        String sexo,
        String email,
        @NotNull(message = "a data de nascimento é obrigatória!")
        LocalDate dataDeNascimento,
        String naturalidade,
        String nacionalidade,
        @NotNull(message = "o cpf é obrigatório!")
        @Column(nullable = false, length = 14, unique=true)
        String cpf
) {
}

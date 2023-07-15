package br.com.escuderodev.soft_java_api.models.usuario;

import javax.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank(message = "o nome é obrigatório!")
        String nome,
        @NotBlank(message = "o username é obrigatório!")
        String username,
        @NotBlank(message = "o password é obrigatório!")
        String password) {
}

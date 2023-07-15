package br.com.escuderodev.soft_java_api.models.usuario;

public record DadosDetalhaUsuario(Long idusuario, String nome, String username, String password) {

    public DadosDetalhaUsuario(Usuario usuario) {
        this(usuario.getIdusuario(), usuario.getNome(), usuario.getUsername(), usuario.getPassword());
    }
}

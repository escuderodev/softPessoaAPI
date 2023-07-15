package br.com.escuderodev.soft_java_api.controller;

import br.com.escuderodev.soft_java_api.models.pessoa.*;
import br.com.escuderodev.soft_java_api.models.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        repository.save(usuario);
        var uri = uriBuilder.path("usuario/{idusuario}").buildAndExpand(usuario.getIdusuario()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhaUsuario(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody @Valid DadosAtualizaUsuario dados) {
        var usuario = repository.getReferenceById(dados.idusuario());
        usuario.atualizaDados(dados);
        return ResponseEntity.ok(new DadosDetalhaUsuario(usuario));
    }

    @DeleteMapping("/{idusuario}")
    @Transactional
    public ResponseEntity deletarUsuarioPorId(@PathVariable Long idusuario) {
        var usuario = repository.getReferenceById(idusuario);
        repository.deleteById(idusuario);
        return ResponseEntity.noContent().build();
    }
}

package br.com.escuderodev.soft_java_api.models.usuario;

import br.com.escuderodev.soft_java_api.models.pessoa.DadosAtualizaPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Collection;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@Setter
@ToString
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    private Timestamp createDate;
    @UpdateTimestamp
    private Timestamp updateDate;

    public Usuario(@Valid DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.username = dados.username();
        this.password = dados.password();
    }

    public Usuario() {
    }

    public void atualizaDados(@Valid DadosAtualizaUsuario dados) {
        this.nome = dados.nome();
        this.username = dados.username();
        this.password = dados.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

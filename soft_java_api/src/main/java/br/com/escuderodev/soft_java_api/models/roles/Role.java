package br.com.escuderodev.soft_java_api.models.roles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "role")
@Getter
@Setter
@ToString
public class Role implements GrantedAuthority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}

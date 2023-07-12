package br.com.escuderodev.soft_java_api.domain.pessoa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "Pessoa")
@Table(name = "pessoa")
@Getter
@Setter
@ToString
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpessoa;
    private String nome;
    private String sexo;
    private String email;
    private LocalDate dataDeNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    @CreationTimestamp
    private Timestamp createDate;
    @UpdateTimestamp
    private Timestamp updateDate;

    public Pessoa( @Valid DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.naturalidade = dados.naturalidade();
        this.nacionalidade = dados.nacionalidade();
        this.cpf = dados.cpf();
    }

    public Pessoa() {
    }

    public void atualizaDados(@Valid DadosAtualizaPessoa dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.naturalidade = dados.naturalidade();
        this.nacionalidade = dados.nacionalidade();
        this.cpf = dados.cpf();
    }

}

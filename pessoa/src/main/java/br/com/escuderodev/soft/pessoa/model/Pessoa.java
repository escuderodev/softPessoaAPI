package br.com.escuderodev.soft.pessoa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Pessoa")
@Table(name = "pessoas")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String email;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    @Column(unique = true)
    private String cpf;
    @CreationTimestamp
    private LocalDateTime dataDeCadastro;
    @UpdateTimestamp
    private LocalDateTime dataDeAtualizacao;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.dataNascimento = dados.dataNascimento();
        this.naturalidade = dados.naturalidade();
        this.nacionalidade = dados.nacionalidade();
        this.cpf = dados.cpf();
    }

    public Pessoa() {
    }

    public void atualizaDados(DadosAtualizaPessoa dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.dataNascimento = dados.dataNascimento();
        this.naturalidade = dados.naturalidade();
        this.nacionalidade = dados.nacionalidade();
        this.cpf = dados.cpf();
    }
}

package br.com.escudero.cadastro.pessoa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Integer idpessoa;

    @Column(name = "nome", length = 150, nullable = true)
    private String nome;
    @Column(name = "sexo", length = 1)
    private String sexo;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "dtnascimento", length = 10, nullable = true)
    private String dataNascimento;
    @Column(name = "naturalidade", length = 50)
    private String naturalidade;
    @Column(name = "nacionalidade", length = 50)
    private String nacionalidade;
    @Column(name = "cpf", length = 14, nullable = true)
    private String cpf;

//    getters and setters
    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

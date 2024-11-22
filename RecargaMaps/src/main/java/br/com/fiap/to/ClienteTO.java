package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class ClienteTO {

    private Long codigo;
    @NotBlank private String nome;
    @NotBlank private String cpf;
    @Email private String email;
    @Past private LocalDate dataDeNascimento;


    public ClienteTO() {}

    public ClienteTO(Long codigo, String nome, String cpf, String email, LocalDate dataDeNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Past LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(@Past LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int realizarRecarga(int valor) {
        System.out.println("Recarga realizada com o valor de: " + valor);
        return valor;
    }

    public int realizarPagamento(int valor) {
        System.out.println("Pagamento realizado com o valor de: " + valor);
        return valor;
    }

}

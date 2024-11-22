package br.com.fiap.to;

import java.time.LocalTime;

public class EstacaoTO {
    private Long codigo;
    private String nome;
    private Double preco;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeFechamento;
    private Boolean bombaDisponivel;

    public EstacaoTO() {
    }

    public EstacaoTO(Long codigo, String nome, Double preco, LocalTime horarioDeAbertura, LocalTime horarioDeFechamento, Boolean bombaDisponivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.horarioDeAbertura = horarioDeAbertura;
        this.horarioDeFechamento = horarioDeFechamento;
        this.bombaDisponivel = bombaDisponivel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalTime getHorarioDeAbertura() {
        return horarioDeAbertura;
    }

    public void setHorarioDeAbertura(LocalTime horarioDeAbertura) {
        this.horarioDeAbertura = horarioDeAbertura;
    }

    public LocalTime getHorarioDeFechamento() {
        return horarioDeFechamento;
    }

    public void setHorarioDeFechamento(LocalTime horarioDeFechamento) {
        this.horarioDeFechamento = horarioDeFechamento;
    }

    public Boolean getBombaDisponivel() {
        return bombaDisponivel;
    }

    public void setBombaDisponivel(Boolean bombaDisponivel) {
        this.bombaDisponivel = bombaDisponivel;
    }

    public String consultarEstacao() {
        // Simulação de consulta
        String statusBomba = bombaDisponivel ? "disponível" : "indisponível";
        return "Estação: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Horário: " + horarioDeAbertura + " - " + horarioDeFechamento + "\n" +
                "Bomba: " + statusBomba;
    }
}

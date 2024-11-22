package br.com.fiap.to;

import java.time.LocalDate;
import java.util.Date;

public class ManutencaoTO {
    private Long codigo;
    private LocalDate dataManutencao;
    private String descricao;
    private String responsavel;

    public ManutencaoTO() {
    }

    public ManutencaoTO(Long codigo, LocalDate dataManutencao, String descricao, String responsavel) {
        this.codigo = codigo;
        this.dataManutencao = dataManutencao;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public boolean validarResponsavel() {
        return responsavel != null && !responsavel.isEmpty();
    }

    public String obterResumoManutencao() {
        return "Manutenção realizada em " + dataManutencao + " por " + responsavel + ". Descrição: " + descricao;
    }
}

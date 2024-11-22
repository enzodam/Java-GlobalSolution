package br.com.fiap.to;

import java.sql.Date;
import java.time.LocalDate;

public class CashBackTO {
    private Long codigo;
    private Double valorAcumulado;
    private Double valorUtilizado;
    private LocalDate dataUltimaAtualizacao;

    public CashBackTO() {
    }

    public CashBackTO(Long codigo, Double valorAcumulado, Double valorUtilizado, LocalDate dataUltimaAtualizacao) {
        this.codigo = codigo;
        this.valorAcumulado = valorAcumulado;
        this.valorUtilizado = valorUtilizado;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(Double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public void setValorUtilizado(Double valorUtilizado) {
        this.valorUtilizado = valorUtilizado;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public void registrarValor(double valor) {
        this.valorAcumulado += valor;
        this.dataUltimaAtualizacao = LocalDate.now();
    }

    public boolean utilizarValor(double valor) {
        if (valor <= valorAcumulado) {
            this.valorAcumulado -= valor;
            this.valorUtilizado += valor;
            this.dataUltimaAtualizacao = LocalDate.now();
            return true;
        }
        return false;
    }
}

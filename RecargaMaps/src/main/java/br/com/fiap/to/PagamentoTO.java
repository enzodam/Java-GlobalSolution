package br.com.fiap.to;

import java.sql.Date;
import java.time.LocalDate;

public class PagamentoTO {
    private Long codigo;
    private String metodoPagamento;
    private Double valorPago;
    private LocalDate dataPagamento;

    public PagamentoTO() {
    }

    public PagamentoTO(Long codigo, String metodoPagamento, Double valorPago, LocalDate dataPagamento) {
        this.codigo = codigo;
        this.metodoPagamento = metodoPagamento;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String efetuarPagamento() {
        return "Pagamento de R$" + valorPago + " realizado com sucesso via " + metodoPagamento + "!";
    }

    public boolean validarPagamento() {
        return valorPago > 0;
    }
}

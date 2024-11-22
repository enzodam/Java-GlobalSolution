package br.com.fiap.to;

import java.time.LocalDate;

public class RecargaTO {
    private Long codigo;
    private LocalDate dataRecarga;
    private Double valorCobrado;

    public RecargaTO() {
    }

    public RecargaTO(Long codigo, LocalDate dataRecarga, Double valorCobrado) {
        this.codigo = codigo;
        this.dataRecarga = dataRecarga;
        this.valorCobrado = valorCobrado;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataRecarga() {
        return dataRecarga;
    }

    public void setDataRecarga(LocalDate dataRecarga) {
        this.dataRecarga = dataRecarga;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public String processarRecarga() {
        return "Recarga realizada no valor de R$" + valorCobrado + " na data " + dataRecarga + ".";
    }

    public boolean validarRecarga() {
        return valorCobrado > 0;
    }
}

package br.com.fiap.to;

public class CarroTO {
    private Long codigo;
    private String placa;
    private String modelo;
    private int ano;

    public CarroTO() {
    }

    public CarroTO(Long codigo, String placa, String modelo, int ano) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public boolean anoCarro() {
        int anoAtual = java.time.Year.now().getValue();
        return (anoAtual - ano) <= 5;
    }

    public String descricaoDoCarro() {
        String modeloDesc = (modelo != null) ? modelo : "Modelo não informado";
        String placaDesc = (placa != null) ? placa : "Placa não informada";
        String anoDesc = (ano > 0) ? String.valueOf(ano) : "Ano não informado";

        return "Modelo: " + modeloDesc + " | Placa: " + placaDesc + " | Ano: " + anoDesc;


    }
}

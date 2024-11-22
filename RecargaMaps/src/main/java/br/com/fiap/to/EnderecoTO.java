package br.com.fiap.to;

public class EnderecoTO {
    private Long codigo;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoTO() {
    }

    public EnderecoTO(Long codigo, String rua, Integer numero, String cidade, String estado, String cep) {
        this.codigo = codigo;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String obterEnderecoCompleto() {
        return rua + ", " + cidade + " - " + estado + " (" + cep + ")";
    }

    public boolean validarCEP() {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}

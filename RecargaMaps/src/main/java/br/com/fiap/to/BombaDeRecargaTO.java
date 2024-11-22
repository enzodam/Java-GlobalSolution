package br.com.fiap.to;

public class BombaDeRecargaTO {
    private Long codigo;
    private String tipoBomba;

    public BombaDeRecargaTO() {
    }

    public BombaDeRecargaTO(Long codigo, String tipoBomba) {
        this.codigo = codigo;
        this.tipoBomba = tipoBomba;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoBomba() {
        return tipoBomba;
    }

    public void setTipoBomba(String tipoBomba) {
        this.tipoBomba = tipoBomba;
    }

    public String ativarBomba() {
        return "Bomba do tipo " + tipoBomba + " ativada!";
    }

    public boolean verificarDisponibilidade() {
        return true; // Simulação de disponibilidade
    }
}

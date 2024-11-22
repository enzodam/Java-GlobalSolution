package br.com.fiap.to;

public class AvaliacaoTO {
    private Long codigo;
    private Integer nota;
    private String comentario;

    public AvaliacaoTO() {
    }

    public AvaliacaoTO(Long codigo, Integer nota, String avaliacao) {
        this.codigo = codigo;
        this.nota = nota;
        this.comentario = avaliacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean validarNota() {
        return nota >= 1 && nota <= 5;
    }

    public String gerarResumoAvaliacao() {
        return "Nota: " + nota + " - " + comentario;
    }
}

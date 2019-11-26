package br.com.douglasonofre.deephelper.dados;

public class Meta {
    private int id;
    private String texto;
    private String completado;
    private String prioridade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String isCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}

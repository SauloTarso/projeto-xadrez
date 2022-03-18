package jogoDeTabuleiro;

public class Posicao {

    private Integer fila;
    private Integer coluna;

    public Posicao() {
    }

    public Posicao(Integer fila, Integer coluna) {
        this.fila = fila;
        this.coluna = coluna;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return fila + ", " + coluna;
    }
}

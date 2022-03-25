package jogoDeTabuleiro;

public class Tabuleiro {

    private Integer linhas;
    private Integer colunas;
    private Peca[][] pecas;

    public Tabuleiro(Integer linhas, Integer colunas) {
        if (linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro criando tabuleiro: deverá ter ao menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public Integer getLinhas() {
        return linhas;
    }

    public Integer getColunas() {
        return colunas;
    }

    public Peca peca (int linhas, int colunas){
        if (!posicaoExiste(linhas,colunas)){
            throw new TabuleiroException("Posição não está no tabuleiro.");
        }
        return pecas[linhas][colunas];
    }

    public Peca peca (Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não existe no tabuleiro.");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao){
        if (existeUmaPeca(posicao)){
            throw new TabuleiroException("Já existe uma peça na posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        if (peca(posicao) == null){
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }

    private boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean existeUmaPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não está no tabuleiro.");
        }
        return peca(posicao) != null;
    }
}

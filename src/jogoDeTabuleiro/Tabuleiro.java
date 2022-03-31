package jogoDeTabuleiro;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro criando tabuleiro: devera ter ao menos 1 linha e 1 coluna");
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
            throw new TabuleiroException("Posicao nao existe no tabuleiro.");
        }
        return pecas[linhas][colunas];
    }

    public Peca peca (Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posicao nao existe no tabuleiro.");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao){
        if (existeUmaPeca(posicao)){
            throw new TabuleiroException("Ja existe uma peca na posicao " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new TabuleiroException("Posicao nao existe no tabuleiro");
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
            throw new TabuleiroException("Posicao nao esta no tabuleiro.");
        }
        return peca(posicao) != null;
    }
}

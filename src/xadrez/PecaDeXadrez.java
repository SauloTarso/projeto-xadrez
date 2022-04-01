package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {

    private Cor cor;
    private int contagemDeMovimento;

    public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public int getContagemDeMovimento(){
        return contagemDeMovimento;
    }

    public void incrementarContagemDeMovimento(){
        contagemDeMovimento++;
    }

    public void decrementarContagemDeMovimento(){
        contagemDeMovimento--;
    }

    public PosicaoXadrez getPosicaoXadrez(){
        return PosicaoXadrez.daPosicao(posicao);
    }

    protected boolean exitePecaAdversario (Posicao posicao){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
}


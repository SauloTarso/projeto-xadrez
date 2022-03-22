package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import pecas.xadres.Rei;
import pecas.xadres.Torre;

public class PartidaDeXadrez {

    private Tabuleiro tabuleiro;

    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        initialSetup();
    }

    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i,j);
            }
            
        }
        return matriz;
    }

    private void initialSetup(){
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2,1));
        tabuleiro.colocarPeca(new Rei(tabuleiro,Cor.PRETO), new Posicao(0,4));
        tabuleiro.colocarPeca(new Rei(tabuleiro,Cor.BRANCO), new Posicao(7,4));
    }
}

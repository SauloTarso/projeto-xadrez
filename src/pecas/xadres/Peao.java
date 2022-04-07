package pecas.xadres;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez {

    private PartidaDeXadrez partidaDeXadrez;

    public Peao(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaDeXadrez) {
        super(tabuleiro, cor);
        this.partidaDeXadrez = partidaDeXadrez;
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        if (getCor() == Cor.BRANCO) {
            p.setValores(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p) && (getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemDeMovimento() == 0)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && exitePecaAdversario(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && exitePecaAdversario(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            //#movimento especial en passant branco
            if (posicao.getLinha() == 3){
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if (getTabuleiro().posicaoExiste(esquerda) && exitePecaAdversario(esquerda) && getTabuleiro().peca(esquerda) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
                }Posicao direito = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if (getTabuleiro().posicaoExiste(direito) && exitePecaAdversario(direito) && getTabuleiro().peca(direito) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[direito.getLinha() - 1][direito.getColuna()] = true;
                }
            }

        } else {
            p.setValores(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existeUmaPeca(p) && (getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existeUmaPeca(p2) && getContagemDeMovimento() == 0)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().posicaoExiste(p) && exitePecaAdversario(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if (getTabuleiro().posicaoExiste(p) && exitePecaAdversario(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            //#movimento especial en passant preto
            if (posicao.getLinha() == 4){
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if (getTabuleiro().posicaoExiste(esquerda) && exitePecaAdversario(esquerda) && getTabuleiro().peca(esquerda) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
                }Posicao direito = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if (getTabuleiro().posicaoExiste(direito) && exitePecaAdversario(direito) && getTabuleiro().peca(direito) == partidaDeXadrez.getEnPassantVulneravel()){
                    mat[direito.getLinha() + 1][direito.getColuna()] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "p";
    }
}

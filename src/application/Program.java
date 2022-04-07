package application;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
        List<PecaDeXadrez> capturar = new ArrayList<>();

        while (!partidaDeXadrez.getCheckMate()) {
            try {
                UI.limparTela();
                UI.imprimirPartida(partidaDeXadrez, capturar);
                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                boolean[][] movimentosPossiveis = partidaDeXadrez.movimetosPossiveis(origem);
                UI.limparTela();
                UI.imprimirTabuleiro(partidaDeXadrez.getPecas(), movimentosPossiveis);
                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaDeXadrez capturarPeca = partidaDeXadrez.executarMovimentoXadrez(origem, destino);

                if (capturarPeca != null){
                    capturar.add(capturarPeca);
                }

                if (partidaDeXadrez.getPromocao() != null){
                    System.out.print("Escolha a peca de promocao (B/C/T/A): ");
                    String tipo = sc.nextLine().toUpperCase();
                    partidaDeXadrez.substituirPecaPromovida(tipo);
                }
            } catch (XadrezException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.limparTela();
        UI.imprimirPartida(partidaDeXadrez,capturar);
    }
}

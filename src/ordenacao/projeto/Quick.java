package ordenacao.projeto;

import java.io.FileWriter;
import java.io.IOException;

public class Quick{
    int[] numeros;
    long comparacao = 0;
    long movimentacao = 0;
    long tempoInicial;
    long tempoFinal;

    public void sort(int[] vetor, int inicio, int fim) {
        numeros = new int[vetor.length];

        tempoInicial = System.currentTimeMillis();

        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            sort(vetor, inicio, posicaoPivo - 1);
            sort(vetor, posicaoPivo + 1, fim);
        }

        tempoFinal = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            numeros[i] = vetor[i];
        }
    }

    private int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo){
                comparacao++;
                i++;
            } else if (pivo < vetor[f]) {
                comparacao++;
                f--;
            } else {
                comparacao++;
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
                movimentacao++;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        movimentacao++;
        return f;
    }

    public void imprime() {
        if (numeros.length < 100_000){
            for (int i = 0; i < numeros.length; i++) {
                System.out.print(i+1 + "º - " + numeros[i] + "; ");
            }
        }else{
            try {
                FileWriter escrever = new FileWriter("Vetores.txt");
                String str = "";

                for (int i = 0; i < numeros.length; i++) {
                    str += i+1 + "º - " + numeros[i] + "; ";
                }

                escrever.write(str);
                escrever.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("\nExecutado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("Comparações: " + comparacao);
        System.out.println("Movimentações: " + movimentacao);
    }
}

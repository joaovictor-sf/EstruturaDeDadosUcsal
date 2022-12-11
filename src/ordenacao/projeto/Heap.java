package ordenacao.projeto;

import java.io.FileWriter;
import java.io.IOException;

public class Heap extends Ordem{

    int[] numeros;
    long comparacao = 0;
    long movimentacao = 0;
    long tempoInicial;
    long tempoFinal;

    @Override
    public void sort(int[] vetor) {
        numeros = new int[vetor.length];

        tempoInicial = System.currentTimeMillis();
        int tamanho = vetor.length;

        for (int i = tamanho / 2 - 1; i >= 0; i--)
            heap(vetor, tamanho, i);

        for (int i=tamanho-1; i>=0; i--)
        {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            movimentacao++;
            vetor[i] = temp;
            movimentacao++;

            heap(vetor, i, 0);
        }

        tempoFinal = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            numeros[i] = vetor[i];
        }
    }

    void heap(int vetor[], int n, int i)
    {
        int maior = i;
        int esquerda = 2*i + 1;
        int direita = 2*i + 2;

        comparacao++;
        if (esquerda < n && vetor[esquerda] > vetor[maior]) maior = esquerda;

        comparacao++;
        if (direita < n && vetor[direita] > vetor[maior]) maior = direita;

        comparacao++;
        if (maior != i) {
            int chave = vetor[i];
            vetor[i] = vetor[maior];
            movimentacao++;
            vetor[maior] = chave;
            movimentacao++;

            heap(vetor, n, maior);
        }
    }

    @Override
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
        System.out.println("Comparação: " + comparacao);
        System.out.println("Movimentação: " + movimentacao);
    }
}

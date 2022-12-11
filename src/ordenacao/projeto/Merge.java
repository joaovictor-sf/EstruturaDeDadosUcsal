package ordenacao.projeto;

import java.io.FileWriter;
import java.io.IOException;

public class Merge extends Ordem{
    int[] numeros;
    long comparacao = 0;
    long movimentacao = 0;
    long tempoInicial;
    long tempoFinal;

    @Override
    public void sort(int[] vetor) {
        numeros = new int[vetor.length];

        tempoInicial = System.currentTimeMillis();
        int index = 1;
        int inicio, meio, fim;

        while(index < vetor.length) {
            inicio = 0;

            while (inicio + index < vetor.length) {
                meio = inicio + index;
                fim = inicio + 2 * index;

                if (fim > vetor.length) fim = vetor.length;

                intercala(vetor, inicio, meio, fim);

                inicio = fim;
            }

            index = index * 2;
        }
        tempoFinal = System.currentTimeMillis();

        for (int a = 0; a < vetor.length; a++) {
            numeros[a] = vetor[a];
        }
    }

        private void intercala(int[] vetor, int inicio, int meio, int fim) {
            int novoVetor[] = new int[fim - inicio];
            int i = inicio;
            int m = meio;
            int chave = 0;

            while(i < meio && m < fim) {
                comparacao++;
                if(vetor[i] <= vetor[m]) {
                    novoVetor[chave] = vetor[i];
                    chave = chave + 1;
                    i = i + 1;
                    movimentacao++;
                } else {
                    novoVetor[chave] = vetor[m];
                    chave = chave + 1;
                    m = m + 1;
                    movimentacao++;
                }
            }

            comparacao++;
            if (i<meio) comparacao--;
            while(i < meio) {
                comparacao++;
                novoVetor[chave] = vetor[i];
                chave = chave + 1;
                i = i + 1;
                movimentacao++;
            }

            comparacao++;
            if (i<meio) comparacao--;
            while(m < fim) {
                comparacao++;
                novoVetor[chave] = vetor[m];
                chave = chave + 1;
                m = m + 1;
                movimentacao++;
            }

            for(chave = 0, i = inicio; i < fim; i++, chave++) {
                vetor[i] = novoVetor[chave];
                movimentacao++;
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

package ordenacao.projeto;

import java.io.FileWriter;
import java.io.IOException;

public class Buble extends Ordem{
    int[] numeros;
    long comparacao = 0;
    long movimentacao = 0;
    long tempoInicial;
    long tempoFinal;

    @Override
    public void sort(int[] vetor) {
        int chave;
        numeros = new int[vetor.length];

        tempoInicial = System.currentTimeMillis();
        for(int i = 0; i<vetor.length; i++){
            for(int j = 0; j<vetor.length - 1; j++){
                comparacao++;
                if(vetor[j] > vetor[j + 1]){
                    chave = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = chave;
                    movimentacao++;
                }
            }
        }
        tempoFinal = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            numeros[i] = vetor[i];
        }
    }

    @Override
    public void imprime() {
        if (numeros.length < 100_000){
            for (int i = 0; i < numeros.length; i++) {
                System.out.print(i+1 + "º -" + numeros[i] + "; ");
            }
        }else{
            try {
                FileWriter escrever = new FileWriter("Vetores.txt");
                String str = "";

                for (int i = 0; i < numeros.length; i++) {
                    str += i+1 + "º -" + numeros[i] + "; ";
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

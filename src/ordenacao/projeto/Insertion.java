package ordenacao.projeto;


import java.io.FileWriter;
import java.io.IOException;

public class Insertion extends Ordem{
    int[] numeros2;
    long comparacao = 0;
    long movimentacao = 0;
    long tempoInicial;
    long tempoFinal;

    @Override
    public void sort(int[] vetor) {
        numeros2 = new int[vetor.length];

        tempoInicial = System.currentTimeMillis();
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i]; //dar a chave o segundo valor
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {//Se o primeiro valor for maior que o segundo
                comparacao++;
                vetor[j + 1] = vetor[j];// O segundo valor é substituido pelo primeiro
                movimentacao++;
                j = j - 1;
            }
            comparacao++;
            vetor[j + 1] = chave;
            movimentacao++;
        }

        tempoFinal = System.currentTimeMillis();

        for (int i = 0; i < vetor.length; i++) {
            numeros2[i] = vetor[i];
        }
    }

    @Override
    public void imprime() {
        if (numeros2.length < 100_000){
            for (int i = 0; i < numeros2.length; i++) {
                System.out.print(i+1 + "º - " + numeros2[i] + "; ");
            }
        }else{
            try {
                FileWriter escrever = new FileWriter("Vetores.txt");
                String str = "";

                for (int i = 0; i < numeros2.length; i++) {
                    str += i+1 + "º - " + numeros2[i] + "; ";
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

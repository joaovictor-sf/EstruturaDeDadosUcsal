package ordenacao.projeto;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int porcentagem = 0;
        int[] vetor1 = new int[1_000];
        int[] vetor2 = new int[1_000];
        int[] vetor3 = new int[1_000];
        int tamanho = vetor3.length;
        Random random = new Random();
        //Insertion insertion =  new Insertion();
        //Selection selection = new Selection();
        //Buble buble = new Buble();
        //Merge merge = new Merge();
        //Quick quick = new Quick();
        Heap heap = new Heap();


        //Vetor quase ordenado
        /*for (int i = 0; i < vetor2.length; i++) {
            if (porcentagem == 0) porcentagem = vetor2.length * 10/100;

            if (i < vetor1.length - porcentagem) vetor2[i] = i;
            else vetor1[i] = random.nextInt(vetor2.length);
        }*/


        //Vetor aleatoriamente ordenado
        for (int i = 0; i < vetor1.length; i++) {
            vetor1[i] = random.nextInt(vetor1.length);
        }

        //Vetor inversamente ordenado
        /*for (int i = 0; i < vetor3.length; i++) {
            vetor1[i] = tamanho;
            tamanho--;
        }*/

        System.out.println("Pre");

        for (int i = 0; i < vetor1.length; i++) {
            System.out.print(i+1 + "º - " + vetor1[i] + "; ");
        }

        //insertion.sort(vetor1);
        //selection.sort(vetor1);
        //buble.sort(vetor1);
        //merge.sort(vetor1);
        //quick.sort(vetor1, 0, vetor1.length - 1);
        heap.sort(vetor1);
        System.out.println("\nPós");
        heap.imprime();

    }
}

package ordenacao;

import java.util.Random;

public class Insertion {
    public static void main(String[] args) {
        int[] numeros2 = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numeros2[i] = random.nextInt(100);
        }

        for (int i = 0; i < numeros2.length; i++) {
            System.out.println(numeros2[i]);
        }

        for (int i = 1; i < numeros2.length; i++) {
            int chave = numeros2[i]; //dar a chave o segundo valor
            int j = i - 1;//0

            while (j >= 0 && numeros2[j] > chave) {//Se o primeiro valor for maior que o segundo
                numeros2[j + 1] = numeros2[j];// O segundo valor é substituido pelo primeiro
                j = j - 1;
            }
            numeros2[j + 1] = chave;
        }
        System.out.println("--------------");

        for (int i = 0; i < numeros2.length; i++) {
            System.out.println(numeros2[i]);
        }
    }
}

package ordenacao;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numeros = {7,4,5,2,6,10,8,4,1,12};
        for (int i = 0; i < numeros.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < numeros.length; j++){
                if (numeros[j] < numeros[index]){
                    index = j;//Pesquisa pela menor
                }
            }
            int menor = numeros[index];
            numeros[index] = numeros[i];
            numeros[i] = menor;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + ", ");
        }
    }
}

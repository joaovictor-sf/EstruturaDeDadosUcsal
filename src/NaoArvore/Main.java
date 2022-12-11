package NaoArvore;

public class Main {
    public static void main(String[] args) {
        ListaArvore arvore = new ListaArvore();
        int [] info = { 5, 7, 2, 1, 8, 9, 8, 7, 3 , 0 };
        // Caso um elemento ja exista, ele pode ser excluido da lista, para apenas conter elementos nao repetidos.
        for (int i = 0; i < 10; i++) {
            boolean inseriu = arvore.inserir(info[i]);
            System.out.println("inseriu " + info[i] + " : " + inseriu);
        }
    }
}

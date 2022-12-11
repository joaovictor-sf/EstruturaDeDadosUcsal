package NaoArvore2;

import NaoArvore2.util.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        // 5, 7, 2, 1, 8, 9, 8, 7, 3 , 0
        arvore.tamanho();
        arvore.inserir(5);
        arvore.inserir(7);
        arvore.inserir(2);
        arvore.tamanho();
        arvore.inserir(1);
        arvore.inserir(8);
        arvore.inserir(9);
        arvore.inserir(8);
        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(0);
        arvore.tamanho();
        arvore.imprimirPos();
        arvore.imprimirPre();
//        arvore.remover(7);
        arvore.imprimirPos();
        arvore.imprimirPre();


    }
}

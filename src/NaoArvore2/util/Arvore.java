package NaoArvore2.util;

public class Arvore {
    No raiz = null;
    int tamanho = 0;
    public Arvore() {}

    public void remover(int valor) {
        if (raiz != null) {
            remover(valor, raiz);
            return;
        }
        System.out.println("Arvore vazia!");
    }

    private void remover(int valor, No local) {
        if (valor > local.valor) {
            if (local.direita.valor == valor) {
                local.direita = null;
                System.out.println("Numero "+ valor +" removido da arvore!");
                return;
            }
            remover(valor, local.direita);
            return;
        }
        if (valor < local.valor) {
            if (local.esquerda.valor == valor) {
                local.esquerda = null;
                System.out.println("Numero "+ valor +" removido da arvore!");
                return;
            }
            remover(valor, local.esquerda);
            return;
        }
        System.out.println("Numero nao existente na arvore...");
    }

    public void imprimirPos() {
        No local = raiz;
        System.out.println("Pos fix");
        imprimirPos(local);
        System.out.println("");
    }

    private void imprimirPos(No local) {
        if (local.esquerda != null) {
            imprimirPos(local.esquerda);
        }
        if (local.direita != null) {
            imprimirPos(local.direita);
        }
        System.out.print(local.valor);
    }

    public void imprimirPre() {
        No local = raiz;
        System.out.println("Pre fix");
        imprimirPre(local);
        System.out.println("");
    }

    private void imprimirPre(No local) {
        System.out.print(local.valor);
        if (local.esquerda != null) {
            imprimirPre(local.esquerda);
        }
        if (local.direita != null) {
            imprimirPre(local.direita);
        }
    }

//    private void removerMaior(int valor, No local) {
//        if (local.direita != null) {
//            System.out.println("Direita");
//            remover(valor, local.direita);
//            return;
//        }
//        try{
//            local.direita = local.direita.direita;
//        } catch (NullPointerException e) {
//            local.direita = null;
//        }
//        System.out.println("Numero "+ valor +" removido da direita!");
//    }
//
//    private void removerMenor(int valor, No local) {
//        if (local.direita != null) {
//            System.out.println("Direita");
//            remover(valor, local.direita);
//            return;
//        }
//        try{
//            local.direita = local.direita.direita;
//        } catch (NullPointerException e) {
//            local.direita = null;
//        }
//        System.out.println("Numero "+ valor +" removido da direita!");
//    }

    public void inserir(int valor) {
        if(raiz != null) {
            inserir(valor, raiz);
            return;
        }
//        if (valor == raiz.valor){
//
//        }
        raiz = new No(valor);
        System.out.println("Numero "+ valor + " inserido na raiz!");
    }

    private void inserir(int valor, No local) {
        if (valor > local.valor) {
            inserirMaior(valor, local);
            tamanho++;
            return;
        }
        if (valor < local.valor) {
            inserirMenor(valor, local);
            tamanho++;
            return;
        }
        System.out.println("Numero "+ valor +" ja existia na arvore!");
    }

    private void inserirMaior(int valor, No local) {
        if (local.direita != null) {
            System.out.println("Direita");
            inserir(valor, local.direita);
            return;
        }
        local.direita = new No(valor);
        local.direita.pai = local;
        System.out.println("Numero "+ valor +" inserido na direita!");
    }

    private void inserirMenor(int valor, No local) {
        if (local.esquerda != null) {
            System.out.println("Esquerda");
            inserir(valor, local.esquerda);
            return;
        }
        local.esquerda = new No(valor);
        local.esquerda.pai = local;
        System.out.println("Numero "+ valor +" inserido na esquerda!");
    }

    public void tamanho(){
        System.out.println("O tamanho atual da árvore é: " + tamanho);
    }

    public void isFolha(No no){
        if(no.direita == null && no.esquerda == null)
            System.out.println("O valor: " + no.valor + "é uma foia");
        System.out.println("O valor: " + no.valor + "não é uma foia");
    }
}

package NaoArvore;

public class ListaArvore {
    public No raiz;

    public ListaArvore() {
        raiz = null;
    }

    public boolean inserir(int info) {
        // O no local inicia como raiz
        No local = raiz;
        // Cria o no
        No no = new No(info);
        // Se nao existe nenhum elemento na lista, coloca-o como raiz
        if (raiz == null) {
            raiz = no;
            return true;

        }
        // Enquanto local nao for nulo
        while (local != null) {
            // o pai do no vai ser o local
            no.pai = local;
            if (info == local.info) {
                // se ja existir, nao insere e retorna falso
                return false;
            } else if (info < local.info) {
                // se for menor que o local, entao eh filho da esquerda
                local = local.esquerda;
                if (local == null) {
                    // se ao ir para esquerda for nulo, coloca ali
                    no.pai.esquerda = no;
                    return true;
                }
            } else {
                // senao eh filho da direita
                local = local.direita;
                if (local == null) {
                    // se for para direita e for nulo, coloca o no nesse local
                    no.pai.direita = no;
                    return true;
                }
            }
        }
        return false;
    }
}

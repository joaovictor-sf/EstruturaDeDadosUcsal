package listaCircular;

public class ListaCircular {
    private No inicio;
    private No fim;

    private int tamanho;

    public ListaCircular() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return inicio == null && fim == null;

    }

    public void adicionarFila(String dado) {

        No novo = new No(dado);

        if (vazia()) {
            inicio = novo;
            fim = novo;
            fim.proximo = inicio;
        } else {
            novo.proximo = inicio;
            fim.proximo = novo;
            fim = novo;
        }
        tamanho++;
    }

    public String toString() {
        String listados = "Lista" + "\n";
        int numero = 1;
        if (vazia()) {

            return listados = "Não foi possivel encontrar valores cadastrados";

        } else if (inicio == fim) {

            listados = listados + numero + " - " + inicio.info;

        } else {

            No aux = inicio;
            if (aux == fim.proximo) {

                listados = listados + numero + " - " +aux.info+"\n";
                aux = aux.proximo;
                numero++;

            }
            while (aux != fim.proximo) {

                listados = listados + numero + " - " + aux.info+"\n";
                aux = aux.proximo;
                numero++;

            }

        }
        return listados;
    }

    public String removerFila() {
        String removido;
        No aux = new No();

        if (vazia()) {
            removido = null;

        } else if (inicio == fim) {

            removido = inicio.info;
            inicio = null;
            fim = null;
            tamanho--;
        } else {

            removido = inicio.info;
            aux = fim;
            fim = inicio;
            //Olhar na facu
            inicio = inicio.proximo;
            fim.proximo = inicio;
            tamanho--;
        }
        return removido;
    }

    public int getTamanho() {
        return tamanho;
    }
}

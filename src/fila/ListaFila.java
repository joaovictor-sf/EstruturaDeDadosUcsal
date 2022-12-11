package fila;

public class ListaFila {
    No inicio;
    No cabeca;
    int tamanho;
    int posicao;

    // Inicialização de uma fila vazia
    ListaFila () {
        cabeca = null;
        inicio = null;
        tamanho = 0;
    }

    /**
     * Insere no fim da fila
     * @param info
     */
    public void entrar( String info) {
        No no = new No();
        no.info = info;
        no.proximo = inicio;

        if (isEmpty()) cabeca = no;

        inicio = no;

        //if (isEmpty()) cabeca = no;

        tamanho++;
    }

    /**
     * • Retira elemento da cabeça da fila
     * • Ocorre um erro se a fila estiver vazia
     * @return info
     */
    public String sair() {
        if (isEmpty()) return null;

        String info = cabeca.info;

        if (tamanho == 1) {
            inicio = null;
            cabeca = null;
        } else {
            No local = inicio;

            while (local.proximo != cabeca) local = local.proximo;

            cabeca = local;
            cabeca.proximo = null;
        }

        tamanho--;
        return info;
    }

    /**
     * Retorna, mas não remove, o objeto na frente da fila
     * @return cabeca.info
     */
    public String front() {
        if (cabeca == null) return null;
        return cabeca.info;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public String toString() {
        String str = "";

        if (isEmpty()) return str = "Lista vazia";

        No atual = this.inicio;
        for (int i = 0; i < tamanho; i++) {
            str += atual.info + " ";
            atual = atual.proximo;
        }
        return str;
    }

    /**
     * Se a lista <b>estiver vazia</b>, retorna <b>"Lista vazia"</b>
     * Se o elemento <b>existir</b>, ele retorna a sua <b>posição na fila</b>
     * Se ele <b>não existir</b> ele retorna <b>"elemento não existe"</b>
     *
     * @param elemento do tipo String
     * @return A posição do elemento na fila
     *
     */
    public String find(String elemento){
        if (isEmpty()){
            return "Lista vazia";
        }else{
            posicao = tamanho;

            No atual = this.inicio;
            while(atual != null) {
                if (atual.info.equals(elemento)) return "O elemento \'"+ elemento + "\' está na "
                        + posicao + "ª posição da fila";

                posicao--;
                atual = atual.proximo;
            }
        }

        return "elemento não existe";
    }

    /**
     * Inverte a ordem da fila
     */
    public void inverter(){
        No atual = this.inicio;
        int tamanhoAtual = tamanho;

        for (int i = 0; i < tamanhoAtual; i++) {
            entrar(atual.info);
            atual = atual.proximo;
        }
        for (int i = 0; i < tamanhoAtual; i++) {
            sair();
        }
    }

}

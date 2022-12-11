package listaEncadeada.duplamente;

public class ListaDupla {
    private No inicio;
    private No fim;
    private int tamanho;

    public void inserirInicio(String info){
        //Cria um novo no
        No no = new No();
        no.info = info;

        no.anterior = null;//Como ele estará no inicio, a versão anterior a ele é null
        no.proximo = inicio;//O próximo no é o inicio anterior
        if( inicio != null ) {
            inicio.anterior = no;
        }
        inicio = no;
        if (tamanho == 0) {
            fim = inicio;
        }
        tamanho++;
    }

    public void inserirFim(String info) {
        No no = new No();
        no.info = info;
        no.proximo = null; // O último nó aponta sempre para null
        no.anterior = fim; // o nó anterior vai ser o último nó.
        if (fim != null) {
            fim.proximo = no;
        }
        fim = no;
        // testa se não tem nada ainda
        if (tamanho == 0 ) {
            inicio = fim;
        }
        tamanho++;
    }

    public void inserirMeio(int posicao, String info) {
        if(posicao <= 0) {
            inserirInicio(info);
        } else if (posicao >= tamanho) {
            inserirFim(info);
        } else {
            // primeiro, percorer a lista até a posição desejada
            No local = inicio;
            for( int i = 0; i < posicao - 1 ; i++) {
                local = local.proximo;
            }
            No no = new No();
            no.info = info;
            no.anterior = local;
            no.proximo = local.proximo;
            local.proximo = no;
            no.proximo.anterior = no;
            tamanho++;
        }
    }

    public String toString() {
        String str = "(" + tamanho + ") ";
        No local = inicio;
        while (local != null) {
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
    }

    public String retirarInicio() {
        // Verificar se a lista está vazia. Se vazia , não podemos retirar
        if (inicio == null ) {
            return null;
        }
        // Salvar a informação do nó do início, a ser retirado
        String out = inicio.info;

        inicio = inicio.proximo;
        // testar se o novo início é diferente de nulo
        if (inicio != null ) {
            inicio.anterior = null; // desprende do no a ser excluído
        } else {
            fim = null;
        }
        tamanho--;

        return out;
    }

    public String retirarFim() {
        // testar se lista está vazia. Caso sim, não retornar nada
        if (fim == null) {
            return null;
        }
        String out = fim.info; // salvar a informação do elemento do fim, a ser apagado
        fim = fim.anterior;
        if (fim != null) {
            fim.proximo = null;
        } else {
            inicio = null;
        }
        tamanho--;

        return out;
    }

    public String retirarMeio(int posicao) {
        if(posicao < 0 || posicao >= tamanho || inicio == null) {
            return null;
        } else if (posicao == 0) {
            return retirarInicio();
        } else if (posicao == tamanho -1) {
            return retirarFim();
        }
        // Percorrer a lista até a posição a ser retirada
        No local = inicio;
        for(int i= 0 ; i < posicao; i++) {
            local = local.proximo;
        }
        if(local.anterior != null) {
            local.anterior.proximo = local.proximo;
        }
        if(local.proximo != null) {
            local.proximo.anterior = local.anterior;
        }
        tamanho--;
        return local.info;
    }

    public No getInicio() {
        return inicio;
    }

    public No getFim() {
        return fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia(){
        if (inicio == null) return true;
        return false;
    }

    public void apagarLista() {
        if (inicio == null) return;
        while (inicio.proximo != null){
            inicio = inicio.proximo;//Substitui o valor do incio pelo proximo valor
        }

        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public String pesquisar(String info){
        int posicao = 1;
        No local = inicio;
        if (local == null) return "Lista vazia";
        while (local.info != info){
            if (local.proximo == null) return "Não esta na lista";
            local = local.proximo;
            posicao++;
        }
        return "Esta na lista na posição " + posicao;
    }
}

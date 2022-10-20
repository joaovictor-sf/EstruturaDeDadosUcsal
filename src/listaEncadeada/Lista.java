package listaEncadeada;

public class Lista {
    private No inicio = null;
    private int tamanho = 0;
    public int posicao;

    public void inserirInicio(String info) {
        No no = new No();
        no.info = info;
        no.proximo = inicio;
        inicio = no;
        tamanho++;
    }

    public void inserirFim(String info) {
        No prof = new No();
        prof.info = info;
        if (inicio==null) {
            inicio = prof;
            prof.proximo = null;
        } else{
            No local = inicio;
            while(local.proximo != null) {
                local = local.proximo;
            }
            local.proximo = prof;
            prof.proximo = null;
            tamanho++;
        }
    }

    public String toString() {
        String str = "(" + tamanho + ") " ;
        No local = inicio;
        while (local != null) {//Mostrar todas as variaveis da lista
            str += local.info + " " ;
            local = local.proximo;
        }
        return str;
    }

    public int tamanhoLista() {
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
            //tamanho--;
        }

        inicio = null;
        tamanho = 0;
        //tamanho--;
    }

    public String removIni() {
        String info = inicio.info;//O valor no inicio
        inicio = inicio.proximo;//Substitui o valor do incio pelo proximo valor
        tamanho--;
        return info;
    }

    public String removFim(){
        if (inicio == null) return null;//Se a lista estiver vazia retorne null

        No local = inicio;//Local é a primeira variavel
        while (local.proximo != null){
            No aux = local;//Cria um objeto auxiliar para guardar a variavel anterior
            local = local.proximo;//Local agora é igual a proxima variavel
            if (local.proximo == null){
                aux.proximo = null;
                tamanho--;
                return local.info;
            }
        }
        inicio = null;//Se a lista tiver somente a variavel inicial, a exclua
        tamanho--;
        return local.info;//Retorna o nome da variavel exluída
    }

    public String pesquisar(String info){
        posicao = 1;
        No local = inicio;
        if (local == null) return "Lista vazia";
        while (local.info != info){
            if (local.proximo == null) return "Não esta na lista";
            local = local.proximo;
            posicao++;
        }
        //if (local.nome == nome){
        return "Esta na lista na posição " + posicao;
        //}
        //return "Não esta na lista";
    }
}

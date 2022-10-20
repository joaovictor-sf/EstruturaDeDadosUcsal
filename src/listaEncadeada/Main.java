package listaEncadeada;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println(lista.estaVazia());
        System.out.println(lista.tamanhoLista());
        System.out.println(lista);
        lista.inserirInicio("algo");
        System.out.println(lista);
        lista.inserirFim("outro");
        System.out.println(lista);
        System.out.println(lista.tamanhoLista());
        System.out.println(lista.estaVazia());
        System.out.println(lista.pesquisar("algo"));
        lista.inserirFim("aquele");
        lista.inserirFim("aquela");
        System.out.println(lista);
        lista.removIni();
        System.out.println(lista);
        lista.removFim();
        System.out.println(lista);
        System.out.println(lista.tamanhoLista());
        lista.apagarLista();
        System.out.println(lista);
        System.out.println(lista.tamanhoLista());
        System.out.println(lista.estaVazia());
    }
}

package listaCircular;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        //System.out.println(lista);
        //System.out.println(lista.vazia());
        //System.out.println(lista.getTamanho());
        lista.adicionarFila("algo");
        //System.out.println(lista);
        //lista.adicionarFila("algo2");
        //lista.adicionarFila("algo3");
        System.out.println(lista);
        //System.out.println(lista.getTamanho());
        lista.removerFila();
        System.out.println(lista);
        System.out.println(lista.getTamanho());
    }
}

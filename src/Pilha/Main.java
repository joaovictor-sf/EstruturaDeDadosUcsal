package Pilha;

public class Main {
    public static void main(String[] args) {
        ListaPilha listaPilha = new ListaPilha();

        System.out.println(listaPilha.vazia());

        System.out.println(listaPilha);
        listaPilha.push("1");
        System.out.println(listaPilha);
        listaPilha.push("2");
        System.out.println(listaPilha);
        listaPilha.push("3");
        System.out.println(listaPilha);

        System.out.println(listaPilha.posicao("2"));

        System.out.println(listaPilha.vazia());

        listaPilha.retirar();

        System.out.println(listaPilha);

    }
}

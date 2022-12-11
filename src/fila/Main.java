package fila;

public class Main {
    public static void main(String[] args) {
        ListaFila fila = new ListaFila();
        System.out.println(fila.isEmpty());
        fila.entrar("a");
        fila.entrar("b");
        fila.entrar("c");
        System.out.println(fila);
        fila.inverter();
        System.out.println(fila);
    }
}

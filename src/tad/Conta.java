package tad;

public class Conta implements Operacoes {
    private double valor;

    public Conta() {
        valor = 0;
    }

    @Override
    public void depositar(double v) {
        valor += v;
    }

    @Override
    public void sacar(double v) {
        valor -= v;
    }

    @Override
    public String toString() {
        return "Voce possui R$" + valor;
    }
}

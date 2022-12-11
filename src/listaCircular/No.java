package listaCircular;

public class No {
    String info;
    No proximo;

    public No(String info) {
        this.info = info;
        this.proximo = null;
    }

    public No() {

    }

    @Override
    public String toString() {
        return info;
    }
}

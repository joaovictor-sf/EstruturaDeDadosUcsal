package Pilha;

public class ListaPilha {
    private No topo;
    private int quantidade;

    public ListaPilha() {
        topo = null;
        quantidade = 0;
    }

    public void push(String info){
        No novo = new No(info);
        novo.setProximo(this.topo);
        this.topo = novo;
        quantidade++;
    }

    @Override
    public String toString() {
        String str = "";
        if (vazia()) return str;
        No atual = this.topo;
        for (int i = 0; i < getQuantidade(); i++) {
            str += atual.getInfo() + " ";
            atual = atual.getProximo();
        }
        return str;
    }

    public int posicao(String info){
        No atual = this.topo;
        for (int i = 0; i < getQuantidade(); i++) {
            if (info.equals(atual.getInfo())) return i;
            atual = atual.getProximo();
        }
        return -1;
    }

    public boolean vazia(){
        if (getQuantidade() == 0) return true;
        return false;
    }

    public String retirar(){
        String retirado;
        if (vazia()) return "Vazia";
        retirado = this.topo.getInfo();
        this.topo = this.topo.getProximo();
        quantidade--;
        return retirado;
    }

    public No getTopo() {
        return topo;
    }

    public void setTopo(No topo) {
        this.topo = topo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

package recursividade.compreendido;

public class NumeroCompreendido {

    public int pegarNumero(int n){
        if (n == 0){
            return 0;
        }
        return n + pegarNumero(n - 1);
    }

}

package recursividade.fatorial;

public class Fatorial {

    public int fatorialConta(int n){
        if (n == 0){
            return 1;
        }
        return n * fatorialConta(n - 1);
    }
}

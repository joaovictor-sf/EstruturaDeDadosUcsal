package recursividade.maximoDivisorComum;

public class Mdc {
    int d;
    int r;
    public Mdc() {
        d = 2;
        r = 1;
    }

    public int divisorComum(int m, int n){
        if (m == 1 && n == 1) {
            return r;
        }else if (m % d == 0 && n % d == 0){
            r *= d;
            m /= d;
            n /= d;
            return divisorComum(m, n);
        }else if (m % d != 0 && n % d == 0){
            n /= d;
            return divisorComum(m, n);
        }else if (m % d == 0 && n % d != 0){
            m /= d;
            return divisorComum(m, n);
        }else{
            d += 1;
            return divisorComum(m, n);
        }
    }
}

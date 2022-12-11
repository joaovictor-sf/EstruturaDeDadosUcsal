package listaEncadeada.duplamente;

public class Main {

    public static void main(String[] args) {
        ListaDupla dupla = new ListaDupla();

        System.out.println(dupla.estaVazia());

        System.out.println(dupla);

        dupla.inserirInicio("inicio");
        System.out.println(dupla);
        dupla.inserirFim("fim");
        System.out.println(dupla);
        dupla.inserirMeio(1, "meio");
        System.out.println(dupla);
        dupla.inserirInicio("inicio");
        dupla.inserirFim("fim");
        dupla.inserirMeio(3, "meio");
        System.out.println(dupla);
        System.out.println(dupla.pesquisar("meio"));

        dupla.retirarInicio();
        dupla.retirarFim();
        dupla.retirarMeio(1);
        System.out.println(dupla);
        System.out.println(dupla.getInicio());

        System.out.println(dupla.estaVazia());

        System.out.println(dupla.getInicio());
        System.out.println(dupla.getFim());
        System.out.println(dupla.getTamanho());

        dupla.apagarLista();
        System.out.println(dupla.estaVazia());
        System.out.println(dupla);
        System.out.println(dupla.getInicio());
        System.out.println(dupla.getFim());
        System.out.println(dupla.getTamanho());
    }
}

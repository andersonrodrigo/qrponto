import java.util.HashMap;
import java.util.Map;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class Main {

    public static void main( String[] args )
    {
        //singleton container
        Operacoes operacoes = Operacoes.INSTANCE;

        // register new operations with the previously created container
        operacoes.registrarOperacao(new E());
        operacoes.registrarOperacao(new Igual());
        operacoes.registrarOperacao(new Nao());
        operacoes.registrarOperacao(new Maior());
        Pessoal p = new Pessoal();

        p.avaliar();


    }
}

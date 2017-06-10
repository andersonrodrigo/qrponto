import java.util.Map;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class Variavel implements Expressao {
    private String nome;

    public Variavel(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    @Override
    public boolean interpretador(Map<String, ?> bindings)
    {
        return true;
    }
}

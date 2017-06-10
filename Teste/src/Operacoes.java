import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by PFiuza on 10/06/2017.
 */
public enum Operacoes {
    /** Application of the Singleton pattern using enum **/
    INSTANCE;

    private final Map<String, Operacao> operacaoes = new HashMap<>();

    public void registrarOperacao(Operacao op, String symbol)
    {
        if (!operacaoes.containsKey(symbol))
            operacaoes.put(symbol, op);
    }

    public void registrarOperacao(Operacao op)
    {
        if (!operacaoes.containsKey(op.getSymbol()))
            operacaoes.put(op.getSymbol(), op);
    }

    public Operacao getOperacao(String simbolo)
    {
        return this.operacaoes.get(simbolo);
    }

    public Set<String> getSimbolos()
    {
        return this.operacaoes.keySet();
    }
}

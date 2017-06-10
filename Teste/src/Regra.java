import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class Regra {
    private List<Expressao> expressoes;
    private Executor executor;

    public static class Builder
    {
        private List<Expressao> expressoes = new ArrayList<>();
        private Executor executor;

        public Builder comExpressao(Expressao expr)
        {
            expressoes.add(expr);
            return this;
        }

        public Builder comEnvio(Executor executor)
        {
            this.executor = executor;
            return this;
        }

        public Regra criar()
        {
            return new Regra(expressoes, executor);
        }
    }

    private Regra(List<Expressao> expressoes, Executor executor)
    {
        this.expressoes = expressoes;
        this.executor = executor;
    }

    public boolean avaliar(Map<String, ?> bindings)
    {
        boolean eval = false;
        for (Expressao expression : expressoes)
        {
            eval = expression.interpretador(bindings);
            if (eval)
                executor.ativar();
        }
        return eval;
    }
}

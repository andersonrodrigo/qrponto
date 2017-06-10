

import java.util.Stack;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class Avaliador {

    private static final Operacoes OPERACOES = Operacoes.INSTANCE;

    public static Expressao stringEntrada(String expr)
    {
        Stack<Expressao> pilha = new Stack<>();

        //separa opcoes por espaco
        String[] tokens = expr.split("\\s");
        for (int i=0; i < tokens.length-1; i++)
        {
            Operacao op = OPERACOES.getOperacao(tokens[i]);
            if ( op != null )
            {
                // criar uma instancia
                op = op.copy();
                i = op.parse(tokens, i, pilha);
            }
        }

        return pilha.pop();
    }
}

import java.util.Stack;

public abstract class Operacao implements Expressao {
    protected String simbolo;
    protected String resultado;

    protected Expressao esqOperador = null;
    protected Expressao dirOperador = null;

    public Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract Operacao copy();

    public String getSymbol() {
        return this.simbolo;
    }

    public abstract int parse(final String[] tokens, final int pos, final Stack<Expressao> pilha);

    protected Integer proximaExpressao(String[] tokens, int pos, Stack<Expressao> pilha) {
        Operacoes operations = Operacoes.INSTANCE;

        for (int i = pos; i < tokens.length; i++) {
            Operacao op = operations.getOperacao(tokens[i]);
            if (op != null) {
                op = op.copy();
                // achei uma operacao
                i = op.parse(tokens, i, pilha);

                return i;
            }
        }
        return null;
    }
}
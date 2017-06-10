import java.util.Map;
import java.util.Stack;

public class E extends Operacao {
    public E() {
        super("AND");
    }

    public E copy() {
        return new E();
    }

    @Override
    public int parse(String[] tokens, int pos, Stack<Expressao> pilha) {
        Expressao esq = pilha.pop();
        int i = proximaExpressao(tokens, pos + 1, pilha);
        Expressao dir = pilha.pop();

        this.esqOperador = esq;
        this.dirOperador = dir;

        pilha.push(this);

        return i;
    }

    @Override
    public boolean interpretador(Map<String, ?> bindings) {
        return esqOperador.interpretador(bindings) && dirOperador.interpretador(bindings);
    }
}
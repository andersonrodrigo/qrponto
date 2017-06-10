import java.util.Map;
import java.util.Stack;

public class Nao extends Operacao {
    public Nao() {
        super("NOT");
    }

    public Nao copy() {
        return new Nao();
    }

    @Override
    public int parse(String[] tokens, int pos, Stack<Expressao> pilha) {
        int i = proximaExpressao(tokens, pos + 1, pilha);
        Expressao right = pilha.pop();

        this.dirOperador = right;
        pilha.push(this);

        return i;
    }

    @Override
    public boolean interpretador(final Map<String, ?> bindings) {
        return !this.dirOperador.interpretador(bindings);
    }
}
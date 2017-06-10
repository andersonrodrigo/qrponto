import java.util.Map;
import java.util.Stack;

public class Igual extends Operacao {
    public Igual() {
        super("=");
    }

    @Override
    public Igual copy() {
        return new Igual();
    }

    @Override
    public int parse(final String[] tokens, int pos, Stack<Expressao> pilha) {
        if (pos - 1 >= 0 && tokens.length >= pos + 1) {
            String var = tokens[pos - 1];

            this.esqOperador = new Variavel(var);
            this.dirOperador = TipoBase.getBaseType(tokens[pos + 1]);
            pilha.push(this);

            return pos + 1;
        }
        throw new IllegalArgumentException("Nao foi possivel associar valor a variavel");
    }

    @Override
    public boolean interpretador(Map<String, ?> bindings) {
        Variavel v = (Variavel) this.esqOperador;
        Object obj = bindings.get(v.getNome());
        if (obj == null)
            return false;

        TipoBase<?> type = (TipoBase<?>) this.dirOperador;
        if (type.getType().equals(obj.getClass())) {
            if (type.getValue().equals(obj))
                return true;
        }
        return false;
    }
}
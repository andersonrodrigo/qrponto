import java.util.Map;

public class TipoBase<T> implements Expressao {
    public T value;
    public Class<T> type;

    public TipoBase(T value, Class<T> type) {
        this.value = value;
        this.type = type;
    }

    public T getValue() {
        return this.value;
    }

    public Class<T> getType() {
        return this.type;
    }

    @Override
    public boolean interpretador(Map<String, ?> bindings) {
        return true;
    }

    public static TipoBase<?> getBaseType(String string) {
        if (string == null)
            throw new IllegalArgumentException("A string informada não pode ser nula");

        if ("true".equals(string) || "false".equals(string))
            return new TipoBase<>(Boolean.getBoolean(string), Boolean.class);
        else if (string.startsWith("'"))
            return new TipoBase<>(string, String.class);
        else if (string.contains("."))
            return new TipoBase<>(Float.parseFloat(string), Float.class);
        else
            return new TipoBase<>(Integer.parseInt(string), Integer.class);
    }
}
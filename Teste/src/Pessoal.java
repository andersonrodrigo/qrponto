import java.util.HashMap;
import java.util.Map;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class Pessoal {
    private int salario;
    private int diasTrabalhados;


    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public void avaliar(){


        // definindo as regras
        Expressao ex1 = Avaliador.stringEntrada("SALARIO > 1000 AND CARGO = 'SUP'");


        // acoes a serem executadas
        Executor aumentarSlario = new ExecutaA();

        // criando regra com expressao e acao
        Regra rule1 = new Regra.Builder()
                .comExpressao(ex1)
                .comEnvio(aumentarSlario)
                .criar();


        Map<String, String> bindings = new HashMap<>();
        bindings.put("SALARIO", "1001");
        bindings.put("CARGO", "'SUP'");

        boolean triggered = rule1.avaliar(bindings);
        System.out.println("Acao: "+triggered);
    }
}

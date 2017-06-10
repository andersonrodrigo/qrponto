import sun.security.x509.AVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void aumentaSalarioPerc(int perc){
        this.salario = salario + salario * perc / 100;
    }

    public void avaliar(){
        String funcaoAplicar = "aumentarSalario" ;
        String modificadorFuncao = "10";
        List<Expressao> le = new ArrayList<Expressao>();
        List<String> expressoes = new ArrayList<String>();
        expressoes.add("SALARIO > 1000 AND CARGO = 'SUP'");
        expressoes.add("SALARIO = 1000 AND CARGO = 'DIR'");

        for (String exp:expressoes) {
            le.add(Avaliador.stringEntrada(exp));
        }

        // acoes a serem executadas
        Executor execut = new ExecutaA(this,funcaoAplicar,modificadorFuncao);

        // criando regra com expressao e acao
        Regra rule1 = new Regra.Builder()
                .comExpressao(le)
                .comEnvio(execut)
                .criar();

        Map<String, String> bindings = new HashMap<>();


        bindings.put("SALARIO", "1001");
        bindings.put("CARGO", "'SUP'");

        boolean triggered = rule1.avaliar(bindings);
        System.out.println("Acao: "+triggered);
    }
}

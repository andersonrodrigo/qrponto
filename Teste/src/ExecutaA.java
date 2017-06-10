import java.lang.reflect.InvocationTargetException;

/**
 * Created by PFiuza on 10/06/2017.
 */
public class ExecutaA implements Executor {

    private String aplicar;
    private String valor;
    private Pessoal p;


    public ExecutaA(Pessoal p,String aplicar,String valor){
        this.aplicar = aplicar;
        this.valor = valor;
        this.p = p;
    }
    @Override
    public void ativar()
    {
        java.lang.reflect.Method method;

        try {

            method = p.getClass().getMethod(aplicar, int.class);

            try {
                method.invoke(p,valor);
            } catch (IllegalArgumentException e) {  }
            catch (IllegalAccessException e) {  }
            catch (InvocationTargetException e) {  }

        } catch (SecurityException e) {  }
        catch (NoSuchMethodException e) {  }



        System.out.println(p.getSalario());


    }
}

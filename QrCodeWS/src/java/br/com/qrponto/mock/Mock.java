package br.com.qrponto.mock;

import br.com.qrponto.bean.Perfil;
import br.com.qrponto.bean.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Mock {
    
    /*
    Relátorios 
    */
    
    /*
    Usuários e Perfis
    */
    public static Usuario carregaUsuario1(Usuario u) {
        u.setId(1);
        u.setNome("Anderson");
        u.setPerfil(new Perfil(1, "Administador"));
        return u;
    }
    
    public static Usuario carregaUsuario2(Usuario u) {
        u.setId(2);
        u.setNome("Gabriel");
        u.setPerfil(new Perfil(2, "Desenvolvedor"));
        return u;
    }
    
    

    public List<Usuario> carregaUsuarios() {
        List<Usuario> retorno = new ArrayList<>();

        Usuario u = new Usuario("administrador", "1234", "Anderson", new Perfil(1, "administrador"));
        Usuario u2 = new Usuario("desenvolvedor", "1234", "Gabriel", new Perfil(2, "desenvolvedor"));

        retorno.add(u);
        retorno.add(u2);

        return retorno;
    }

    public List<Perfil> carregaPerfis() {
        List<Perfil> retorno = new ArrayList<>();

        Perfil p = new Perfil(1, "administrador");
        Perfil p2 = new Perfil(2, "desenvolvedor");

        return retorno;
    }

}

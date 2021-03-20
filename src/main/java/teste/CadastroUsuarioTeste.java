/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import negocio.UsuarioNegocio;
import entidade.Usuario;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author Dev Dreamm
 */
public class CadastroUsuarioTeste {
    
    @Test
    public static void cadastroUsuarioValidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        user.setPerfil("moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret = un.adicionarUsuario(user);
	assertTrue(ret);
    }
    
}

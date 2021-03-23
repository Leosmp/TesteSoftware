/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import negocio.UsuarioNegocio;
import entidade.Usuario;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import repositorio.UsuarioRepositorio;

public class CadastroUsuarioTeste {
    
    @Test
    public void cadastroUsuarioValidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        user.setPerfil("Moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            ret = un.adicionarUsuario(user);
            assertTrue(ret);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }	
    }
    
    @Test
    public void cadastroUsuarioEmailInvalidoTeste(){
        Usuario user = new Usuario("Leonardo", "leogmail.com", "ifpe2021");
        user.setPerfil("Moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            ret = un.adicionarUsuario(user);
        } catch (Exception ex) {
            assertEquals("E-mail inválido!", ex.getMessage());            
        }	
    }
    
    @Test
    public void cadastroUsuarioSenhaInvalidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "123");
        user.setPerfil("Moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            ret = un.adicionarUsuario(user);
        } catch (Exception ex) {
            assertEquals("Senha inválida! Digite uma senha maior que 4 caracteres!", ex.getMessage());            
        }	
    }
    
    @Test
    public void cadastroUsuarioPerfilInvalidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        user.setPerfil("Usuario");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            ret = un.adicionarUsuario(user);
        } catch (Exception ex) {
            assertEquals("Usuário precisa ser Moderador!", ex.getMessage());            
        }	
    }
}

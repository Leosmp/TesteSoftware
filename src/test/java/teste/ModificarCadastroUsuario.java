/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.Usuario;
import negocio.UsuarioNegocio;
import static org.junit.Assert.*;
import org.junit.Test;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author Vinicius
 */
public class ModificarCadastroUsuario {
    
    @Test
    public void atualizarUsuarioValidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        Usuario user2 = new Usuario();
        user.setPerfil("Moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            un.adicionarUsuario(user);
            System.out.println("Nome: " + user.getNome());
            user.setNome("Bárbara");
            ret = un.editarUsuario(user);
            System.out.println("Nome: " + user.getNome());
            assertTrue(ret);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());            
        }	
    }
    
    @Test
    public void atualizarUsuarioEmailInvalidoTeste(){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        Usuario user2 = new Usuario();
        user.setPerfil("Moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        boolean ret;
        try {
            un.adicionarUsuario(user);
            user.setEmail("leogmail.com");
            ret = un.editarUsuario(user);
        } catch (Exception ex) {
            assertEquals("E-mail inválido!", ex.getMessage());
        }	
    }
}

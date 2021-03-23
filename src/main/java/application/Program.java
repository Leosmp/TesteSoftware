/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entidade.Usuario;
import negocio.UsuarioNegocio;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author Vinicius
 */
public class Program {
    
    public static void main(String[] args){
        Usuario user = new Usuario("Leonardo", "leo@gmail.com", "ifpe2021");
        user.setPerfil("moderador");
        UsuarioRepositorio userRepo = new UsuarioRepositorio();
        UsuarioNegocio un = new UsuarioNegocio(userRepo);
        try { 
            un.adicionarUsuario(user);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}

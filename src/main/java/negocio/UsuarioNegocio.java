/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Usuario;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author Dev Dreamm
 */
public class UsuarioNegocio {

    private UsuarioRepositorio userRepo;

    public UsuarioNegocio(UsuarioRepositorio usRepo) {
        this.userRepo = usRepo;
    }

    public boolean adicionarUsuario(Usuario u) {
        boolean adicionado = false;
        if (u.getNome() != null && u.getEmail()!= null && u.getPerfil().equals("Moderador")
                && u.getSenha() != null) {
            adicionado = this.userRepo.addUsuario(u);
        }
        return adicionado;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import entidade.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev Dreamm
 */
public class UsuarioRepositorio {

    private List<Usuario> usuarios;

    public UsuarioRepositorio() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public boolean addUsuario(Usuario u) {
        try {
            this.usuarios.add(u);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    
}

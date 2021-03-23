/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Usuario;
import java.util.List;
import java.util.stream.Collectors;
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

    public boolean adicionarUsuario(Usuario u) throws Exception {
        boolean adicionado = false;
        if (u.getNome() == null) {
            throw new Exception("O Nome está em branco!");
        } else if(u.getEmail()== null || !u.getEmail().contains("@")){
            throw new Exception("E-mail inválido!");
        } else if(u.getSenha() == null || u.getSenha().length() <= 4){
            throw new Exception("Senha inválida! Digite uma senha maior que 4 caracteres!");
        } else if(!u.getPerfil().equals("Moderador")){
            throw new Exception("Usuário precisa ser Moderador!");
        }else {            
            adicionado = this.userRepo.addUsuario(u);
        }
        return adicionado;
    }
    
    public boolean editarUsuario(Usuario u) throws Exception{
        boolean editado = false;
        if(u == null){
            throw new IllegalArgumentException("Usuario não pode ser nulo");
        } else if (u.getNome() == null) {
            throw new Exception("O Nome está em branco!");
        } else if(u.getEmail()== null || !u.getEmail().contains("@")){
            throw new Exception("E-mail inválido!");
        } else if(u.getSenha() == null || u.getSenha().length() <= 4){
            throw new Exception("Senha inválida! Digite uma senha maior que 4 caracteres!");
        } else if(!u.getPerfil().equals("Moderador")){
            throw new Exception("Usuário precisa ser Moderador!");
        }else{
            editado = this.userRepo.editarUsuario(u);
        }
        return editado;
    }

    public Usuario buscarUsuario(String email) {
        Usuario user = new Usuario();
        if(email != null){
            user = this.userRepo.buscarUsuario(email);
        }        
        return user;
    }
}

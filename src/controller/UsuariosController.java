package controller;

import daos.GerenciadorDeArquivosUsuario;
import entities.Usuario;

import java.util.List;
import java.util.Objects;

public class UsuariosController {
    List<Usuario> list;
    GerenciadorDeArquivosUsuario gArquivosUsuarios;

    public UsuariosController(){
        this.gArquivosUsuarios = new GerenciadorDeArquivosUsuario();
        list = gArquivosUsuarios.getListUsuarios();

    }

    public Object efetuarLogin(String email, String senha){
        Usuario acharUsuario = list.stream().filter(x -> x.getEmail().equals(email)  && x.getSenha().equals(senha)).findFirst().orElse(null);

        return acharUsuario;

    }

    public Object efetuarCadastro(String nome, String email, String senha){
        Usuario acharUsuario = list.stream().filter(x -> x.getEmail().equals(email)  && x.getSenha().equals(senha)).findFirst().orElse(null);

        if(acharUsuario == null){
            list.add(new Usuario(nome, email, senha));
            gArquivosUsuarios.gravarUsuario(list);
            return acharUsuario;
        }else{
            return acharUsuario;
        }

    }


}

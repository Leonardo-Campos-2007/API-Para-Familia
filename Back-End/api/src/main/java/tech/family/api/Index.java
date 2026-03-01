package tech.family.api;

import tech.family.api.model.Usuario;
import tech.family.api.dao.UsuarioDAO;

public class Index {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setId(3);
        usuario.setNome("Caze");
        
        new UsuarioDAO().cadastrarUsuario(usuario);
    }
}

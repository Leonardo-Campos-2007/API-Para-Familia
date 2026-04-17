package com.br.leoo.service;

import java.util.List;

import com.br.leoo.model.Usuario;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario buscarPorId(Long id);
    Usuario atualizar(Long id, Usuario usuario);
    void deletar(Long id);

    
    
}

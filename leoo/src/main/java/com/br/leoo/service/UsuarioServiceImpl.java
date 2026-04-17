package com.br.leoo.service;

import com.br.leoo.model.Usuario;
import com.br.leoo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.management.RuntimeErrorException;

@Service  // ✅ Marca como componente de serviço do Spring
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired // ✅ Injeta o Repository automaticamente
    private UsuarioRepository usuarioRepository;

    // ✅ Salvar novo usuário
    @Override
    public Usuario salvar(Usuario usuario) {

        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);

    }

    // ✅ Listar todos
    @Override
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuarioAtualizado){
        Usuario usuarioExistente = buscarPorId(id);
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
          return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void deletar(Long id){
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }


}
package com.academia.api.service;

import com.academia.api.dto.UsuarioRequestDTO;
import com.academia.api.dto.UsuarioResponseDTO;
import com.academia.api.model.Usuario;
import com.academia.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listarTodos(Boolean ativo) {
        List<Usuario> usuarios = (ativo != null)
                ? usuarioRepository.findByAtivoOrderByNomeAsc(ativo)
                : usuarioRepository.findAll();

        return usuarios.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("Este CPF já está cadastrado!");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .build();

        return toResponseDTO(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (usuarioRepository.existsByCpfAndIdNot(dto.getCpf(), id)) {
            throw new RuntimeException("Este CPF já está cadastrado!");
        }

        usuario.setNome(dto.getNome());
        usuario.setTelefone(dto.getTelefone());
        usuario.setCpf(dto.getCpf());
        usuario.setDataNascimento(dto.getDataNascimento());

        return  toResponseDTO(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setTelefone(usuario.getTelefone());
        dto.setCpf(usuario.getCpf());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setAtivo(usuario.isAtivo());

        return dto;
    }
}

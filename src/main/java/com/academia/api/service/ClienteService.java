package com.academia.api.service;

import com.academia.api.dto.ClienteRequestDTO;
import com.academia.api.dto.ClienteResponseDTO;
import com.academia.api.model.Cliente;
import com.academia.api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        return toResponseDTO(cliente);
    }

    public ClienteResponseDTO cadastrarCliente(ClienteRequestDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .build();

        return  toResponseDTO(clienteRepository.save(cliente));
    }

    public ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());

        return  toResponseDTO(clienteRepository.save(cliente));
    }

    public void deletarCliente(Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setSenha(cliente.getSenha());
        dto.setTelefone(cliente.getTelefone());
        dto.setCpf(cliente.getCpf());
        dto.setDataNascimento(cliente.getDataNascimento());
        return dto;
    }
}

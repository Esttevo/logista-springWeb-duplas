package ctw.mi81.logistica.service;


import ctw.mi81.logistica.dto.ClienteRequestDTO;
import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.entity.Cliente;
import ctw.mi81.logistica.exception.EntidadeNaoEncontradaException;
import ctw.mi81.logistica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> listar(){
        List<ClienteResponseDTO> clienteResponseDTOS = clienteRepository.listar().stream().map(cliente -> toResponse(cliente)).toList();
        if(clienteResponseDTOS.isEmpty()) throw new EntidadeNaoEncontradaException("Lista Vazia");
        return clienteResponseDTOS;
    }

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = toEntity(clienteRequestDTO);
        return toResponse(clienteRepository.criar(cliente));
    }

    public ClienteResponseDTO toResponse(Cliente cliente){
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getCnpj(),
                cliente.getEndereco(),
                cliente.getCidade(),
                cliente.getEstado()
        );
    }

    private String nome;
    private String cpf;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String estado;

    public Cliente toEntity(ClienteRequestDTO requestDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(requestDTO.nome());
        cliente.setCpf(requestDTO.cpf());
        cliente.setCnpj(requestDTO.cnpj());
        cliente.setEndereco(requestDTO.endereco());
        cliente.setCidade(requestDTO.cidade());
        cliente.setEstado(requestDTO.estado());
        return cliente;
    }

}

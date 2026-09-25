package ctw.mi81.logistica.service;


import ctw.mi81.logistica.dto.ClienteRequestDTO;
import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.entity.Cliente;
import ctw.mi81.logistica.exception.EntidadeNaoEncontradaException;
import ctw.mi81.logistica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Serviço responsavel pelas regras de negocios relacionadas ao gereciamento do cliente
 */

@Service
public class ClienteService {

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Autowired
    ClienteRepository clienteRepository;

    /**
     * Buscar cliente
     * @param id do cliente
     * @throws EntidadeNaoEncontradaException
     * @return {@link ClienteResponseDTO}
     */
    public ClienteResponseDTO buscarPorId(Long id) {
        List<Cliente> listaClientes = clienteRepository.listar();

        Cliente clienteBuscado = listaClientes
                .stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente com id "+id+" não encontrado"));

        return toResponse(clienteBuscado);
    }

    /**
     * Buscar cliente
     * @return {@link List<ClienteResponseDTO>}
     */

    public List<ClienteResponseDTO> listar(){
        List<ClienteResponseDTO> clienteResponseDTOS = clienteRepository.listar().stream().map(cliente -> toResponse(cliente)).toList();
        if(clienteResponseDTOS.isEmpty()) throw new EntidadeNaoEncontradaException("Lista Vazia");
        return clienteResponseDTOS;
    }

    /**
     * Criar cliente
     * @param clienteRequestDTO Objeto contendo os dados de entrada para craição do cliente
     * @return cliente
     */

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = toEntity(clienteRequestDTO);
        return toResponse(clienteRepository.criar(cliente));
    }

    /**
     * Buscar cliente por CPF
     * @param info cpf do cliente
     * @throws EntidadeNaoEncontradaException
     * @return {@link ClienteResponseDTO}
     */
    public ClienteResponseDTO buscarPorCPF(String info) {
        List<Cliente> listaClientes = clienteRepository.listar();

        Cliente clienteBuscado = listaClientes.stream().findAny()
                .filter(cliente -> cliente.getCpf().equalsIgnoreCase(info))
                .orElseThrow(() -> new IllegalArgumentException("Cliente nao encontrado"));

        return toResponse(clienteBuscado);
    }
    /**
     * Buscar cliente por CNPJ
     * @param info CNPJ do cliente
     * @throws EntidadeNaoEncontradaException
     * @return {@link ClienteResponseDTO}
     */

    public ClienteResponseDTO buscarPorCNPJ(String info) {
        List<Cliente> listaClientes = clienteRepository.listar();

        Cliente clienteBuscado = listaClientes.stream().findAny()
                .filter(cliente -> cliente.getCnpj().equalsIgnoreCase(info))
                .orElseThrow(() -> new IllegalArgumentException("Cliente nao encontrado"));

        return toResponse(clienteBuscado);
    }

    /**
     * Deletar cliente por id
     * @param id do cliente a ser deletado
     */

    public void deletar(Long id) {
        Cliente clienteRemover = clienteRepository.listar()
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findAny()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente com id "+id+ " não encontrado!"));

        clienteRepository.deletar(clienteRemover);
    }

    /**
     * Transformar cliente em cliente Response
     * @param cliente
     * @return {@link ClienteResponseDTO}
     */

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


    /**
     * Transformar clienteRequest em cliente
     * @param requestDTO motoristaRequest
     * @return {@link Cliente}
     */
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

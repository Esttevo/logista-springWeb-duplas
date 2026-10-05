package ctw.mi81.logistica.service;

import ctw.mi81.logistica.dto.PedidoRequestDTO;
import ctw.mi81.logistica.dto.PedidoResponseDTO;
import ctw.mi81.logistica.entity.Cliente;
import ctw.mi81.logistica.entity.Pedido;
import ctw.mi81.logistica.entity.StatusPedido;
import ctw.mi81.logistica.exception.EntidadeNaoEncontradaException;
import ctw.mi81.logistica.repository.ClienteRepository;
import ctw.mi81.logistica.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public PedidoService (PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Autowired
    private PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    /**
     * metodo de criar Pedido
     * @param pedidoRequestDTO
     * @return {@link PedidoResponseDTO}
     */
    public PedidoResponseDTO criar (PedidoRequestDTO pedidoRequestDTO){
        Pedido pedido = toEntity(pedidoRequestDTO);

        Cliente cliente = clienteRepository.listar()
                .stream()
                .filter(cliente1 -> cliente1.getId().equals(pedidoRequestDTO.idCliente()))
                .findAny()
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Cliente com id "+pedidoRequestDTO.idCliente()+" não encontrado"));

        return toResponse(pedidoRepository.criar(pedido));
    }

    /**
     * Metodo de cancelar pedido
     * @param id do pedido a ser cancelado
     * @return {@link PedidoResponseDTO}
     */
    public PedidoResponseDTO cancelarPedido(Long id) {
        Pedido pedido = pedidoRepository.lista()
                .stream()
                .filter(pedido1 -> pedido1.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pedido com id "+id+" não encontrado"));

        pedido.setStatusPedido(StatusPedido.CANCELADO);

        return toResponse(pedido);
    }

    /**
     * Passar um pedidoRequestDTO para entidade Pedido
     * @param pedidoRequestDTO
     * @return {@link Pedido}
     */
    private Pedido toEntity(PedidoRequestDTO pedidoRequestDTO){
        Pedido pedido = new Pedido();

        pedido.setIdCliente(pedidoRequestDTO.idCliente());
        pedido.setVolumeM3(pedidoRequestDTO.volumeM3());
        pedido.setPesoKg(pedidoRequestDTO.pesoKg());
        pedido.setStatusPedido(StatusPedido.PENDENTE);

        return pedido;
    }

    /**
     * Passar uma entidade Pedido para Pedido Response
     * @param pedido
     * @return {@link PedidoResponseDTO}
     */

    private PedidoResponseDTO toResponse(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getIdCliente(),
                pedido.getVolumeM3(),
                pedido.getPesoKg(),
                pedido.getStatusPedido()
        );
    }


}

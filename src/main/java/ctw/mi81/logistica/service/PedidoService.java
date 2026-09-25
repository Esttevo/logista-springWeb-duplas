package ctw.mi81.logistica.service;

import ctw.mi81.logistica.dto.PedidoRequestDTO;
import ctw.mi81.logistica.dto.PedidoResponseDTO;
import ctw.mi81.logistica.entity.Pedido;
import ctw.mi81.logistica.entity.StatusPedido;
import ctw.mi81.logistica.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public PedidoService (PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponseDTO criar (PedidoRequestDTO pedidoRequestDTO){
        Pedido pedido = toEntity(pedidoRequestDTO);
        return toResponse(pedidoRepository.criar(pedido));
    }

    public Pedido toEntity(PedidoRequestDTO pedidoRequestDTO){
        Pedido pedido = new Pedido();

        pedido.setIdCliente(pedidoRequestDTO.idCliente());
        pedido.setVolumeM3(pedidoRequestDTO.volumeM3());
        pedido.setPesoKg(pedidoRequestDTO.pesoKg());
        pedido.setStatusPedido(StatusPedido.PENDENTE);

        return pedido;
    }

    public PedidoResponseDTO toResponse(Pedido pedido){
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getIdCliente(),
                pedido.getVolumeM3(),
                pedido.getPesoKg(),
                pedido.getStatusPedido()
        );
    }


}

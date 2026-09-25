package ctw.mi81.logistica.repository;

import ctw.mi81.logistica.dto.PedidoRequestDTO;
import ctw.mi81.logistica.entity.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    private static List<Pedido> pedidos = new ArrayList<>();
    private static Long id = 0L;

    public Pedido criar (Pedido pedido){
        pedido.setId(++id);
        pedidos.add(pedido);
        return pedido;
    }

}

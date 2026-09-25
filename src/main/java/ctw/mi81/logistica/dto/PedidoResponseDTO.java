package ctw.mi81.logistica.dto;

import ctw.mi81.logistica.entity.StatusPedido;
import io.swagger.v3.oas.annotations.media.Schema;

public record PedidoResponseDTO(
        @Schema( description = "Id do peidido", example = "1")
        Long id,
        @Schema (description = "Id do cliente", example = "1")
        Long idCliente,

        @Schema (description = "Volume do pedido", example = "10")
        Double volumeM3,

        @Schema (description = "Peso do pedido em kg", example = "0.400")
        Double pesoKg,

        @Schema (description = "Status do pedido", example = "PENDENTE")
        StatusPedido statusPedido
) {
}

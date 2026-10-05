package ctw.mi81.logistica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record PedidoRequestDTO(
        @NotNull (message = "ID do cliente nao pode ser nulo")
        @Positive (message = "Id do cliente nao pode ser negativo")
        Long idCliente,

        @NotNull (message = "volume nao pode ser nulo")
        @Positive (message = "volume precisa ser positivo")
        Double volumeM3,

        @NotNull (message = "peso nao pode ser nulo")
        @Positive (message = "Peso nao pode ser negativo")
        Double pesoKg
) {
}

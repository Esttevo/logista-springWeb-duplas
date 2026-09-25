package ctw.mi81.logistica.controller;

import ctw.mi81.logistica.dto.PedidoRequestDTO;
import ctw.mi81.logistica.dto.PedidoResponseDTO;
import ctw.mi81.logistica.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 /**
 * Controller de pedido, recebe os endpoints de pedido
 */

@Tag(
        name = "Pedidos",
        description = "Classe que gerencia os endpoints de Pedido"
)

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {



   private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    /**
     * Metodo de criar Pedido
     * @param pedidoRequestDTO
     * @return {@link ResponseEntity<PedidoResponseDTO}
     */

    @Operation(
            summary = "Criar pedido",
            description = "Cria um Pedido novo"
    )
    @ApiResponses ({
            @ApiResponse (
                    responseCode = "201",
                    description = "Pedido criado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "Erro ao criar pedido"
            )
    })
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar (@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pedidoRequestDTO));
    }

    /**
     * Metodo de cancelar pedido
     * @param id Do pedido que vai ser cancelado
     * @return {@link ResponseEntity<PedidoResponseDTO>}
     */

    @Operation (
            summary = "Cancelar pedido",
            description = "Cancela o pedido a partir do id passado"
    )
    @ApiResponses ({
            @ApiResponse (
                    responseCode = "200",
                    description = "Pedido cancelado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "Erro ao cancelar Pedido"
            )
    })


    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> cancelarPedido(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.cancelarPedido(id));
    }
}

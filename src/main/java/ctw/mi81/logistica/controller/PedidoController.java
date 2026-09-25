package ctw.mi81.logistica.controller;

import ctw.mi81.logistica.dto.PedidoRequestDTO;
import ctw.mi81.logistica.dto.PedidoResponseDTO;
import ctw.mi81.logistica.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResponseEntity<PedidoResponseDTO> create (@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pedidoRequestDTO));
    }
}

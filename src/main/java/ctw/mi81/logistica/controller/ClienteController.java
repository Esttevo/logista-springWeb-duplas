package ctw.mi81.logistica.controller;


import ctw.mi81.logistica.dto.ClienteRequestDTO;
import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller de cliente, recebe os endpoints de clientes
 */

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {


    public ClienteController (ClienteService clienteService){
        this.service = clienteService;
    }
    @Autowired
    ClienteService service;


    /**
     * Listar clientes
     * @return {@link ResponseEntity<List<ClienteResponseDTO>>}
     */

    @Operation (
            summary = "Buscar todos os clientes",
            description = "Retorna uma lista com todos os clientes"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Listado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "Lista Vazia"
            )
    })
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar (){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(clienteRequestDTO));
    }
}

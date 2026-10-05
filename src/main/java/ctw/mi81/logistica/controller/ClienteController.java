package ctw.mi81.logistica.controller;


import ctw.mi81.logistica.dto.ClienteRequestDTO;
import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller de cliente, recebe os endpoints de clientes
 */

@Tag(
        name = "Clientes",
        description = "Classe que gerencia os endpoints de cliente"
)

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


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
       return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    /**
     * cadastrar clientes
     * @param clienteRequestDTO DTO com os dados necessarios  pra criação do motorista
     * @return {@link ResponseEntity<ClienteResponseDTO>}
     */

    @Operation (
            summary = "Cadastrar Cliente",
            description = "Retorna o cliente cadastrado"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Cliente criado com sucesso!"
            ),
            @ApiResponse (
                    responseCode = "400",
                    description = "cliente não criado"
            )
    })
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(clienteRequestDTO));
    }

    /**
     * buscar cliente por cpf
     * @param info cpf do cliente
     * @return {@link ResponseEntity<ClienteResponseDTO>}
     */

    @Operation (
            summary = "buscar cliente por cpf",
            description = "Retorna o cliente"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Cliente buscado por cpf com sucesso!"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "cliente não encontrado"
            )
    })
    @GetMapping("/cnpj")
    public ResponseEntity<ClienteResponseDTO> buscarPorCPF(@RequestParam (required = false) String info) {
        return ResponseEntity.ok().body(service.buscarPorCPF(info));
    }

    /**
     * buscar cliente por cnpj
     * @param info cnpj do cliente
     * @return {@link ResponseEntity<ClienteResponseDTO>}
     */

    @Operation (
            summary = "buscar cliente por cnpj",
            description = "Retorna o cliente"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Cliente buscado por cnpj com sucesso!"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "cliente não encontrado"
            )
    })
    @GetMapping("/cpf")
    public ResponseEntity<ClienteResponseDTO> buscarPorCNPJ(@RequestParam (required = false) String info) {
        return ResponseEntity.ok().body(service.buscarPorCNPJ(info));
    }

    /**
     * deletar o cliente
     * @param id do cliente
     * @return {@link ResponseEntity<ClienteResponseDTO>}
     */

    @Operation (
            summary = "deletar cliente",
            description = "Retorna o void"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Cliente deletado com sucesso!"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "cliente não encontrado"
            )
    })


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

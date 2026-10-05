package ctw.mi81.logistica.controller;

import ctw.mi81.logistica.dto.MotoristaRequestDTO;
import ctw.mi81.logistica.dto.MotoristaResponseDTO;
import ctw.mi81.logistica.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * Controller de motorista, recebe os endpoints de motorista
 */

@Tag(
        name = "Motoristas",
        description = "Classe que gerencia os endpoints de Motorista"
)

@RestController
@RequestMapping("/api/v1/motoristas")
public class MotoristaController {

    public MotoristaController(MotoristaService motoristaService){
        this.service = motoristaService;
    }
    @Autowired
    MotoristaService service;


    /**
     * Listar motorista
     * @return {@link ResponseEntity<List<MotoristaResponseDTO>>}
     */

    @Operation(
            summary = "Buscar todos os motorusta",
            description = "Retorna uma lista com todos os motorista"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "Lista Vazia"
            )
    })

    @GetMapping
    public ResponseEntity<List<MotoristaResponseDTO>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    /**
     * criar motorista
     * @param motoristaRequestDTO DTO com os dados necessarios  pra criação do motorista
     * @return {@link ResponseEntity<MotoristaResponseDTO>}
     *
     */

    @Operation (
            summary = "criar motorista",
            description = "Retorna o motorista criado"
    )
    @ApiResponses({
            @ApiResponse (
                    responseCode = "200",
                    description = "Motorista criado com sucesso!"
            ),
            @ApiResponse (
                    responseCode = "400",
                    description = "Motorista não criado"
            )
    })

    @PostMapping
    public ResponseEntity<MotoristaResponseDTO> criar(@RequestBody @Valid MotoristaRequestDTO motoristaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(motoristaRequestDTO));
    }

}

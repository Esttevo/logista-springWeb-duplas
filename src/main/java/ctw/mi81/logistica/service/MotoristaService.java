package ctw.mi81.logistica.service;


import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.dto.MotoristaRequestDTO;
import ctw.mi81.logistica.dto.MotoristaResponseDTO;
import ctw.mi81.logistica.entity.Cliente;
import ctw.mi81.logistica.entity.Motorista;
import ctw.mi81.logistica.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Serviço responsavel pelas regras de negocios relacionadas ao gereciamento do motorista
 */

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }


    /**
     * lista Motoristas
     * @return {@link List<MotoristaResponseDTO>}
     */
    public List<MotoristaResponseDTO> listar(){
        List<MotoristaResponseDTO> motoristaResponseDTOS = motoristaRepository.listar().stream().map(motorista -> toResponse(motorista)).toList();
        return motoristaResponseDTOS;
    }

    /**
     * Criar motorista
     * @param motoristaRequestDTO Objeto contendo os dados de entrada para craição do cliente
     * @return {@link MotoristaResponseDTO}
     */
    public MotoristaResponseDTO criar(MotoristaRequestDTO motoristaRequestDTO){
        Motorista motorista = toEntity(motoristaRequestDTO);
        return toResponse(motoristaRepository.criar(motorista));
    }

    /**
     * Transformar clienteRequest em cliente
     * @param motorista clienteRequest
     * @return {@link MotoristaResponseDTO}
     */
    private MotoristaResponseDTO toResponse(Motorista motorista){
        return new MotoristaResponseDTO(
                motorista.getId(),
                motorista.getNome(),
                motorista.getCpf(),
                motorista.getCnpj(),
                motorista.getEndereco(),
                motorista.getCidade(),
                motorista.getEstado()
        );
    }

    /**
     * Transformar motoristaRequest em cliente
     * @param motoristaRequestDTO clienteRequest
     * @return {@link Cliente}
     */
    private Motorista toEntity (MotoristaRequestDTO motoristaRequestDTO){
        Motorista motorista = new Motorista();
        motorista.setNome(motoristaRequestDTO.nome());
        motorista.setCpf(motoristaRequestDTO.cpf());
        motorista.setCnpj(motoristaRequestDTO.cnpj());
        motorista.setEndereco(motoristaRequestDTO.endereco());
        motorista.setCidade(motoristaRequestDTO.cidade());
        motorista.setEstado(motoristaRequestDTO.estado());
        return motorista;
    }
}

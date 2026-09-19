package ctw.mi81.logistica.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represatação publica de um cliente retornado pela API
 * @param id Id do cliente
 * @param nome Nome do cliente
 * @param cpf CPF do clinte
 * @param cnpj CNPJ do cliente
 * @param endereco Endereco do cliente
 * @param cidade Cidade do cliente
 * @param estado Estado do cliente
 */


public record ClienteResponseDTO(
        @Schema( description = "Id do cliente", example = "1")
        Long id,
        @Schema( description = "Nome do cliente", example = "João")
        String nome,
        @Schema( description = "CPF do cliente", example = "000.000.000-00")
        String cpf,
        @Schema( description = "CNPJ do clinte", example = "000.000.000/0000-00")
        String cnpj,
        @Schema( description = "Endereco do cliente", example = "rua joão pessoa, 0000")
        String endereco,
        @Schema( description = "Cidade do cliente", example = "Jaragua do Sul")
        String cidade,
        @Schema(description = "Estado do cliente", example = "Santa Catarina")
        String estado
) {
}

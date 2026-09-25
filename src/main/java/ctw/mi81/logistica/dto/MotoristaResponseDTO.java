package ctw.mi81.logistica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Represatação publica de um motorista retornado pela API
 * @param id Id do motorista
 * @param nome Nome do motorista
 * @param cpf CPF do motorista
 * @param cnpj CNPJ do motorista
 * @param endereco Endereco do motorista
 * @param cidade Cidade do motorista
 * @param estado Estado do motorista
 */

    @Schema (description = "Dados do motorista retornados pela api")

public record MotoristaResponseDTO(
        @Schema( description = "Id do motorista", example = "1")
        Long id,
        @Schema( description = "Nome do motorista", example = "João")
        String nome,
        @Schema( description = "CPF do motorista", example = "000.000.000-00")
        String cpf,
        @Schema( description = "CNPJ do motorista", example = "000.000.000/0000-00")
        String cnpj,
        @Schema( description = "Endereco do motorista", example = "rua joão pessoa, 0000")
        String endereco,
        @Schema( description = "Cidade do motorista", example = "Jaragua do Sul")
        String cidade,
        @Schema(description = "Estado do motorista", example = "Santa Catarina")
        String estado
) {
}

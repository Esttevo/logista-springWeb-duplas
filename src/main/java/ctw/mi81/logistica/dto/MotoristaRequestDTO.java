package ctw.mi81.logistica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Dados necessario paara cadastrar motorista
 * @param nome Nome do motorista
 * @param cpf CPF do motorista
 * @param cnpj CNPJ do motorista
 * @param endereco Endereco do motorista
 * @param cidade Cidade do motorista
 * @param estado Estado do motorista
 */


@Schema (description = "Dados do motorista pedidos pela api")
public record MotoristaRequestDTO(
        @Schema(
                description = "Nome do motorista",
                example = "João"
        )
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 100, message = "O nome dever possuir entre 3 e 100 caracteres")
        String nome,

        @Schema(
                description = "CPF do motorista",
                example = "000.000.000-00"
        )
        @NotBlank(message = "CPF não pode estar em branco")
        @Size(min = 11, message = "CPF deve possuir 11 numeros")
        String cpf,

        @Schema(
                description = "CNPJ do motorista",
                example = "  000.000.000/0000-00"
        )
        String cnpj,

        @Schema(
                description = "Endereço do motorista",
                example = "rua João Pessoa, 0000"

        )
        @NotBlank(message = "Endereço não pode estar em branco")
        String endereco,


        @Schema(
                description = "Cidade do motorista",
                example = "Jaragua do Sul"
        )

        @NotBlank(message = "Cidade não pode estar em branco")
        String cidade,

        @Schema(
                description = "Estado do motorista",
                example = "Santa Catarina"

        )
        @NotBlank(message = "Estado não pode ficar em branco")
        String estado
) {
}

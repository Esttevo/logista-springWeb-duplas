package ctw.mi81.logistica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.beans.XMLEncoder;

/**
 * Dados necessario paara cadastrar
 * @param nome Nome do cliente
 * @param cpf CPF do clinte
 * @param cnpj CNPJ do cliente
 * @param endereco Endereco do cliente
 * @param cidade Cidade do cliente
 * @param estado Estado do cliente
 */

public record ClienteRequestDTO(

        @Schema(
                description = "Nome do cliente",
                example = "João"
        )
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 100, message = "O nome dever possuir entre 3 e 100 caracteres")
        String nome,

        @Schema(
                description = "CPF do cliente",
                example = "000.000.000-00"
        )
        @NotBlank(message = "CPF não pode estar em branco")
        @Size(min = 11, message = "CPF deve possuir 11 numeros")
        String cpf,

        @Schema(
                description = "CNPJ do cliente",
                example = "  000.000.000/0000-00"
        )
        String cnpj,

        @Schema(
                description = "Endereço do cliente",
                example = "rua João Pessoa, 0000"

        )
        @NotBlank(message = "Endereço não pode estar em branco")


        String endereco,
        @Schema(
                description = "Cidade do cliente",
                example = "Jaragua do Sul"
        )

        @NotBlank(message = "Cidade não pode estar em branco")
        String cidade,

        @Schema(
                description = "Estado do cliente",
                example = "Santa Catarina"

        )
        @NotBlank(message = "Estado não pode ficar em branco")

        String estado

) {
}

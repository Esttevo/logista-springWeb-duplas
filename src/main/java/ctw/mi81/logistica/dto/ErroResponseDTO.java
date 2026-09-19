package ctw.mi81.logistica.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Exposição do erro para o usuario
 * @param codigoErro codigo do tipo do erro
 * @param tipoErro Mensagem do tipo do erro
 * @param mensagemErro Mensagem especfica do que gerou o erro
 * @param URI URI de request do erro
 */
public record ErroResponseDTO(
        @Schema(
                description = "Codigo do erro",
                example = "404")
        int codigoErro,
        @Schema(
                description = "Tipo do erro padrão",
                example = "Bad Request"
        )
        String tipoErro,
        @Schema(
                description = "Mensagem de erro especifica",
                example = "Lista Vazia"
        )
        String mensagemErro,
        @Schema(
                description = "request URI",
                example = "/api/v1/clientes"
        )
        String URI
) {
}

package ctw.mi81.logistica.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Tarefas")
                        .version("1.0")
                        .description("API REST desenvolvida para criação, leitura, alteração de status e remoção de tarefas")
                        .contact(new Contact()
                                .name("Suporte Técnico")
                                .email("mateus_mathias@estudante.sesisenai.org.br")
                        )
                );
    }
}

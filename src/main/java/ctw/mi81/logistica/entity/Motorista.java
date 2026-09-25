package ctw.mi81.logistica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa Motorista dentro do sistema
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Motorista {

    private Long id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String estado;
}

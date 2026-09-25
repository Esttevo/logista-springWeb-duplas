
package ctw.mi81.logistica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa pedido dentro do sistema
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Long id;
    private Long idCliente;
    private Double volumeM3;
    private Double pesoKg;
    private StatusPedido statusPedido;
}

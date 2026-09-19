package ctw.mi81.logistica.repository;

import ctw.mi81.logistica.dto.ClienteRequestDTO;
import ctw.mi81.logistica.dto.ClienteResponseDTO;
import ctw.mi81.logistica.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository

public class ClienteRepository {

    private static List<Cliente> clientes = new ArrayList<>();
    private static Long id = 0L;

    public List<Cliente> listar(){
        return clientes;
    }

    public Cliente criar(Cliente cliente){
        cliente.setId(++id);
        clientes.add(cliente);
        return cliente;
    }

}

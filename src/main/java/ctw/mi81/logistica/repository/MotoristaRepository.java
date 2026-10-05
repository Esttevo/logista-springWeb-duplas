package ctw.mi81.logistica.repository;

import ctw.mi81.logistica.entity.Motorista;
import ctw.mi81.logistica.service.MotoristaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio reponsavel pelo acesso dos dados do motorista
 */

@Repository
public class MotoristaRepository {

    private static List<Motorista> motoristas= new ArrayList<>();
    private static Long id = 0L;

    public List<Motorista> listar(){
        return motoristas;
    }

    public Motorista criar(Motorista motorista){
        motorista.setId(++id);
        motoristas.add(motorista);
        return motorista;
    }


}

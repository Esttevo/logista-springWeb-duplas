package ctw.mi81.logistica.exception;

import ctw.mi81.logistica.dto.ErroResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<ErroResponseDTO> tratarEntidadeNaoEncontrada(
            EntidadeNaoEncontradaException ex, HttpServletRequest request) {

        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                "Entidade nao encontrada",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(erroResponseDTO.codigoErro()).body(erroResponseDTO);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> tratarBadRequest(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        String mensagem = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField()+ ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Erro validação",
                mensagem,
                request.getRequestURI()
        );

        return ResponseEntity.status(erroResponseDTO.codigoErro()).body(erroResponseDTO);
    }
}

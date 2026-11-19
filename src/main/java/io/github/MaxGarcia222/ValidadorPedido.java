package io.github.MaxGarcia222;

public class ValidadorPedido {
    public void validar(int cantidad, int stockDisponible, String emailCliente){
        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (cantidad > stockDisponible){
            throw new IllegalStateException("Stock insuficiente");
        }
        if (emailCliente == null || !emailCliente.contains("@")){
            throw new IllegalArgumentException("Email inválido");
        }
    }
}

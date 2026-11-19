import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorPedidoTest {

    @Test
    void sinLanzarException() {
        // Arrange (preparar)
        ValidadorPedido validador = new ValidadorPedido();

        // Assert (verificar)
        assertDoesNotThrow(() -> validador.validar(10, 20, "max@gmail.com"));    }

    @Test
    void cantidadCeroLanzaExcepcion() {
        ValidadorPedido validador = new ValidadorPedido();

        IllegalArgumentException error = assertThrows(
                IllegalArgumentException.class,          // qué excepción espero
                () -> validador.validar(0, 1, "kldangkd@gmail.com")   // el código que debería lanzarla
        );

        assertEquals("La cantidad debe ser mayor a 0", error.getMessage());
    }

    @Test
    void cantidadMayorAStockLanzaExcepcion() {
        ValidadorPedido validador = new ValidadorPedido();

        IllegalStateException error = assertThrows(
                IllegalStateException.class,          // qué excepción espero
                () -> validador.validar(2, 1, "kldangkd@gmail.com")   // el código que debería lanzarla
        );

        assertEquals("Stock insuficiente", error.getMessage());
    }

    @Test
    void emailNullLanzaExcepcion() {
        ValidadorPedido validador = new ValidadorPedido();

        IllegalArgumentException error = assertThrows(
                IllegalArgumentException.class,          // qué excepción espero
                () -> validador.validar(2, 3, null)   // el código que debería lanzarla
        );

        assertEquals("Email inválido", error.getMessage());
    }

    @Test
    void emailSinArrobaLanzaExcepcion() {
        ValidadorPedido validador = new ValidadorPedido();

        IllegalArgumentException error = assertThrows(
                IllegalArgumentException.class,          // qué excepción espero
                () -> validador.validar(2, 5, "kldangkdgmail.com")   // el código que debería lanzarla
        );

        assertEquals("Email inválido", error.getMessage());
    }
}

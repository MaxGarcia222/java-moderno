package io.github.MaxGarcia222;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraDescuentoTest {

    @Test
    void aplicaQuincePorCientoAMil() {
        // Arrange (preparar)
        CalculadoraDescuento calculadora = new CalculadoraDescuento();

        // Act (ejecutar)
        int resultado = calculadora.aplicar(1000, 15);

        // Assert (verificar)
        assertEquals(850, resultado);
    }

    @Test
    void porcentajeNegativoLanzaExcepcion() {
        CalculadoraDescuento calculadora = new CalculadoraDescuento();

        IllegalArgumentException error = assertThrows(
                IllegalArgumentException.class,          // qué excepción espero
                () -> calculadora.aplicar(1000, -5)      // el código que debería lanzarla
        );

        assertEquals("El porcentaje debe estar entre 0 y 100", error.getMessage());
    }


    /*Nivel 2 (con pistas)
        Agregá tres tests más a io.github.MaxGarcia222.CalculadoraDescuentoTest:

        Un descuento de 0% devuelve el mismo precio.
        Un descuento de 100% devuelve 0.
        Un porcentaje de 150 lanza IllegalArgumentException.
     */

    @Test
    void  descuentoCeroDevuelveMismoPrecio (){
            // Arrange (preparar)
            CalculadoraDescuento calculadora = new CalculadoraDescuento();
            int precio = 1500;
            // Act (ejecutar)
            int resultado = calculadora.aplicar(precio, 0);

            // Assert (verificar)
            assertEquals(precio, resultado);
    }

    @Test
    void  descuentoCienDevuelveCero (){
            // Arrange (preparar)
            CalculadoraDescuento calculadora = new CalculadoraDescuento();
            int precio = 1500;
            // Act (ejecutar)
            int resultado = calculadora.aplicar(precio, 100);

            // Assert (verificar)
            assertEquals(0, resultado);
    }

    @Test
    void porcentajeCientoCincuentaLanzaException() {
        CalculadoraDescuento calculadora = new CalculadoraDescuento();

        IllegalArgumentException error = assertThrows(
                IllegalArgumentException.class,          // qué excepción espero
                () -> calculadora.aplicar(1000, 150)      // el código que debería lanzarla
        );

        assertEquals("El porcentaje debe estar entre 0 y 100", error.getMessage());
    }





}
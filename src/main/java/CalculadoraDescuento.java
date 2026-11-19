public class CalculadoraDescuento {

    public int aplicar(int precio, int porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }
        return precio - precio * porcentaje / 100;
    }


}
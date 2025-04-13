public class Operations {

    public int sumar(Values value) {
        int resultado = value.getA() + value.getB();
        value.setR(resultado);
        return resultado;
    }

    public int restar(Values value) {
        int resultado = value.getA() - value.getB();
        value.setR(resultado);
        return resultado;
    }

    public int multiplicar(Values value) {
        int resultado = value.getA() * value.getB();
        value.setR(resultado);
        return resultado;
    }
}

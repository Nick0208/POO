public class Main {
    public static void main(String[] args) {

        Operations operaciones = new Operations();
        Values value = new Values();

        value.setA(5);
        value.setB(10);
        operaciones.sumar(value);
        System.out.println("El resultado de la suma es: " + value.getR());

        value.setA(19);
        value.setB(11);
        operaciones.restar(value);
        System.out.println("El resultado de la resta es: " + value.getR());

        value.setA(25);
        value.setB(6);
        operaciones.multiplicar(value);
        System.out.println("El resultado de la multiplicación es: " + value.getR());
    }
}

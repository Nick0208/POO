//import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Operations resultado = new Operations();
        resultado.sumar(3, 2);
        System.out.print(resultado.r);
        resultado.restar(4, 6);
        System.out.print(resultado.r);
        resultado.multiplicar(34, 2);
        System.out.print(resultado.r);
        resultado.potencia(2, 3);
        System.out.print(resultado.r);
        
    }
}
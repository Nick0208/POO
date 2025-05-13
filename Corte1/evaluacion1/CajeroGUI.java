import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CajeroGUI {
    private JFrame frame;
    private Cuenta cuenta;
    private boolean esDeposito;

    public CajeroGUI() {
        cuenta = new Cuenta();
        frame = new JFrame("Cajero Automático");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        mostrarMenu();
        frame.setVisible(true);
    }

    private void mostrarMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnDepositar = crearBoton("Depositar", e -> {
            esDeposito = true;
            mostrarPanelDeposito();
        });
        JButton btnRetirar = crearBoton("Retirar", e -> {
            esDeposito = false;
            mostrarPanelRetiro();
        });
        JButton btnConsultar = crearBoton("Consultar Saldo", e -> mostrarSaldo());
        JButton btnSalir = crearBoton("Salir", e -> System.exit(0));

        frame.add(btnDepositar);
        frame.add(btnRetirar);
        frame.add(btnConsultar);
        frame.add(btnSalir);

        frame.revalidate();
        frame.repaint();
    }

    private JButton crearBoton(String texto, ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(accion);
        return boton;
    }

    private void mostrarPanelDeposito() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        int[] montos = {100000, 200000, 300000, 400000, 500000, 1000000};
        for (int monto : montos) {
            JButton boton = crearBoton(String.valueOf(monto), e -> procesarTransaccion(monto));
            frame.add(boton);
        }


        JButton btnVolver = crearBoton("Volver", e -> mostrarMenu());
        frame.add(btnVolver);

        frame.revalidate();
        frame.repaint();
    }

    private void mostrarPanelRetiro() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        int[] montos = {100000, 200000, 300000, 400000, 500000, 1000000};
        for (int monto : montos) {
            JButton boton = crearBoton(String.valueOf(monto), e -> procesarTransaccion(monto));
            frame.add(boton);
        }

        JButton btnVolver = crearBoton("Volver", e -> mostrarMenu());
        frame.add(btnVolver);

        frame.revalidate();
        frame.repaint();
    }

    private void procesarTransaccion(int valor) {
        boolean exito = esDeposito ? cuenta.depositar(valor) : cuenta.retirar(valor);
        if (!exito) {
            JOptionPane.showMessageDialog(frame, "Transacción inválida. Verifique el saldo.");
        }
        mostrarMenu();
    }

    private void mostrarSaldo() {
        JOptionPane.showMessageDialog(frame, "Saldo actual: $" + cuenta.getSaldo(), "Consulta de Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CajeroGUI::new);
    }
}

import javax.swing.*;
import java.awt.*;

public class PanelDeposito extends JPanel {
    public PanelDeposito(ActionListener depositoAction, ActionListener volverAction) {
        setLayout(new GridLayout(4, 2, 10, 10));
        
        for (int monto : new int[]{100000, 200000, 300000, 400000, 500000, 1000000}) {
            JButton boton = new JButton(String.valueOf(monto));
            boton.addActionListener(depositoAction);
            add(boton);
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(volverAction);
        add(btnVolver);
    }
}

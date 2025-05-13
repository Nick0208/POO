import java.io.*;
import java.nio.file.*;

public class Cuenta {
    private int saldo;

    public Cuenta() {
        saldo = 0;
        cargarSaldo();
    }

    public boolean depositar(int monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        guardarSaldo();
        return true;
    }

    public boolean retirar(int monto) {
        if (monto <= 0 || saldo < monto) {
            return false;
        }
        saldo -= monto;
        guardarSaldo();
        return true;
    }

    public int getSaldo() {
        return saldo;
    }

    private void cargarSaldo() {
        try {
            Path path = Paths.get("saldo.txt");
            if (Files.exists(path)) {
                saldo = Integer.parseInt(Files.readString(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarSaldo() {
        try {
            Files.writeString(Paths.get("saldo.txt"), String.valueOf(saldo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

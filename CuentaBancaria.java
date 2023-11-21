package cajeroautomatico;

public class CuentaBancaria {
    private String usuario;
    private String contraseña;
    private double saldo;

    // Constructor
    public CuentaBancaria(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = 0.0;
    }
    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos para operaciones en la cuenta (retiro, depósito, etc.)
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro $" + cantidad + ". Saldo actual: $" + saldo);
        } else {
            System.out.println("No tiene saldo suficiente para realizar esta operación.");
        }
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito $" + cantidad + ". Saldo actual: $" + saldo);
    }
}

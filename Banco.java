package cajeroautomatico;
import java.util.HashMap;
import java.util.Map;
class Banco {
    private Map<String, CuentaBancaria> cuentas = new HashMap<>();
    private String usuarioActual = null;

    public void crearCuenta(String usuario, String contraseña) {
        if (!cuentas.containsKey(usuario)) {
            CuentaBancaria nuevaCuenta = new CuentaBancaria(usuario, contraseña);
            cuentas.put(usuario, nuevaCuenta);
            System.out.println("Cuenta creada con éxito. Ahora puede iniciar sesión.");
        } else {
            System.out.println("Este nombre de usuario ya está en uso. Por favor, ingrese un nombre diferente.");
        }
    }

    public void iniciarSesion(String usuario, String contraseña) {
        if (cuentas.containsKey(usuario) && cuentas.get(usuario).getContraseña().equals(contraseña)) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido a Bankzuco, " + usuarioActual + "!");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
        }
    }

    public void cerrarSesion() {
        usuarioActual = null;
        System.out.println("Sesión cerrada. Hasta pronto.");
    }

    public void verSaldo() {
        if (usuarioActual != null) {
            System.out.println("Saldo actual de " + usuarioActual + ": $" + cuentas.get(usuarioActual).getSaldo());
        }
    }

    public void retirarDinero(double cantidad) {
        if (usuarioActual != null) {
            cuentas.get(usuarioActual).retirar(cantidad);
        }
    }

    public void depositarDinero(double cantidad) {
        if (usuarioActual != null) {
            cuentas.get(usuarioActual).depositar(cantidad);
        }
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }
}


package cajeroautomatico;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class banksuko {

    private static Map<String, String> cuentas = new HashMap<>();
    private static Map<String, Double> saldos = new HashMap<>();
    private static String usuarioActual = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("Cajero Automatico Bankzuco");
            if (usuarioActual == null) {
                System.out.println("1. Iniciar sesion");
                System.out.println("2. Crear cuenta");
                System.out.println("3. Salir");
            } else {
                System.out.println("1. Ver saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Cerrar sesion");
            }

            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            if (usuarioActual == null) {
                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        crearCuenta();
                        break;
                    case 3:
                        System.out.println("Gracias por usar nuestro cajero automatico Bankzuco. Hasta Pronto. ");
                        System.exit(0);
                    default:
                        System.out.println("Opcion no valida. Por favor, seleccione otra opcion valida.");
                }
            } else {
                switch (opcion) {
                    case 1:
                        verSaldo();
                        break;
                    case 2:
                        retirarDinero();
                        break;
                    case 3:
                        depositarDinero();
                        break;
                    case 4:
                        usuarioActual = null;
                        System.out.println("Sesion cerrada. Hasta Pronto. ");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, seleccione otra opcion valida.");
                }
            }
        }
    }
    private static void crearCuenta() {
        System.out.print("Ingrese un nombre de usuario para su nueva cuenta: ");
        String nuevoUsuario = scanner.next();

        if (cuentas.containsKey(nuevoUsuario)) {
            System.out.println("Este nombre de usuario ya esta en uso. Por favor, ingrese un nombre diferente.");
        } else {
            System.out.print("Ingrese una contraseña: ");
            String contraseña = scanner.next();
            cuentas.put(nuevoUsuario, contraseña);
            saldos.put(nuevoUsuario, 0.0); // Inicialmente, la cuenta se crea con saldo 0.
            System.out.println("Cuenta creada con exito. Ahora ya puede iniciar sesion.");
        }
    }
    private static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.next();

        if (cuentas.containsKey(usuario)) {
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.next();

            if (cuentas.get(usuario).equals(contraseña)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesion exitoso. Bienvenido a Bankzuco, " + usuarioActual + "!");
            } else {
                System.out.println("Contraseña incorrecta. Por favor, inténtelo de nuevo.");
            }
        } else {
            System.out.println("Nombre de usuario no encontrado, ingrese un nombre de ususario valido o registrese antes de iniciar sesion.");
        }
    }
    private static void verSaldo() {
        System.out.println("Saldo actual de " + usuarioActual + ": $" + saldos.get(usuarioActual));
    }

    private static void retirarDinero() {
        System.out.print("Ingrese la cantidad que desea retirar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad > saldos.get(usuarioActual)) {
            System.out.println("No tiene saldo suficiente para realizar esta operacion.");
        } else {
            saldos.put(usuarioActual, saldos.get(usuarioActual) - cantidad);
            System.out.println("Retiro $" + cantidad + ". Saldo actual: $" + saldos.get(usuarioActual));
        }
    }

    private static void depositarDinero() {
        System.out.print("Ingrese la cantidad que desea depositar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero (0).");
        } else {
            saldos.put(usuarioActual, saldos.get(usuarioActual) + cantidad);
            System.out.println("Deposito $" + cantidad + ". Saldo actual : $" + saldos.get(usuarioActual));
        }
    }
}


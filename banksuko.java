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

}
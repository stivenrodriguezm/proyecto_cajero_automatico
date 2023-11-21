package cajeroautomatico;

public class banksuko {

    private static Banco banco = new Banco();
    private static InterfazGrafica interfazUsuario = new InterfazGrafica();

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("Cajero Automático Bankzuco");

            if (banco.getUsuarioActual() == null) {
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Crear cuenta");
                System.out.println("3. Salir");
            } else {
                System.out.println("1. Ver saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Cerrar sesión");
            }

            int opcion = InterfazGrafica.leerOpcion();

            if (banco.getUsuarioActual() == null) {
                switch (opcion) {
                    case 1:
                        String usuario = InterfazGrafica.leerUsuario();
                        String contraseña = InterfazGrafica.leerContraseña();
                        banco.iniciarSesion(usuario, contraseña);
                        break;
                    case 2:
                        String nuevoUsuario = InterfazGrafica.leerUsuario();
                        String nuevaContraseña = InterfazGrafica.leerContraseña();
                        banco.crearCuenta(nuevoUsuario, nuevaContraseña);
                        break;
                    case 3:
                        System.out.println("Gracias por usar nuestro cajero automático Bankzuco. Hasta pronto.");
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione otra opción válida.");
                }
            } else {
                switch (opcion) {
                    case 1:
                        banco.verSaldo();
                        break;
                    case 2:
                        double cantidadRetiro = InterfazGrafica.leerCantidad();
                        banco.retirarDinero(cantidadRetiro);
                        break;
                    case 3:
                        double cantidadDeposito = InterfazGrafica.leerCantidad();
                        banco.depositarDinero(cantidadDeposito);
                        break;
                    case 4:
                        banco.cerrarSesion();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione otra opción válida.");
                }
            }
        }
    }
}



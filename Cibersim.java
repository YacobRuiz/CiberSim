import java.util.*;

public class Cibersim {
    public static void main(String[] args) {
        Network miRed = new Network();
        Scanner lector = new Scanner(System.in);

        //haciendo el menu(todo bien basico xdd)
        while (true) {
            System.out.println("----Bienvenido a CiberSim----");
            System.out.println("1: Escanear red");
            System.out.println("2: Iniciar sesion");
            System.out.println("3: Instrucciones");
            System.out.println("4: Salir");
            int opciones = lector.nextInt();
            lector.nextLine();

            switch (opciones) {
                case 1:
                    EscanearRed(miRed, lector); 
                    break;
                case 2:
                    IniciarSesion(miRed, lector); 
                    break;
                case 3:
                    Instrucciones(); 
                    break;
                case 4:
                    System.out.println("Saliendo de CiberSim...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void EscanearRed(Network laRed, Scanner scanner) {
        while (true) {
            System.out.println("--- Submenú de Escaneo ---");
            System.out.println("1. Escanear todos los hosts.");
            System.out.println("2. Escanear solo hosts activos.");
            System.out.println("3. Buscar host por IP.");
            System.out.println("4. Buscar host por puerto.");
            System.out.println("5: Salir");
            int opcionScan = scanner.nextInt();
            scanner.nextLine();
        
        NetworkScanner escaner = new NetworkScanner(laRed);
        
           if (opcionScan == 1) {
                escaner.scanAll();
            } else if (opcionScan == 2) {
                escaner.scanActive();
            } else if (opcionScan == 3) {
                System.out.print("Introduce la IP a buscar: ");
                int ipABuscar = scanner.nextInt();
                escaner.scanByIP(ipABuscar);
            } else if (opcionScan == 4){
                System.out.print("Introduce la puerto a buscar: ");
                int puertoABuscar = scanner.nextInt();
                escaner.scanByPort(puertoABuscar);
            } else{
                break;
            }
        }
    }

    public static void IniciarSesion(Network red, Scanner lectoor){
        Network miRed = red;
        boolean loginExitoso = false;
        Scanner lector = lectoor;

        System.out.println("Ingrese Usuario: ");
        String usuario = lector.nextLine();
        System.out.println("Ingrese contraseña: ");
        String contraseña = lector.nextLine();

        for (int i = 0; i < miRed.getHosts().size(); i++) {
            User usuarioActual = miRed.getHosts().get(i).getUser();

            if (usuario.equals(usuarioActual.getUser()) &&
            contraseña.equals(usuarioActual.getPassword())) {

            if (usuarioActual.isLocked()) {
                System.out.println("Usuario bloqueado. Intente en "
                    + usuarioActual.getRemainingLockSeconds() + " segundos.");
                return;
            }

            usuarioActual.reinicioDeIntentosFallidos();
            loginExitoso = true;

            System.out.println("Inicio de sesión exitoso");
            EscanearRed(miRed, lector);
            return;
            }
        }

        if (!loginExitoso) {
            System.out.println("Usuario o contraseña incorrectos");

        // opcional: aumentar intentos globales si quieres
        }


    }

    public static void Instrucciones(){
        System.out.println("estas en Instrucciones");
    }
}
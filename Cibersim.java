import java.util.*;

public class Cibersim {
    public static void main(String[] args) {
        Network miRed = new Network();
        Scanner lector = new Scanner(System.in);

        //haciendo el menu(todo bien basico xdd)
        while (true) {
            System.out.println("----Bienvenido a CiberSim----");
            System.out.println("1: Escaneo basico de red");
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
        NetworkScanner escaner = new NetworkScanner(laRed);
        System.out.println("Escaneo basico de red...");
        System.out.println(escaner.scanBasic()); 
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
                menuHosts(miRed, lector);
                return;
            }
        }

        if (!loginExitoso) {
            System.out.println("Usuario o contraseña incorrectos");
            
        // opcional: aumentar intentos globales si quieres
        } else {
            
        }


    }

    public static void menuHosts(Network network, Scanner lector){
        Scanner lectoor = lector;
        Network miRed = network;
        
        while (true) {
            System.out.println("Menu de usuario");
            System.out.println("1: Escanear todos los hosts de la red");
            System.out.println("2: Escanear hosts activos");
            System.out.println("3: Escanear host por IP");
            System.out.println("4: Escanear hosts por puerto");
            System.out.println("5: Cerrar sesión");
            int opcionUsuario = lectoor.nextInt();
            lector.nextLine();

            NetworkScanner escaner = new NetworkScanner(miRed);

            switch (opcionUsuario) {
                case 1:
                    escaner.scanAll(); 
                    break;
                case 2:
                    escaner.scanActive(); 
                    break;
                case 3:
                    System.out.print("Introduce la IP a buscar: ");
                    int ipABuscar = lectoor.nextInt();
                    escaner.scanByIP(ipABuscar); 
                    break;
                case 4:
                    System.out.print("Introduce el puerto a buscar: ");
                    int puertoABuscar = lectoor.nextInt();
                    escaner.scanByPort(puertoABuscar);
                    break;
                    case 5:
                    System.out.println("Cerrando sesión...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void Instrucciones(){
        System.out.println("estas en Instrucciones");
    }
}
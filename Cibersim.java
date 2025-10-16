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

            switch (opciones) {
                case 1:
                    EscanearRed(miRed, lector); 
                    break;
                case 2:
                    IniciarSesion(); 
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

    public static void IniciarSesion(){
        System.out.println("estas en Iniciar sesion");
    }

    public static void Instrucciones(){
        System.out.println("estas en Instrucciones");
    }
}

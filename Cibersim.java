import java.util.*;

public class Cibersim {
    public static void main(String[] args) {
        //haciendo el menu(todo bien basico xdd)
        while (true) {
            Scanner lector = new Scanner(System.in);
            System.out.println("----Bienvenido a CiberSim----");
            System.out.println("1: Escanear red");
            System.out.println("2: Iniciar sesion");
            System.out.println("3: Instrucciones");
            System.out.println("4: Salir");
            int opciones = lector.nextInt();

            switch (opciones) {
                case 1:
                    IniciarSesion();
                    break;
                case 2:
                    Instrucciones();
                    break;
                case 3:
                    EscanearRed();
                    break;
                case 4:
                    System.out.println("Saliendo de CiberSim... ");
                    break;
            
                default:
                    break;
            }
        }
    }

    public static void EscanearRed(){
        System.out.println("estas en Escanear red");
        NetworkScanner escaner = new NetworkScanner();
    }

    public static void IniciarSesion(){
        System.out.println("estas en Iniciar sesion");
    }

    public static void Instrucciones(){
        System.out.println("estas en Instrucciones");
    }
}

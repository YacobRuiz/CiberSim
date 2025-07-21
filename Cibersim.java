import java.util.*;

public class Cibersim {
    public static void main(String[] args) {
        //haciendo el menu(todo bien basico xdd)
        Scanner lector = new Scanner(System.in);
        System.out.println("----Bienvenido a CiberSim----");
        System.out.println("1: Escanear red");
        System.out.println("2: Iniciar sesion");
        System.out.println("3: Instrucciones");
        System.out.println("4: Salir");
        int opciones = lector.nextInt();

        if (opciones == 1) {
            EscanearRed();
        }
        else if (opciones == 2) {
                IniciarSesion();
        }
        else if (opciones == 3) {
                Instrucciones();
        }
        else if (opciones == 4) {
                Salir();
        }
    }

    public static void EscanearRed(){
        System.out.println("estas en Escanear red");
    }

    public static void IniciarSesion(){
        System.out.println("estas en Iniciar sesion");
    }

    public static void Instrucciones(){
        System.out.println("estas en Instrucciones");
    }

    public static void Salir(){
        System.out.println("Has salido");
    }
}

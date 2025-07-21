import java.util.*;

public class Host {
    //preparando para las deciciones al azar
    Random azar = new Random();
    //lista de puertos activos
    List<Integer> puertos = new ArrayList<>();

    public Integer direccionIP(){
        //creando la direccion IP
        int aleatorio = azar.nextInt(21);
        int IP = 1926280 + aleatorio;
        System.out.println(IP);
        return IP;
    }

    //Creando la cantidad y que puertos estan activos
    public List<Integer> Puertos(){
        int cantidadPuertosAbiertos = azar.nextInt(5) + 1;
        for (int j = 0; j < cantidadPuertosAbiertos; j++){
            int puertosAbiertos = azar.nextInt(100) + 1;
            puertos.add(puertosAbiertos);
        }
        System.out.println(puertos);
        return puertos;
    }

    //Decidiendo si la maquina o IP esta activa
    public Boolean ActivoInactivo(){
       int activoInactvo = azar.nextInt(2);
       if (activoInactvo == 1) {
            System.out.println("true");
            return true;
       }
       else{
        System.out.println("false");
        return false;
       }
    }

    public static void main(String[] args){
        Host pruebaHost = new Host();
        pruebaHost.direccionIP();
        pruebaHost.Puertos();
        pruebaHost.ActivoInactivo();
    }
}
    
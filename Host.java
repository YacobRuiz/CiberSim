import java.util.*;
import java.util.Arrays;

public class Host {
    private static HashSet<Integer> ips = new HashSet<>();;
    Random azar = new Random();
    LinkedList<Integer> puertos;
    boolean estado;
    int IP;

    public Host(int ipRecibida){
        //creacion de lista de puertos
        this.puertos = new LinkedList<Integer>();
        //definiendo el estado del host
        int activoInactvo = azar.nextInt(2);
        if (activoInactvo == 1) {
            this.estado = true;
        }
        else{
            this.estado = false;
        }
        
        this.IP = ipRecibida;

        //creacion de puertos y sus estados
        int cantidadPuertosAbiertos = azar.nextInt(5) + 1;
        for (int j = 0; j < cantidadPuertosAbiertos; j++){
            int puertosAbiertos = this.azar.nextInt(100) + 1;
            this.puertos.add(puertosAbiertos);
        }
    }

    public Integer direccionIP(){
        return IP;
    }

    public LinkedList<Integer> getPuertos(){
        return this.puertos;
    }

    public Boolean getEstado(){
        return this.estado;
    }

    @Override
    public String toString(){
        String resultado;
        resultado = "[" + direccionIP() + ", " +  getPuertos() + ", " + getEstado() + "]";
        return resultado;
    }
}
    
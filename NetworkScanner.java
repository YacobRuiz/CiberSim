import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NetworkScanner {
    Network redes;

    public NetworkScanner(){
        this.redes = new Network();
    }

    public Network scanAll(){
        System.out.print("Todas las redes disponibles \n" + redes + "\n");
        return this.redes;
    }

    public LinkedList<Host> scanActive(){
        LinkedList<Host> redesActivas = new LinkedList<>();
        List<Host> rNetworks = this.redes.getHosts();

        for (Host hostActual : rNetworks){
            if (hostActual.getEstado()){
                redesActivas.add(hostActual);
            }
        }
        System.out.print("Todas las redes acvtivas \n" + redesActivas+ "\n");
        return redesActivas;
    }

    /*public int scanByIP(int ip){
        for (int i = 0; i < 20; i++){
            Host actual = redes.get(i);
            if ()
        }
    }*/

    public static void main(String[] args) {
        NetworkScanner pruebaNetworkScanner = new NetworkScanner();
        pruebaNetworkScanner.scanActive();
        pruebaNetworkScanner.scanAll();
    }
}

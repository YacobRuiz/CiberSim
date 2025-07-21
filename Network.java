import java.util.*;

public class Network {
    //creando el arreglo de listas
    List<Host> hosts = new ArrayList<>();
    HashMap<Integer, Boolean> estado = new HashMap<>();

    public List<Host> Hosts(){
        for (int i = 0; i < 21; i++){
            Host host = new Host();
            hosts.add(host);
        }
        System.out.println(hosts);
        return hosts;
    }

    public static void main(String[] args) {
        Network pruebaNetwork = new Network();
        pruebaNetwork.Hosts();
    }
}

import java.util.*;

public class Network {
    //creando el arreglo de listas
    List<Host> hosts;
    private int maxHost = 20;

    public Network(){
        this.hosts = new ArrayList<>();
        
        List<Integer> ipsDisponibles = ipUnica(maxHost);
        for (int ip : ipsDisponibles){
            Host host = new Host(ip);
            hosts.add(host);
        }
    }

    public List<Integer> ipUnica(int cantidad){
        List<Integer> ips = new ArrayList<>();
        int ip = 192680;
        
        for (int i = 0; i < cantidad; i++){
            ips.add(ip + i);
        }

        Collections.shuffle(ips);
        return ips;
    }

    public List<Host> getHosts(){
        return this.hosts;
    }

    @Override
    public String toString(){
        String resultado;
        resultado = getHosts().toString();
        return resultado;
    }

    public static void main(String[] args) {
        Network pruebaNetwork = new Network();
        System.out.print(pruebaNetwork);
    }
}

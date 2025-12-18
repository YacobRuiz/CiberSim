import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NetworkScanner {
    Network redes;

    public NetworkScanner(Network redes){
        this.redes = redes;
    }

    public String scanBasic(){
        String usuariosIps = "";
        int tamañno = this.redes.getHosts().size();
        for (int i = 0; i < tamañno; i++){
            String usuatioActual = this.redes.getHosts().get(i).getUser().getUser();
            String ipActual = Integer.toString(this.redes.getHosts().get(i).direccionIP());
            usuariosIps = usuariosIps + usuatioActual + " - " + ipActual + "\n";
        }

        return usuariosIps;
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

    public Host scanByIP(int ip) {
        List<Host> todosLosHosts = this.redes.getHosts();

        for (Host hostActual : todosLosHosts) {
            if (hostActual.direccionIP() == ip) {
                System.out.println("Host encontrado: " + hostActual.toString() + "\n");
                return hostActual;
            }
        }
        System.out.println("No se encontró ningún host con la IP: " + ip + "\n");
        return null;
    }

    public LinkedList<Host> scanByPort(int puerto){
        List<Host> todosLosHosts = this.redes.getHosts();
        LinkedList<Host> hostsEncontrados = new LinkedList<>();
        for (Host hostActual : todosLosHosts) {
            if (hostActual.getPuertos().contains(puerto)) {
                hostsEncontrados.add(hostActual);
            }
        }

        System.out.println("Hosts encontrados: " + hostsEncontrados.toString());
        return hostsEncontrados;
    }
}
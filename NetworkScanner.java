import java.util.ArrayList;
import java.util.List;

public class NetworkScanner {
    public List<Host> Scann(){
        Network redes = new Network();
        List<Host> enLinea = new ArrayList<>();

        for (int i = 0; i < redes.Hosts().length; i++){
            if (redes(i).Host().ActivoInactivo() == true) {
                enLinea.add(redes(i));
            }
        }

        System.out.println(enLinea);
    }

    public static void main(String[] args) {
        NetworkScanner pruebScanner = new NetworkScanner();
        pruebScanner.Scann();
    }
}

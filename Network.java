import java.util.*;

public class Network {
    //creando el arreglo de listas
    List<Host> hosts;
    private int maxHost = 20;
    Random aleatorio;

    public Network(){
        this.hosts = new ArrayList<>();
        this.aleatorio = new Random();

        List<Integer> ipsDisponibles = ipUnica(maxHost);
        List<User> usuarioss = usuarios();
        for (int i = 0; i < maxHost; i++){
            Host host = new Host(ipsDisponibles.get(i), usuarioss.get(i));
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

    public List<User> usuarios(){
        List<User> usuario = new ArrayList<>();
        String userName = "User";
        String passWord = "pass";
        String role;

        for(int i = 0; i < maxHost; i++){
            userName = "User" + i;
            passWord = "pass" + i;
            int rol = aleatorio.nextInt(2);
            if (rol == 1) {
                role = "Admin";
            } else {
                role = "Guest";
            }

            User users = new User(userName, passWord, role);
            usuario.add(users);
        }

        Collections.shuffle(usuario);
        return usuario;
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
}
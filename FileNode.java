import java.util.ArrayList;
import java.util.List;

public class FileNode {
    private String name;
    private String tipo;
    private String contenido;
    private FileNode padre;
    private String nivelAcceso;
    private List<FileNode> children;

    public FileNode(String name, String tipo, FileNode padre, String nivelAcceso){
        this.name = name;
        this.tipo = tipo;
        this.padre = padre;
        this.nivelAcceso = nivelAcceso;
        
        if(tipo.equals("carpeta")){
            this.children = new ArrayList<>();
        } else {
            this.contenido = "";
        }
    }

    public String getName(){
        return this.name;
    }
    
    public FileNode getPadre(){
        return this.padre;
    }

    public FileNode getHijo(String hijo){
        if (this.tipo.equals("carpeta")){
            if (this.children.contains(hijo)){
                int index = this.children.indexOf(hijo);
                return this.children.get(index);
            }
        }
        return null;
    }

    public List<FileNode> getListChildren(){
        return this.children;
    }

    public String leerContenido(User usuario){
        if (this.nivelAcceso.equals("Admin")){
            if(usuario.getRole().equals("Admin")){
                return this.contenido;
            } else {
                return "Acceso denegado: Nivel de acceso insuficiente.";
            }
        }

        return this.contenido;
    }

    public void agregarHijo(FileNode hijo){
        this.children.add(hijo);
    }
}

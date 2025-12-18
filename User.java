public class User {
    private String usuario;
    private String contraseña;
    private String rol;
    private int intentosFallidos;
    private long lockUntil;

    public User(String usuario, String contraseña, String rol){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.intentosFallidos = 0;
        this.lockUntil = 0;
    }

    public String getUser(){
        return this.usuario;
    }

    public String getPassword(){
        return this.contraseña;
    }

    public String getRole(){
        return this.rol;
    }

    public int incrementoIntentosFallidos(){
        int intentos = this.intentosFallidos++;
        return intentos;
    }

    public void reinicioDeIntentosFallidos(){
        this.intentosFallidos = 0;
    }

    public int getIntentosRestantes(int maxIntentos){
        return maxIntentos - intentosFallidos;
    }

    public long getRemainingLockSeconds(){
         long ahora = System.currentTimeMillis();
        if(lockUntil > ahora){
            return (lockUntil - ahora)/1000;
        }

        return 0;
    }

    public boolean isLocked(){
        if(System.currentTimeMillis() < lockUntil){
            return true;
        }

        return false;
    }

    public void lock(long durationMillis){
        lockUntil = System.currentTimeMillis() + durationMillis;
    }

    public void unLock(){
        lockUntil = 0;
    }

    @Override
    public String toString(){
        String usuario = "UserName: " + getUser() + ", Password: " + getPassword() + ", Role: " + getRole();
        return usuario;
    }
}
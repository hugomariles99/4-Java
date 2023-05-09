
public class SistemaInterno {

    public boolean autenticar(Autenticable autenticable, String clave) {
        boolean puedeIniciarSesion = autenticable.iniciarSesion(clave);
        if (puedeIniciarSesion) {
            System.out.println("Log-in exitoso!");
            return true;
        } else {
            System.out.println("Error de log-in!");
            return false;
        }
    }
}

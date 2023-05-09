
public class Conexion implements AutoCloseable {

    public Conexion() {
        System.out.println("Abriendo conexion");
    }

    public void leerDatos() {
        System.out.println("Recibiendo datos");
        throw new IllegalStateException();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cerrando conexion");
    }
}

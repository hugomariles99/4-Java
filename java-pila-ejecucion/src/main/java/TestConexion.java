
public class TestConexion {

    public static void main(String[] args) throws Exception {

        try (Conexion con = new Conexion()) {
            con.leerDatos();
        } catch (IllegalStateException e) {
            System.out.println("-Recibiendo exception-");
            e.printStackTrace();
        }

        /*
        Conexion con = new Conexion();

        try {
            con.leerDatos();
        } catch (IllegalStateException e) {
            System.out.println("-Recibiendo exception-");
            e.printStackTrace();
        } finally {
            System.out.println("Ejecutando Finally");
            con.cerrar();
        }
         */
    }
}

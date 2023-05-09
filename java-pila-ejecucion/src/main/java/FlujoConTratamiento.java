
public class FlujoConTratamiento {

    public static void main(String[] args) {
        System.out.println("Inicio de main");
        metodo1();
        System.out.println("Fin de main");
    }

    public static void metodo1() {
        System.out.println("Inicio de metodo 1");

        try {
            metodo2();
        } catch (MiException exception) {
            exception.printStackTrace();
        }

        System.out.println("Fin de metodo 1");
    }

    private static void metodo2() {
        System.out.println("Inicio del metodo2");
        throw new MiException("Mi exception fue lanzada!");
    }
}

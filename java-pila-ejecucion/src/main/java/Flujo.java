
public class Flujo {

    public static void main(String[] args) {
        System.out.println("Inicio de main");
        metodo1();
        System.out.println("Fin de main");
    }

    public static void metodo1() {
        System.out.println("Inicio de metodo 1");
        metodo2();
        System.out.println("Fin de metodo 1");
    }

    public static void metodo2() {
        System.out.println("Inicio de metodo 2");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);

            try {

//                int num = 0;
//                int resultado = i / num;
//                System.out.println(resultado);
                String txt = null;
                System.out.println(txt.toString());

            } catch (ArithmeticException | NullPointerException exception) {
                System.out.println(exception.getMessage());
            }

        }
        System.out.println("Fin do metodo 2");
    }
}

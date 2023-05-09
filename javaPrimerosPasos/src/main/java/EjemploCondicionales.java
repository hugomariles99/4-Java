
public class EjemploCondicionales {

    public static void main(String[] args) {

        int edad = 17;
        int cantidad = 2;

        if (edad >= 18) {
            System.out.println("Usted puede entrar!");
        } else {
            if (cantidad >= 2) {
                System.out.println("Usted es menor pero puede entrar!");
            } else {
                System.out.println("Usted no puede entrar!");
            }
        }
    }
}

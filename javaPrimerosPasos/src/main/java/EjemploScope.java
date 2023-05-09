
public class EjemploScope {

    public static void main(String[] args) {

        int edad = 21;
        int cantidadPersonas = 2;

        boolean esPareja = false;
        if (cantidadPersonas > 1) {
            esPareja = true;
        } else {
            esPareja = false;
        }

        boolean puedeEntrar = edad >= 18 && esPareja;
        System.out.println("El valor de la condicon es: " + esPareja);

        if (puedeEntrar) {
            System.out.println("Usted puede entrar!");
        } else {
            System.out.println("Usted no puede entrar!");
        }

    }

}

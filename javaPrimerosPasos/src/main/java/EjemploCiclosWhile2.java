
public class EjemploCiclosWhile2 {

    public static void main(String[] args) {

        int contador = 0;
        int total = 0;

        while (contador <= 10) {
            total += contador;
            System.out.println(contador);
            contador++;
        }
        System.out.println("Total: " + total);
    }

}

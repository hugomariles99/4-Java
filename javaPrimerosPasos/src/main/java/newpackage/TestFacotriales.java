package newpackage;

public class TestFacotriales {

    public static void main(String[] args) {

        for (int numero = 1; numero <= 10; numero++) {

            int valorFactorial = 1;
            System.out.print(numero + "! = ");

            for (int factorial = 1; factorial <= numero; factorial++) {

                if (factorial == numero) {
                    System.out.print(factorial);
                } else {
                    System.out.print(factorial + " x ");
                }

                valorFactorial *= factorial;
            }

            System.out.print(" = " + valorFactorial + "\n");

        }
    }
}


public class pruebaMetodos {

    public static void main(String[] args) {

        Cuenta miCuenta = new Cuenta(300, 13);

        miCuenta.depositar(200);
        miCuenta.retirar(300);

        Cuenta otraCuenta = new Cuenta(1000, 7);
        otraCuenta.tranferir(400, miCuenta);

        System.out.println("Cuentas credas: " + Cuenta.getTotalCuentas());
    }

}

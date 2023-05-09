
public class Cuenta {

    private static int totalCuentas = 0;

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular = new Cliente();

    public Cuenta(double saldo, int agencia) {
        if (saldo < 0) {
            System.out.println("Saldo invalido");
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }

        if (agencia <= 0) {
            System.out.println("Agencia invalida");
            this.agencia = 1;
        } else {
            this.agencia = agencia;
        }

        totalCuentas++;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.out.println("Numero invalido");
        }
    }

    public static int getTotalCuentas() {
        return Cuenta.totalCuentas;
    }

    public void depositar(double valorDepositar) {
        this.saldo += valorDepositar;
        System.out.println("Deposito exitoso!");
        System.out.println("Nuevo saldo: $" + this.saldo + "\n");
    }

    public void retirar(double valorRetirar) {
        if (this.saldo >= valorRetirar) {
            this.saldo -= valorRetirar;
            System.out.println("Retiro exitoso!");
            System.out.println("Nuevo saldo: $" + this.saldo + "\n");
        } else {
            this.errorOperacion();
        }
    }

    public void tranferir(double valorTranferir, Cuenta cuenta) {
        if (this.saldo >= valorTranferir) {
            this.saldo -= valorTranferir;
            System.out.println("Tranferencia exitosa!");
            System.out.println("Nuevo saldo: $" + this.saldo + "\n");
            cuenta.depositar(valorTranferir);
        } else {
            this.errorOperacion();
        }
    }

    public void errorOperacion() {
        System.out.println("Saldo insuficiente!");
    }

}

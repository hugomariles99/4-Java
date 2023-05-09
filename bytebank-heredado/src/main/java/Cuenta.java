
public abstract class Cuenta {

    private static int totalCuentas = 0;

    protected double saldo;
    private int agencia = 1;
    private int numero;
    private Cliente titular = new Cliente();

    public Cuenta(int agencia, int numero) {
        if (agencia < 1) {
            throw new IllegalArgumentException("Agencia inválida");
        } else {
            this.agencia = agencia;
        }

        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo inválido");
        } else {
            this.saldo = saldo;
        }

        if (numero < 1) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        } else {
            this.numero = numero;
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

    public abstract void depositar(double valorDepositar);

    public void retirar(double valorRetirar) {
        if (this.saldo < valorRetirar) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
        this.saldo -= valorRetirar;
        System.out.println("Retiro exitoso!");
        System.out.println("Nuevo saldo: $" + this.saldo + "\n");
    }

    public void transferir(double valorTranferir, Cuenta cuenta) {
        if (this.saldo < valorTranferir) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
        this.retirar(valorTranferir);
        System.out.println("Tranferencia exitosa!");
        System.out.println("Nuevo saldo: $" + this.saldo + "\n");
        cuenta.depositar(valorTranferir);
    }

}

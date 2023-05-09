
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void depositar(double valorDepositar) {
        this.saldo += valorDepositar;
        System.out.println("Deposito exitoso!");
        System.out.println("Nuevo saldo: $" + this.saldo + "\n");
    }

}

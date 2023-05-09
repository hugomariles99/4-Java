
public class CuentaCorriente extends Cuenta implements Tributacion {

    public CuentaCorriente(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void retirar(double valorRetirar) {
        double comision = 0.2;
        super.retirar(valorRetirar + comision);
    }

    @Override
    public void depositar(double valorDepositar) {
        this.saldo += valorDepositar;
        System.out.println("Deposito exitoso!");
        System.out.println("Nuevo saldo: $" + this.saldo + "\n");
    }

    @Override
    public double getValorImpuesto() {
        return super.saldo * 0.01;
    }

}

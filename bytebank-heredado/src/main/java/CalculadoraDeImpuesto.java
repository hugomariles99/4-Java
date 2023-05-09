
public class CalculadoraDeImpuesto {

    private double totalImpuesto;

    public void registrar(Tributacion t) {
        this.totalImpuesto += t.getValorImpuesto();
    }

    public double getTotalImpuesto() {
        return totalImpuesto;
    }

    public void calcularImpuestos() {
        System.out.println("Impuestos: " + this.getTotalImpuesto());
    }

}

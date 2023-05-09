
public class testTributacion {
    
    public static void main(String[] args) {
        
        CuentaCorriente cc = new CuentaCorriente(1, 999);
        cc.depositar(2000);
        
        SeguroDeVida seguro = new SeguroDeVida();
        
        CalculadoraDeImpuesto calc = new CalculadoraDeImpuesto();
        
        calc.registrar(cc);
        calc.registrar(seguro);
        
        calc.calcularImpuestos();
    }
}

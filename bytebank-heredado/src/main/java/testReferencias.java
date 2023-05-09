
public class testReferencias {
    
    public static void main(String[] args) {
        
        Funcionario funcionario = new Contador();
        funcionario.setNombre("Hugo");
        
        Gerente gerente = new Gerente();
        gerente.setClave("12345");
        
        funcionario.setSalario(2000);
        gerente.setSalario(10000);
    }
}

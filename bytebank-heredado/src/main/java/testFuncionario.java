
public class testFuncionario {

    public static void main(String[] args) {
        
        Funcionario hugo = new Contador();
        hugo.setDocumento("Hugo");
        hugo.setDocumento("042799");
        hugo.setSalario(2000);
        
        System.out.println(hugo.getSalario());
        System.out.println(hugo.getBonificacion());
    }
}

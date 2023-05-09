
public class testGerente {
    
    public static void main(String[] args) {
        
        Gerente gerente = new Gerente();
        gerente.setSalario(5000);
        gerente.setTipo(2);
        gerente.setClave("12345");

        System.out.println(gerente.getBonificacion());
        System.out.println(gerente.iniciarSesion("12345"));
    }
}

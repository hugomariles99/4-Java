
public class testSistemaInterno {

    public static void main(String[] args) {

        SistemaInterno sistema = new SistemaInterno();

        Gerente gerente1 = new Gerente();
        gerente1.setClave("123");

        Administrador admin = new Administrador();
        admin.setClave("123");
        
        Cliente cliente = new Cliente();
        cliente.setClave("123");

        sistema.autenticar(gerente1, "123");
        sistema.autenticar(admin, "123");
        sistema.autenticar(cliente, "123");
    }

}

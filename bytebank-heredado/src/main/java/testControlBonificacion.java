
public class testControlBonificacion {

    public static void main(String[] args) {

        Funcionario hugo = new Contador();
        hugo.setSalario(2000);

        Gerente diana = new Gerente();
        diana.setSalario(10000);

        Contador alexis = new Contador();
        alexis.setSalario(5000);

        ControlBonificacion controlBonificacion = new ControlBonificacion();
        controlBonificacion.registrarSalario(hugo);
        controlBonificacion.registrarSalario(diana);
        controlBonificacion.registrarSalario(alexis);
    }
}

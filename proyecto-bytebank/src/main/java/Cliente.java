
public class Cliente {

    private String documento;
    private String telefono;
    private String nombre;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.length() >= 10) {
            this.telefono = telefono;
        } else {
            System.out.println("Telefono invalido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 2) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre invalido");
        }
    }

}

public class Cliente {

    // ================== ATRIBUTOS ==================
    private String nombre;
    private String identificacion;
    private String direccion;

    // ================== CONSTRUCTORES ==================
    public Cliente(String nombre, String identificacion, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    // ================== MÉTODOS PÚBLICOS ==================
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }
}

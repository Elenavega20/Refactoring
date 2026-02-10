public class Producto {

    // ================== ATRIBUTOS ==================
    private String nombre;
    private double precio;

    //========================CONSTRUCTORES=================================
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //========================MÉTODOS PÚBLICOS===============================
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

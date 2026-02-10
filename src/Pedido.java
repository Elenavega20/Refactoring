import java.util.ArrayList;

public class Pedido {

    // ================== ATRIBUTOS ==================
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private static final double IVA = 0.21;

    // ================== CONSTRUCTORES ==================
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    // ================== MÉTODOS PÚBLICOS ==================
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public double aplicarDescuentos() {
        double subtotal = calcularSubtotal();
        if (subtotal > 3000) {
            return subtotal * 0.05; // 5% descuento
        }
        return 0;
    }

    public double subtotalConDescuentos() {
        return calcularSubtotal() - aplicarDescuentos();
    }

    public double calcularTotalConIva() {
        return subtotalConDescuentos() * (1 + IVA);
    }

    public void mostrarDetallePedido() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("ID: " + cliente.getIdentificacion());

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println("Producto " + (i + 1) + ": " 
                + p.getNombre() + " - " + p.getPrecio() + " EUR");
        }

        System.out.println("Subtotal: " + calcularSubtotal());
        System.out.println("Descuento: " + aplicarDescuentos());
        System.out.println("Total con IVA: " + calcularTotalConIva());
        System.out.println("----------------------------------");
    }
}

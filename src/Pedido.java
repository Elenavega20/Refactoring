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

    public boolean aplicarDescuentos() {
        return calcularSubtotal() > 3000;
    }

    public double subtotalConDescuentos() {
        double subtotal = calcularSubtotal();
        if (aplicarDescuentos()) {
            subtotal -= subtotal * 0.05;
        }
        return subtotal;
    }

    public double calcularTotalConIva() {
        return subtotalConDescuentos() * (1 + IVA);
    }

    public void mostrarDetallePedido() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("ID: " + cliente.getIdentificacion());

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println(
                "Producto " + (i + 1) + ": "
                + p.getNombre() + " - " + p.getPrecio() + " EUR"
            );
        }

        System.out.println("Subtotal: " + calcularSubtotal());
        System.out.println(
            "Descuento: " + (aplicarDescuentos() ? calcularSubtotal() * 0.05 : 0)
        );
        System.out.println("Total con IVA: " + calcularTotalConIva());
        System.out.println("----------------------------------");
    }
}
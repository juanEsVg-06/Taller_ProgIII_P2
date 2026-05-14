import java.util.Arrays;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private double[] ventasMensuales; // Registro de los últimos 3 meses

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ventasMensuales = new double[3];
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public double[] getVentasMensuales() { return ventasMensuales; }

    public void registrarVenta(int mes, int cantidad) {
        // Validamos que el mes esté en el rango 1-3 y la cantidad sea positiva
        if (mes >= 1 && mes <= 3) {
            if (cantidad > 0) {
                double totalVenta = cantidad * this.precio;
                this.ventasMensuales[mes - 1] += totalVenta;
                System.out.printf("Registro exitoso: %d unidades x $%.2f = Total: $%.2f%n",
                        cantidad, this.precio, totalVenta);
            } else {
                System.out.println("Error: La cantidad debe ser mayor a cero.");
            }
        } else {
            System.out.println("Error: El mes debe estar entre 1 y 3.");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Producto: %-10s | Precio: $%.2f | Ventas: %s",
                id, nombre, precio, Arrays.toString(ventasMensuales));
    }
}

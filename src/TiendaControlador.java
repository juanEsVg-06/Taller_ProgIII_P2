import java.util.ArrayList;
import java.util.List;

public class TiendaControlador implements ServicioDeBusqueda {
    private List<Producto> inventario;

    public TiendaControlador() {
        this.inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        inventario.add(p);
    }

    @Override
    public int buscarPorId(int idB) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getId() == idB) return i;
        }
        return -1;
    }

    @Override
    public int buscarPorNombre(String nombre) {
        for (int i = 0; i < inventario.size(); i++) {
            // Búsqueda por cadena ignorando mayúsculas/minúsculas
            if (inventario.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public List<Producto> getInventario() {
        return inventario;
    }
}

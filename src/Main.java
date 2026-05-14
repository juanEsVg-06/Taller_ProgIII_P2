import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaControlador tienda = new TiendaControlador();

        // Inicialización de los 3 productos requeridos
        tienda.agregarProducto(new Producto(101, "Laptop", 850.00));
        tienda.agregarProducto(new Producto(102, "Mouse", 25.50));
        tienda.agregarProducto(new Producto(103, "Teclado", 45.00));

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SISTEMA DE VENTAS ONLINE ---");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Actualizar Precio");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Buscar por Nombre");
            System.out.println("5. Mostrar Todo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del producto: ");
                    int idVenta = sc.nextInt();
                    int idxV = tienda.buscarPorId(idVenta);

                    if (idxV != -1) {
                        Producto p = tienda.getInventario().get(idxV);
                        System.out.println("Producto seleccionado: " + p.getNombre() + " (Precio: $" + p.getPrecio() + ")");

                        // Validación de Mes
                        int mes;
                        do {
                            System.out.print("Mes de la venta (1, 2 o 3): ");
                            mes = sc.nextInt();
                            if (mes < 1 || mes > 3) System.out.println("(!) Mes inválido.");
                        } while (mes < 1 || mes > 3);

                        // Ingreso de Cantidad
                        System.out.print("Cantidad vendida: ");
                        int cantidad = sc.nextInt();

                        p.registrarVenta(mes, cantidad);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nombre del producto: ");
                    sc.nextLine(); // Limpiar buffer
                    String nomP = sc.nextLine();
                    int idxP = tienda.buscarPorNombre(nomP);
                    if (idxP != -1) {
                        System.out.print("Nuevo precio: ");
                        double nPrecio = sc.nextDouble();
                        tienda.getInventario().get(idxP).setPrecio(nPrecio);
                        System.out.println("Precio actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID a buscar: ");
                    int idB = sc.nextInt();
                    int resId = tienda.buscarPorId(idB);
                    System.out.println(resId != -1 ? tienda.getInventario().get(resId) : "No existe.");
                    break;

                case 4:
                    System.out.print("Nombre a buscar: ");
                    sc.nextLine();
                    String nomB = sc.nextLine();
                    int resNom = tienda.buscarPorNombre(nomB);
                    System.out.println(resNom != -1 ? tienda.getInventario().get(resNom) : "No existe.");
                    break;

                case 5:
                    tienda.getInventario().forEach(System.out::println);
                    break;

                case 6:
                    System.out.printf("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.printf("No existe esa opcion en el menu. Porfavor ingrese nuevamente.\n");
            }
        }
    }
}

public interface ServicioDeBusqueda {
    //Busqueda por ID (numerico)
    int buscarPorId(int id);

    //Busqueda por cadena (especializada en texto)
    int buscarPorNombre(String cadena);
}

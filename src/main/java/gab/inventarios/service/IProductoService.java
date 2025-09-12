package gab.inventarios.service;

import gab.inventarios.models.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();

    Producto buscarProductoPorId(Integer idProducto);

    void guardarProducto(Producto producto);

    void eliminarProducto(Integer idProducto);
}

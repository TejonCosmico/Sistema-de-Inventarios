package gab.inventarios.service;

import gab.inventarios.models.Producto;
import gab.inventarios.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRepository.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        this.productoRepository.deleteById(idProducto);
    }
}

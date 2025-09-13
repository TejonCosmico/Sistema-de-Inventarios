package gab.inventarios.controller;

import gab.inventarios.exception.ResourceNotFoundException;
import gab.inventarios.models.Producto;
import gab.inventarios.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app") // http://localhost:8080/inventario-app
@CrossOrigin(value = "http://localhost:4200") // Puerto default de Angular
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoService.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        logger.info("Producto a agregar: " + producto);
        return this.productoService.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = this.productoService.buscarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            throw new ResourceNotFoundException("No se encontro el producto con id " + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido) {
        Producto producto = this.productoService.buscarProductoPorId(id);
        producto.setNombre(productoRecibido.getNombre());
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setMarca(productoRecibido.getMarca());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setStock(productoRecibido.getStock());
        this.productoService.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id) {
        Producto producto = this.productoService.buscarProductoPorId(id);
        if (producto == null) {
            throw new ResourceNotFoundException("Id no encontrada - Id: " + id);
        }
        this.productoService.eliminarProducto(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

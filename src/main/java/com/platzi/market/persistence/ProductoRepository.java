package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // le indica a spring que esta clase se encarga de interactuar con la bd
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Producto getById(int idCategoria) {
        return (Producto) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
    }

    public Optional<Producto> getProductoById(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public Producto update(Producto newProducto, int idProducto) {
        return productoCrudRepository.findById(idProducto)
                .map(
                        producto -> {
                            producto.setCantidadStock(newProducto.getCantidadStock());
                            producto.setNombre(newProducto.getNombre());
                            producto.setCategoria(newProducto.getCategoria());
                            producto.setEstado(newProducto.getEstado());
                            producto.setCodigoBarras(newProducto.getCodigoBarras());
                            producto.setPrecioVenta(newProducto.getPrecioVenta());
                            return productoCrudRepository.save(producto);
                        }
                ).get();
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}

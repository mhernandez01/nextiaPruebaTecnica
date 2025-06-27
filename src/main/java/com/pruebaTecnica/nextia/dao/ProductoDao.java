package com.pruebaTecnica.nextia.dao;

import com.pruebaTecnica.nextia.models.Producto;

import java.util.List;

public interface ProductoDao {
    public List<Producto> getProductos();
    public Producto getProducto(Long id);
    public void deleteProducto(Long id);
    public void updateProducto(Producto producto);
    public void addProducto(Producto producto);
}

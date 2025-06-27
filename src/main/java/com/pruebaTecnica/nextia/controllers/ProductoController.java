package com.pruebaTecnica.nextia.controllers;

import com.pruebaTecnica.nextia.dao.ProductoDao;
import com.pruebaTecnica.nextia.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @RequestMapping(value = "api/producto/{id}", method = RequestMethod.GET)
    public Producto getProducto(@PathVariable Long id){
        return productoDao.getProducto(id);
    }

    @RequestMapping(value = "api/productos", method = RequestMethod.GET)
    public List<Producto> getProductos(){
        return productoDao.getProductos();
    }

    @RequestMapping(value = "api/producto", method = RequestMethod.PUT)
    public void updateProducto(@RequestBody Producto producto){
        productoDao.updateProducto(producto);
    }

    @RequestMapping(value = "api/producto/{id}", method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable Long id){
        productoDao.deleteProducto(id);
    }

    @RequestMapping(value = "api/producto", method = RequestMethod.POST)
    public void addProducto(@RequestBody Producto producto){
        productoDao.addProducto(producto);
    }
}

package com.pruebaTecnica.nextia.dao;

import com.pruebaTecnica.nextia.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductoDaoImp implements ProductoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Producto> getProductos() {
        String qry = "FROM Producto";
        return entityManager.createQuery(qry).getResultList();
    }

    @Override
    public Producto getProducto(Long id) {
        return entityManager.find(Producto.class,id);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto producto = entityManager.find(Producto.class, id);
        entityManager.remove(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        entityManager.merge(producto);
    }

    @Override
    public void addProducto(Producto producto) {
        entityManager.merge(producto);
    }
}

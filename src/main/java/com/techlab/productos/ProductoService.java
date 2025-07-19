package com.techlab.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(int id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(int id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizar(int id, Producto datos) {
        Producto prod = productoRepository.findById(id).orElseThrow();
        prod.setNombre(datos.getNombre());
        prod.setDescripcion(datos.getDescripcion());
        prod.setPrecio(datos.getPrecio());
        prod.setCategoria(datos.getCategoria());
        prod.setImagenUrl(datos.getImagenUrl());
        prod.setStock(datos.getStock());
        return productoRepository.save(prod);
    }
}

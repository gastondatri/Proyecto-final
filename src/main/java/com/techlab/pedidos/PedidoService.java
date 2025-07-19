package com.techlab.pedidos;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.productos.Producto;
import com.techlab.productos.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedido crearPedido(Pedido pedido) {
        double total = 0;
        for (LineaPedido linea : pedido.getItems()) {
            Producto producto = productoRepository.findById(linea.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + linea.getProductoId()));

            if (producto.getStock() < linea.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - linea.getCantidad());
            productoRepository.save(producto);

            linea.setPrecioUnitario(producto.getPrecio());
            linea.setNombre(producto.getNombre());
            total += linea.getPrecioUnitario() * linea.getCantidad();
        }
        pedido.setTotal(total);
        pedido.setEstado("pendiente");
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosPorUsuario(int usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }
}

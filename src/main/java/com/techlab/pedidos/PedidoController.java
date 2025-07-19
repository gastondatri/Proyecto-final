package com.techlab.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> listarPedidosUsuario(@PathVariable int usuarioId) {
        return pedidoService.listarPedidosPorUsuario(usuarioId);
    }
}

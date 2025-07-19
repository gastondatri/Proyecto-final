package com.techlab.pedidos;

import com.techlab.productos.Producto;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int usuarioId;
    private Date fecha = new Date();
    private String estado;

    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LineaPedido> items;

    // Getters y setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<LineaPedido> getItems() { return items; }
    public void setItems(List<LineaPedido> items) { this.items = items; }
}

package com.ecomarket.pedido.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.pedido.model.pedido;
import com.ecomarket.pedido.service.PedidoServicio;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    private final PedidoServicio pedidoService;
    
    public PedidoController(PedidoServicio pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @PostMapping("/crear")  // <-- Ahora el endpoint es "/api/pedidos/"
    public ResponseEntity<pedido> crearPedido(@RequestBody pedido pedido) {
        pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);  // Devuelve 200 OK en lugar de 201 CREATED
    }
    
    @GetMapping("/cliente/{clienteId}")
    public List<pedido> obtenerPedidosPorCliente(@PathVariable Long clienteId) {
        return pedidoService.obtenerPedidosPorCliente(clienteId);
    }
    
    @GetMapping("/{id}")
    public pedido obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id);
    }
}
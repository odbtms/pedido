package com.ecomarket.pedido.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomarket.pedido.model.pedido;
import com.ecomarket.pedido.repository.PedidoRepository;

import jakarta.transaction.Transactional;
@Service
public class PedidoServicio {
        private final PedidoRepository pedidoRepository;
    
    public PedidoServicio(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    
    @Transactional
    public pedido crearPedido(pedido pedido) {
        // Establecer valores por defecto
        pedido.setFechaCreacion(LocalDateTime.now());
        pedido.setEstado(pedido.estado.PENDIENTE);
        
        // Calcular total
        double total = pedido.getItems().stream()
            .mapToDouble(item -> item.getPrecioUnitario() * item.getCantidad())
            .sum();
        
        pedido.setTotal(total);
        
        return pedidoRepository.save(pedido);
    }
    
        
    
    public List<pedido> obtenerPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
    
    public pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

}

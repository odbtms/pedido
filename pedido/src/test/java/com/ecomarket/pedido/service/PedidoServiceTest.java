package com.ecomarket.pedido.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecomarket.pedido.model.EstadoPedido;
import com.ecomarket.pedido.model.pedido;
import com.ecomarket.pedido.repository.PedidoRepository;

public class PedidoServiceTest {
     @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoServicio pedidoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearPedido(){
        pedido pedidotest = new pedido();
        pedidotest.setId(1L);
        pedidotest.setClienteId(101L);
        pedidotest.setFechaCreacion(java.time.LocalDateTime.now());
        pedidotest.setEstado(EstadoPedido.PENDIENTE);
        pedidotest.setTotal(200.50);
        pedidotest.setItems(new java.util.ArrayList<>()); 

        when(pedidoRepository.save(pedidotest)).thenReturn(pedidotest);

        pedido resultado = pedidoServicio.crearPedido(pedidotest);
        assert resultado != null;
        assert resultado.getId().equals(1L);

        verify(pedidoRepository).save(pedidotest);

       
    }
    @Test
    void testObtenerPedidosPorCliente() {

        Long clienteId = 101L;

        java.util.List<pedido> pedidos = new java.util.ArrayList<>();
        pedidos.add(new pedido());

        when(pedidoRepository.findByClienteId(clienteId)).thenReturn(pedidos);

        java.util.List<pedido> resultado = pedidoServicio.obtenerPedidosPorCliente(clienteId);
        assert resultado.size() == 1;

        verify(pedidoRepository).findByClienteId(clienteId);
    }
    @Test
    void testObtenerPedidoPorId() {
        Long pedidoId = 1L;
        pedido pedidotest = new pedido();
        pedidotest.setId(pedidoId);

        when(pedidoRepository.findById(pedidoId)).thenReturn(java.util.Optional.of(pedidotest));
        pedido resultado = pedidoServicio.obtenerPedidoPorId(pedidoId);
        assert resultado != null;
        assert resultado.getId().equals(pedidoId);
        verify(pedidoRepository).findById(pedidoId);
    }
}

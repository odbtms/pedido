package com.ecomarket.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.pedido.model.pedido;

public interface PedidoRepository extends JpaRepository<pedido, Long> {
    List<pedido> findByClienteId(Long  clienteId);
}

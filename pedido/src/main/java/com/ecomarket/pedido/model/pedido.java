package com.ecomarket.pedido.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "pedidos")
@Data
@Getter
@Setter

public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long clienteId;
    
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    
    @Enumerated(EnumType.STRING)
    public EstadoPedido estado;
    
    @ElementCollection
    @CollectionTable(name = "pedido_items", joinColumns = @JoinColumn(name = "pedido_id"))
    private List<ItemPedido> items;
    
    private Double total;
    

    
}

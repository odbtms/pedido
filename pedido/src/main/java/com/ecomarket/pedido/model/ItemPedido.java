package com.ecomarket.pedido.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Embeddable  // <-- Esta anotación es crucial

public class ItemPedido {
    private String productoId;
    private Integer cantidad;
    private Double precioUnitario;
    private String descripcion;
}

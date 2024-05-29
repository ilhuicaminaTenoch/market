package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="compras")
@Setter
@Getter
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-compra")
    private Integer idCompra;

    @Column(name ="id-cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name ="medio-pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compras")
    private List<ComprasProducto> productos;
}

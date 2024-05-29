package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
@Setter
@Getter
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}

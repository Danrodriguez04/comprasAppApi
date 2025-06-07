package com.comprasapp.comprasapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Boolean bought;

    @ManyToOne
    private ShoppingList shopping;

}

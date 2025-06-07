package com.comprasapp.comprasapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDateTime creationDate;

    @ManyToOne
    private User usuario;

    @OneToMany(mappedBy = "shopping", cascade = CascadeType.ALL)
    private List<Item> items;
}

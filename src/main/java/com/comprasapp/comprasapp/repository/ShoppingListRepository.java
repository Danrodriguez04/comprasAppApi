package com.comprasapp.comprasapp.repository;

import com.comprasapp.comprasapp.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

}

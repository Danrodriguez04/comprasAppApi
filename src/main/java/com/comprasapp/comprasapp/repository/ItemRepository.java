package com.comprasapp.comprasapp.repository;

import com.comprasapp.comprasapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

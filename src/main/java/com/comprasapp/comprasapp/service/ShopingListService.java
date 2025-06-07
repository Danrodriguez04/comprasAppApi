package com.comprasapp.comprasapp.service;

import com.comprasapp.comprasapp.model.ShoppingList;
import com.comprasapp.comprasapp.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShopingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingList> findAll(ShoppingList shoppingList) {
        return this.shoppingListRepository.findAll();
    }

    public List<ShoppingList> findByUserId(Long userId) {
        return this.shoppingListRepository.findAll().stream().filter(shoppingList -> shoppingList.getUsuario().getId().equals(userId)).collect(Collectors.toList());
    }

    public ShoppingList findById(Long id) {
        return this.shoppingListRepository.findById(id).orElse(null);
    }

    public ShoppingList create(ShoppingList shoppingList) {
        return this.shoppingListRepository.save(shoppingList);
    }

    public void delete(ShoppingList shoppingList) {
        this.shoppingListRepository.delete(shoppingList);
    }
}


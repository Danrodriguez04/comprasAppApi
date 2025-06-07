package com.comprasapp.comprasapp.service;

import com.comprasapp.comprasapp.model.Item;
import com.comprasapp.comprasapp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id) {
        return this.itemRepository.findById(id).orElse(null);
    }

    public Item create(Item item) {
        return this.itemRepository.save(item);
    }

    public Item update(Item item) {
        return this.itemRepository.save(item);
    }

    public void deleteById(Long id) {
        this.itemRepository.deleteById(id);
    }


}
